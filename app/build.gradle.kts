import org.gradle.api.GradleException
import org.gradle.api.provider.Property
import java.io.File
import java.net.URI
import java.security.MessageDigest
import java.util.Properties
import java.util.zip.ZipFile
import javax.xml.parsers.DocumentBuilderFactory

plugins {
    id("org.autojs.build.utils")
    id("org.autojs.build.versions")
    id("org.autojs.build.signs")
    id("org.autojs.build.jvm-convention")
    id("com.android.application")
}

val globalApplicationId = "io.github.supermonster003.autojs6.plugin.offlinedocs"
val offlineDocsContractVersion = 1
val offlineDocsContentVersion = "6.6.4"
val offlineDocsContentFormat = "autojs6-static-html-v1"
val offlineDocsAssetRoot = "docs"
val offlineDocsEntryPoint = "index.html"
val offlineDocsInventoryFile = "offline-docs-inventory-v1.txt"
val requiredHostVersionCode = 5240L
val supportedOfflineDocsExtensions = setOf("html", "css", "js", "png", "woff2")
val maxOfflineDocsPathLength = 1024
val maxOfflineDocsFileCount = 512
val maxOfflineDocsFileBytes = 16L * 1024L * 1024L
val maxOfflineDocsTotalBytes = 64L * 1024L * 1024L
val maxOfflineDocsInventoryBytes = 1024L * 1024L
val commonPluginApiSha256 = "6d75eb2350aa56ed412dabf84b34c0f65b9a6f6cfce3f3c23f79b9b198c24a63"
val offlineDocsApiSha256 = "958c7051ebd4db8a203ecf74471158599e9e4ea132e3347feffb120cb7b44e4a"
val docsDirectory = file("src/main/assets/$offlineDocsAssetRoot")
val docsLicenseDirectory = file("src/main/assets/licenses/docs")
val requiredLicenseAssetNames = setOf(
    "Apache-2.0.txt",
    "GPL-3.0.txt",
    "MIT.txt",
    "NOTICE.md",
    "OFL-1.1.txt",
    "SOURCE_PROVENANCE.md",
)
val knownBrokenReferences = setOf(
    "all.html -> ex-input.png",
    "all.html -> images.html",
    "all.html -> images/ex-hint.png",
    "all.html -> images/ex1-properties.png",
    "events.html -> images.html",
    "omniTypes.html -> intentOptionsType.html",
    "shizuku.html -> shellResultType.html",
    "ui.html -> ex-input.png",
    "ui.html -> images/ex-hint.png",
    "ui.html -> images/ex1-properties.png",
    "util.html -> errors.html",
    "util.html -> intl.html",
    "util.html -> process.html",
)

data class AssetRecord(val path: String, val size: Long, val sha256: String)

fun ByteArray.sha256Hex(): String = MessageDigest.getInstance("SHA-256")
    .digest(this)
    .joinToString("") { "%02x".format(it.toInt() and 0xff) }

fun File.sha256Hex(): String = inputStream().use { input ->
    val digest = MessageDigest.getInstance("SHA-256")
    val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
    while (true) {
        val count = input.read(buffer)
        if (count < 0) break
        digest.update(buffer, 0, count)
    }
    digest.digest().joinToString("") { "%02x".format(it.toInt() and 0xff) }
}

fun sourceAssetRecords(root: File): List<AssetRecord> {
    if (!root.isDirectory) throw GradleException("Offline documentation asset root is missing: $root")
    val rootPath = root.toPath().toRealPath()
    return root.walkTopDown()
        .filter(File::isFile)
        .map { source ->
            val realPath = source.toPath().toRealPath()
            if (!realPath.startsWith(rootPath)) {
                throw GradleException("Offline documentation asset escapes its root: $source")
            }
            val relative = rootPath.relativize(realPath).joinToString("/") { it.toString() }
            if (relative.isBlank() || relative.startsWith("/") || "\\" in relative || relative.split('/').any { it == ".." }) {
                throw GradleException("Unsafe offline documentation asset path: $relative")
            }
            AssetRecord(relative, source.length(), source.sha256Hex())
        }
        .sortedBy(AssetRecord::path)
        .toList()
}

fun zipAssetRecords(zip: ZipFile, prefix: String): List<AssetRecord> {
    val normalizedPrefix = prefix.trimEnd('/') + "/"
    return zip.entries().asSequence()
        .filterNot { it.isDirectory }
        .filter { it.name.startsWith(normalizedPrefix) }
        .map { entry ->
            val relative = entry.name.removePrefix(normalizedPrefix)
            if (relative.isBlank() || relative.startsWith("/") || "\\" in relative || relative.split('/').any { it == ".." }) {
                throw GradleException("Unsafe packaged offline documentation path: ${entry.name}")
            }
            val payload = zip.getInputStream(entry).use { it.readBytes() }
            AssetRecord(relative, payload.size.toLong(), payload.sha256Hex())
        }
        .sortedBy(AssetRecord::path)
        .toList()
}

fun List<AssetRecord>.inventoryBytes(): ByteArray = joinToString(separator = "") { record ->
    "${record.path}\t${record.size}\t${record.sha256}\n"
}.toByteArray(Charsets.UTF_8)

fun List<AssetRecord>.treeSha256(): String = inventoryBytes().sha256Hex()

val configuredOfflineDocsRecords = sourceAssetRecords(docsDirectory)
val offlineDocsFileCount = configuredOfflineDocsRecords.size
val offlineDocsTotalBytes = configuredOfflineDocsRecords.sumOf(AssetRecord::size)
val offlineDocsContentSha256 = configuredOfflineDocsRecords.treeSha256()

fun isSupportedOfflineDocsPath(path: String): Boolean {
    if (path.isEmpty() || path.length > maxOfflineDocsPathLength || path.startsWith('/')) return false
    if (path.any { it == '\\' || it == '\u0000' || it == '%' || it == '?' || it == '#' || it == ':' }) return false
    if (path.any { it.code < 0x20 || it.code == 0x7f }) return false
    val segments = path.split('/')
    if (segments.any { it.isEmpty() || it == "." || it == ".." }) return false
    return path.substringAfterLast('.', missingDelimiterValue = "").lowercase() in supportedOfflineDocsExtensions
}

fun verifySourceAssets(): List<AssetRecord> {
    val records = sourceAssetRecords(docsDirectory)
    if (records != configuredOfflineDocsRecords) {
        throw GradleException(
            "Offline documentation assets changed after Gradle configuration. Rerun the build.",
        )
    }
    if (records.none { it.path == offlineDocsEntryPoint }) {
        throw GradleException("Offline documentation entry point is missing: $offlineDocsEntryPoint")
    }
    if (records.size !in 1..maxOfflineDocsFileCount) {
        throw GradleException("Offline documentation file count is unsupported: ${records.size}")
    }
    records.firstOrNull { it.size !in 0L..maxOfflineDocsFileBytes }?.let {
        throw GradleException("Offline documentation asset is too large: ${it.path} (${it.size} bytes)")
    }
    val totalBytes = records.sumOf(AssetRecord::size)
    if (totalBytes !in 1L..maxOfflineDocsTotalBytes) {
        throw GradleException("Offline documentation total size is unsupported: $totalBytes bytes")
    }
    val inventoryBytes = records.inventoryBytes()
    if (inventoryBytes.size.toLong() !in 1L..maxOfflineDocsInventoryBytes) {
        throw GradleException("Offline documentation inventory is too large: ${inventoryBytes.size} bytes")
    }
    records.firstOrNull { !isSupportedOfflineDocsPath(it.path) }?.let {
        throw GradleException("Offline documentation asset path is unsupported by the host: ${it.path}")
    }
    return records
}

fun verifyLicenses() {
    val files = docsLicenseDirectory.listFiles()?.filter(File::isFile).orEmpty()
    val names = files.map(File::getName).toSet()
    if (names != requiredLicenseAssetNames) {
        throw GradleException("Unexpected offline documentation license inventory: $names")
    }
    files.firstOrNull { it.length() <= 0L }?.let {
        throw GradleException("Offline documentation license asset is empty: ${it.name}")
    }
    val contents = files.associate { it.name to it.readText(Charsets.UTF_8) }
    val requiredMarkers = mapOf(
        "Apache-2.0.txt" to "Apache License",
        "GPL-3.0.txt" to "GNU GENERAL PUBLIC LICENSE",
        "MIT.txt" to "Permission is hereby granted, free of charge",
        "OFL-1.1.txt" to "SIL OPEN FONT LICENSE",
        "NOTICE.md" to "Lato",
        "SOURCE_PROVENANCE.md" to "Source repository: `SuperMonster003/AutoJs6`",
    )
    requiredMarkers.forEach { (name, marker) ->
        if (marker !in contents.getValue(name)) {
            throw GradleException("Offline documentation license asset $name is missing marker: $marker")
        }
    }
    val sourceProvenance = contents.getValue("SOURCE_PROVENANCE.md")
    if (!Regex("""(?m)^- Source commit: `[0-9a-f]{40}`$""").containsMatchIn(sourceProvenance)) {
        throw GradleException("Offline documentation source provenance has no valid source commit")
    }
    val requiredNotices = mapOf(
        "MIT.txt" to listOf(
            "Copyright Joyent, Inc. and other Node contributors. All rights reserved.",
            "Copyright (c) 2016-present François Chalifour",
            "Copyright (c) 2017 JP Erasmus",
            "Copyright (c) 2015 Schalk Neethling",
        ),
        "OFL-1.1.txt" to listOf(
            "Copyright (c) 2010-2014 by tyPoland Lukasz Dziedzic (team@latofonts.com)",
            "Reserved Font Name \"Lato\"",
        ),
    )
    requiredNotices.forEach { (name, notices) ->
        notices.forEach { notice ->
            if (notice !in contents.getValue(name)) {
                throw GradleException("Offline documentation license asset $name is missing notice: $notice")
            }
        }
    }
}

fun resolveReference(source: File, reference: String): File? {
    val trimmed = reference.trim()
    if (trimmed.isBlank() || trimmed.startsWith('#') || trimmed.startsWith('/') || trimmed.startsWith("//")) return null
    if (Regex("^[A-Za-z][A-Za-z0-9+.-]*:").containsMatchIn(trimmed)) return null
    val withoutFragment = trimmed.substringBefore('#').substringBefore('?')
    if (withoutFragment.isBlank()) return null
    val decoded = runCatching { URI(null, null, withoutFragment, null).path }.getOrDefault(withoutFragment)
    return source.parentFile.resolve(decoded).normalize()
}

fun verifyKnownBrokenReferences() {
    val rootPath = docsDirectory.toPath().toAbsolutePath().normalize()
    val htmlReference = Regex("""\b(?:href|src)\s*=\s*[\"']([^\"']+)[\"']""", RegexOption.IGNORE_CASE)
    val cssReference = Regex("""url\(\s*[\"']?([^\"')]+)[\"']?\s*\)""", RegexOption.IGNORE_CASE)
    val missing = mutableSetOf<String>()
    docsDirectory.walkTopDown().filter(File::isFile).forEach { source ->
        val regex = when (source.extension.lowercase()) {
            "html" -> htmlReference
            "css" -> cssReference
            else -> return@forEach
        }
        regex.findAll(source.readText(Charsets.UTF_8)).forEach { match ->
            val rawReference = match.groupValues[1]
            val target = resolveReference(source, rawReference) ?: return@forEach
            val targetPath = target.toPath().toAbsolutePath().normalize()
            if (!targetPath.startsWith(rootPath) || !target.isFile) {
                val sourceRelative = rootPath.relativize(source.toPath().toAbsolutePath().normalize())
                    .joinToString("/") { it.toString() }
                missing += "$sourceRelative -> ${rawReference.substringBefore('#').substringBefore('?')}"
            }
        }
    }
    val unexpected = missing - knownBrokenReferences
    if (unexpected.isNotEmpty()) {
        throw GradleException(
            "Offline documentation contains unexpected broken references: $unexpected",
        )
    }
    val resolved = knownBrokenReferences - missing
    if (resolved.isNotEmpty()) {
        println("Offline documentation fixed known broken references: $resolved")
    }
}

fun collectApkFiles(root: File, destination: MutableList<File>) {
    root.listFiles()?.sortedBy(File::getName)?.forEach { child ->
        when {
            child.isDirectory -> collectApkFiles(child, destination)
            child.isFile && child.extension.equals("apk", ignoreCase = true) -> destination += child
        }
    }
}

fun findApkAnalyzer(sdkDirectory: File): File {
    val candidates = sdkDirectory.resolve("cmdline-tools").listFiles()
        .orEmpty()
        .map { it.resolve("bin/${if (System.getProperty("os.name").startsWith("Windows")) "apkanalyzer.bat" else "apkanalyzer"}") }
        .filter(File::isFile)
    return candidates.maxByOrNull { it.parentFile.parentFile.name.toIntOrNull() ?: Int.MIN_VALUE }
        ?: throw GradleException("apkanalyzer was not found under ${sdkDirectory.resolve("cmdline-tools")}")
}

fun dumpApkManifest(apk: File, sdkDirectory: File): String {
    val analyzer = findApkAnalyzer(sdkDirectory)
    val command = if (System.getProperty("os.name").startsWith("Windows")) {
        listOf("cmd.exe", "/d", "/c", analyzer.absolutePath, "manifest", "print", apk.absolutePath)
    } else {
        listOf(analyzer.absolutePath, "manifest", "print", apk.absolutePath)
    }
    val process = ProcessBuilder(command).redirectErrorStream(true).start()
    val output = process.inputStream.bufferedReader(Charsets.UTF_8).use { it.readText() }
    if (process.waitFor() != 0) throw GradleException("Unable to inspect ${apk.name} manifest:\n$output")
    val start = output.indexOf("<manifest")
    val end = output.indexOf("</manifest>", start)
    if (start < 0 || end < 0) throw GradleException("apkanalyzer returned no complete manifest for ${apk.name}")
    return output.substring(start, end + "</manifest>".length)
}

fun directMetaData(element: org.w3c.dom.Element): Map<String, String> {
    val androidNamespace = "http://schemas.android.com/apk/res/android"
    val result = linkedMapOf<String, String>()
    val children = element.childNodes
    for (index in 0 until children.length) {
        val child = children.item(index) as? org.w3c.dom.Element ?: continue
        if (child.tagName == "meta-data") {
            result[child.getAttributeNS(androidNamespace, "name")] =
                child.getAttributeNS(androidNamespace, "value")
        }
    }
    return result
}

fun verifyManifestMetadata(apk: File, sdkDirectory: File) {
    val androidNamespace = "http://schemas.android.com/apk/res/android"
    val document = DocumentBuilderFactory.newInstance().apply { isNamespaceAware = true }
        .newDocumentBuilder()
        .parse(dumpApkManifest(apk, sdkDirectory).byteInputStream(Charsets.UTF_8))
    val manifest = document.documentElement
    if (manifest.getAttribute("package") != globalApplicationId) {
        throw GradleException("${apk.name} has an unexpected application id")
    }
    val application = document.getElementsByTagName("application").item(0) as? org.w3c.dom.Element
        ?: throw GradleException("${apk.name} has no application manifest element")
    val service = (0 until application.childNodes.length)
        .mapNotNull { application.childNodes.item(it) as? org.w3c.dom.Element }
        .firstOrNull {
            it.tagName == "service" &&
                it.getAttributeNS(androidNamespace, "name").endsWith(".OfflineDocsPluginInfoService")
        } ?: throw GradleException("${apk.name} has no Offline Documentation info service")
    if (service.getAttributeNS(androidNamespace, "permission") != "org.autojs.permission.PLUGIN" ||
        service.getAttributeNS(androidNamespace, "exported") != "true"
    ) {
        throw GradleException("${apk.name} exposes the plugin service without the expected protection")
    }
    val expected = mapOf(
        "org.autojs.plugin.offlinedocs.CONTRACT_VERSION" to offlineDocsContractVersion.toString(),
        "org.autojs.plugin.offlinedocs.CONTENT_VERSION" to offlineDocsContentVersion,
        "org.autojs.plugin.offlinedocs.CONTENT_FORMAT" to offlineDocsContentFormat,
        "org.autojs.plugin.offlinedocs.ASSET_ROOT" to offlineDocsAssetRoot,
        "org.autojs.plugin.offlinedocs.ENTRY_POINT" to offlineDocsEntryPoint,
        "org.autojs.plugin.offlinedocs.FILE_COUNT" to offlineDocsFileCount.toString(),
        "org.autojs.plugin.offlinedocs.TOTAL_BYTES" to offlineDocsTotalBytes.toString(),
        "org.autojs.plugin.offlinedocs.CONTENT_SHA256" to offlineDocsContentSha256,
        "requiresHostVersion" to requiredHostVersionCode.toString(),
    )
    for ((scope, metadata) in mapOf(
        "application" to directMetaData(application),
        "service" to directMetaData(service),
    )) {
        for ((name, value) in expected) {
            if (metadata[name] != value) {
                throw GradleException("${apk.name} $scope metadata mismatch for $name: ${metadata[name]}")
            }
        }
    }
    val actions = service.getElementsByTagName("action").let { nodes ->
        (0 until nodes.length).mapNotNull { nodes.item(it) as? org.w3c.dom.Element }
            .map { it.getAttributeNS(androidNamespace, "name") }
            .toSet()
    }
    val categories = service.getElementsByTagName("category").let { nodes ->
        (0 until nodes.length).mapNotNull { nodes.item(it) as? org.w3c.dom.Element }
            .map { it.getAttributeNS(androidNamespace, "name") }
            .toSet()
    }
    if (actions != setOf("org.autojs.plugin.INFO", "org.autojs.plugin.OFFLINE_DOCS") ||
        categories != setOf("offline-docs")
    ) {
        throw GradleException("${apk.name} has an unexpected plugin action/category contract")
    }
}

fun verifyOfflineDocsApk(apk: File, expectedRecords: List<AssetRecord>) {
    ZipFile(apk).use { zip ->
        val nativeEntries = zip.entries().asSequence()
            .filterNot { it.isDirectory }
            .map { it.name }
            .filter { it.startsWith("lib/") && it.endsWith(".so") }
            .toSet()
        if (nativeEntries.isNotEmpty()) {
            throw GradleException("Offline Documentation APK must not contain native libraries: $nativeEntries")
        }
        val packagedRecords = zipAssetRecords(zip, "assets/$offlineDocsAssetRoot")
        if (packagedRecords != expectedRecords || packagedRecords.treeSha256() != offlineDocsContentSha256) {
            throw GradleException("Offline Documentation content differs in ${apk.name}")
        }
        val inventoryEntryPath = "assets/$offlineDocsInventoryFile"
        val inventoryEntry = zip.getEntry(inventoryEntryPath)
            ?: throw GradleException("Offline Documentation inventory is missing in ${apk.name}")
        val packagedInventory = zip.getInputStream(inventoryEntry).use { it.readBytes() }
        val expectedInventory = expectedRecords.inventoryBytes()
        if (!packagedInventory.contentEquals(expectedInventory) ||
            packagedInventory.sha256Hex() != offlineDocsContentSha256
        ) {
            throw GradleException("Offline Documentation inventory differs in ${apk.name}")
        }
        val packagedLicenseNames = zip.entries().asSequence()
            .filterNot { it.isDirectory }
            .map { it.name }
            .filter { it.startsWith("assets/licenses/docs/") }
            .map { it.removePrefix("assets/licenses/docs/") }
            .toSet()
        if (packagedLicenseNames != requiredLicenseAssetNames) {
            throw GradleException("Unexpected license assets in ${apk.name}: $packagedLicenseNames")
        }
    }
}

fun verifyOfflineDocsVariantApk(variantName: String, apkDirectory: File, sdkDirectory: File) {
    val expectedRecords = verifySourceAssets()
    verifyKnownBrokenReferences()
    verifyLicenses()
    val commonApiHash = file("$rootDir/libs/common-plugin-api.aar").sha256Hex()
    if (commonApiHash != commonPluginApiSha256) {
        throw GradleException("Common plugin API AAR fingerprint mismatch: $commonApiHash")
    }
    val offlineDocsApiHash = file("$rootDir/libs/offline-docs-api.aar").sha256Hex()
    if (offlineDocsApiHash != offlineDocsApiSha256) {
        throw GradleException("Offline Documentation API AAR fingerprint mismatch: $offlineDocsApiHash")
    }
    val apkFiles = mutableListOf<File>()
    collectApkFiles(apkDirectory, apkFiles)
    if (apkFiles.size != 1) {
        throw GradleException("Offline Documentation must produce exactly one $variantName APK: $apkFiles")
    }
    val apk = apkFiles.single()
    if (!apk.name.endsWith("-universal.apk")) {
        throw GradleException("Offline Documentation APK is not named as a universal artifact: ${apk.name}")
    }
    verifyManifestMetadata(apk, sdkDirectory)
    verifyOfflineDocsApk(apk, expectedRecords)
    println(
        "Verified Offline Documentation $variantName APK: ${apk.name} " +
            "(${expectedRecords.size} files, ${expectedRecords.sumOf(AssetRecord::size)} bytes, ${expectedRecords.treeSha256()})",
    )
}

val generatedOfflineDocsAssetsDirectory = layout.buildDirectory.dir("generated/offlineDocsAssets")
val generatedOfflineDocsInventoryFile = generatedOfflineDocsAssetsDirectory.map {
    it.file(offlineDocsInventoryFile)
}
val generateOfflineDocsInventory = tasks.register("generateOfflineDocsInventory") {
    group = "build"
    description = "Generates the signed Offline Documentation content inventory"
    inputs.dir(docsDirectory)
    outputs.file(generatedOfflineDocsInventoryFile)

    doLast {
        val records = verifySourceAssets()
        val inventoryBytes = records.inventoryBytes()
        if (inventoryBytes.sha256Hex() != offlineDocsContentSha256) {
            throw GradleException("Generated Offline Documentation inventory hash is inconsistent")
        }
        generatedOfflineDocsInventoryFile.get().asFile.apply {
            parentFile.mkdirs()
            writeBytes(inventoryBytes)
        }
    }
}

var isSignsValid = false

android {
    namespace = globalApplicationId
    compileSdk = versions.sdkVersionCompile

    defaultConfig {
        applicationId = globalApplicationId
        minSdk = versions.sdkVersionMin
        targetSdk = versions.sdkVersionTarget
        versionCode = versions.appVersionCode
        versionName = versions.appVersionName

        buildConfigField("String", "VERSION_DATE", "\"${utils.getDateString("MMM d, yyyy", "GMT+08:00")}\"")
        buildConfigField("int", "OFFLINE_DOCS_CONTRACT_VERSION", offlineDocsContractVersion.toString())
        buildConfigField("String", "OFFLINE_DOCS_CONTENT_VERSION", "\"$offlineDocsContentVersion\"")
        buildConfigField("int", "OFFLINE_DOCS_FILE_COUNT", offlineDocsFileCount.toString())
        buildConfigField("long", "OFFLINE_DOCS_TOTAL_BYTES", "${offlineDocsTotalBytes}L")
        buildConfigField("String", "OFFLINE_DOCS_CONTENT_SHA256", "\"$offlineDocsContentSha256\"")

        manifestPlaceholders["offlineDocsContractVersion"] = offlineDocsContractVersion
        manifestPlaceholders["offlineDocsContentVersion"] = offlineDocsContentVersion
        manifestPlaceholders["offlineDocsContentFormat"] = offlineDocsContentFormat
        manifestPlaceholders["offlineDocsAssetRoot"] = offlineDocsAssetRoot
        manifestPlaceholders["offlineDocsEntryPoint"] = offlineDocsEntryPoint
        manifestPlaceholders["offlineDocsFileCount"] = offlineDocsFileCount
        manifestPlaceholders["offlineDocsTotalBytes"] = offlineDocsTotalBytes
        manifestPlaceholders["offlineDocsContentSha256"] = offlineDocsContentSha256
        manifestPlaceholders["offlineDocsRequiredHostVersion"] = requiredHostVersionCode
    }

    signingConfigs {
        val props = Properties().also { properties ->
            File("${project.rootDir}/sign.properties").takeIf(File::exists)?.let { signFile ->
                signFile.inputStream().use(properties::load)
                isSignsValid = properties.isNotEmpty()
            }
        }
        if (isSignsValid) {
            create("release") {
                val configuredStoreFile = props.getProperty("storeFile")
                storeFile = configuredStoreFile?.let { configured ->
                    val path = File(configured)
                    when {
                        path.isAbsolute -> path
                        rootProject.file(configured).isFile -> rootProject.file(configured)
                        else -> project.file(configured)
                    }
                }
                keyPassword = props.getProperty("keyPassword")
                keyAlias = props.getProperty("keyAlias")
                storePassword = props.getProperty("storePassword")
            }
        }
    }

    buildTypes {
        val releaseSigningConfig = takeIf { isSignsValid }?.let { signingConfigs.getByName("release") }
        debug {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            releaseSigningConfig?.let { signingConfig = it }
        }
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            releaseSigningConfig?.let { signingConfig = it }
        }
    }

    buildFeatures { buildConfig = true }

    sourceSets.getByName("main").assets.directories.add(
        generatedOfflineDocsAssetsDirectory.get().asFile.absolutePath,
    )
}

androidComponents {
    onVariants { variant ->
        variant.outputs.forEach { output ->
            val outputFileNameProperty = output.javaClass.methods.firstOrNull {
                it.name == "getOutputFileName" && it.parameterTypes.isEmpty()
            }?.invoke(output) as? Property<*>
            @Suppress("UNCHECKED_CAST")
            (outputFileNameProperty as? Property<String>)?.set(
                output.versionName.map { versionName ->
                    "${rootProject.name}-v$versionName-universal.apk".lowercase()
                },
            )
        }
    }
}

dependencies {
    implementation(files("$rootDir/libs/common-plugin-api.aar"))
    implementation(files("$rootDir/libs/offline-docs-api.aar"))
    testImplementation(libs.junit)
}

tasks {
    withType(JavaCompile::class.java) { options.encoding = "UTF-8" }
    named("preBuild") { dependsOn(generateOfflineDocsInventory) }

    val verificationTasks = listOf("Debug" to "debug", "Release" to "release").map { (title, name) ->
        register("verifyOfflineDocs${title}Apk") {
            group = "verification"
            description = "Verifies the $name Offline Documentation universal APK"
            dependsOn("assemble$title")
            if (title == "Debug") dependsOn("testDebugUnitTest")
            inputs.files(
                file("$rootDir/libs/common-plugin-api.aar"),
                file("$rootDir/libs/offline-docs-api.aar"),
            )
            inputs.dir(docsDirectory)
            inputs.dir(docsLicenseDirectory)

            doLast {
                verifyOfflineDocsVariantApk(
                    variantName = name,
                    apkDirectory = layout.buildDirectory.dir("outputs/apk/$name").get().asFile,
                    sdkDirectory = androidComponents.sdkComponents.sdkDirectory.get().asFile,
                )
            }
        }
    }

    register("verifyOfflineDocsApks") {
        group = "verification"
        description = "Verifies debug and release Offline Documentation APK artifacts"
        dependsOn(verificationTasks)
    }

    val verifyReleaseSigning = register("verifyOfflineDocsReleaseSigning") {
        group = "verification"
        description = "Requires a configured signing identity for publishable release APKs"
        dependsOn("assembleRelease")
        doLast {
            if (!isSignsValid) {
                throw GradleException(
                    "Offline Documentation release APK is unsigned. Configure the ignored sign.properties before publishing.",
                )
            }
        }
    }

    register("verifyOfflineDocsPublishableApks") {
        group = "verification"
        description = "Verifies Offline Documentation APK payloads and signed release artifacts"
        dependsOn("verifyOfflineDocsApks", verifyReleaseSigning)
    }

    register<Copy>("appendDigestToReleasedFiles") {
        val buildTypeRelease = "release"
        val ext = utils.FILE_EXTENSION_APK
        val dst = "${buildTypeRelease}s"
        from(file(buildTypeRelease)) {
            include("*.$ext")
            eachFile {
                val suffix = ".$ext"
                val digest = utils.digestCRC32(file)
                name = "${name.removeSuffix(suffix)}-$digest$suffix"
            }
        }
        into(dst)
        includeEmptyDirs = false
        duplicatesStrategy = DuplicatesStrategy.FAIL

        doLast { println("Destination: ${file(dst)}") }
    }
}
