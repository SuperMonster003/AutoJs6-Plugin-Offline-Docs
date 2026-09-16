<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Offline documentation 6.8.0 content plugin for AutoJs6</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Offline-Docs?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=534BAE&label=License"/></a>
  </p>
</div>

******

### Languages

******

The current README.md supports the following languages:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-TW.md)
- English [en] # current
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ar.md)

******

### Introduction

******

The AutoJs6 Offline Documentation plugin supplies the complete 6.8.0 documentation website as an independently installable content package.

******

### Plugin contract

******

```text
applicationId=io.github.supermonster003.autojs6.plugin.offlinedocs
pluginId=offline-docs
engine=offline-docs
variant=6.8.0
contractVersion=1
requiredHostVersionCode=5240
contentVersion=6.8.0
contentFormat=autojs6-static-html-v1
assetRoot=docs
entryPoint=index.html
inventoryFile=offline-docs-inventory-v1.txt
fileCount=185
totalBytes=10634684
contentSha256=1acb438488934ed154351c7ada39e8218fba21bf43075f9fae184c0e471c0a72
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=b20d9601fba77b1f67cb1931f42ca83f0273df6f
sourcePath=api
sourceGenerator=generator/auto-generate-for-autojs6.bat
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

OfflineDocsPluginInfoService publishes PluginInfo through IPluginInfoProvider. The host accepts the fixed package only after enablement, compatibility, signer, metadata, inventory, and file-content consistency checks pass.

******

### Content

******

The content metadata and inventory are automatically derived from the current documentation assets under `assets/docs/`. The host verifies that the metadata, inventory, and file contents are mutually consistent. The offline documentation supports full-text search across titles and page body content, with results linking directly to matching sections.

******

### Build and verification

******

Build both variants, run JVM tests, and enforce APK gates for dynamically generated content metadata, contract metadata, broken links, a single universal APK, the absence of `lib/*.so` payloads, and licenses:

```powershell
.\gradlew.bat :app:testDebugUnitTest :app:verifyOfflineDocsApks
```

Publishable release verification additionally requires the Git-ignored `sign.properties` file:

```powershell
.\gradlew.bat :app:verifyOfflineDocsPublishableApks
```

******

### Runtime behavior

******

The plugin has no standalone interface. AutoJs6 discovers and validates it on demand, then serves the documentation directly from the plugin AssetManager through its private WebView asset loader. The host detects plugin replacement or disablement.

******

### Release History

******

# v6.8.0

###### 2026/09/16

* `Fix` Offline documentation validators no longer treat the public Node bridge method name `callAutoJs` as a legacy bare product name
* `Improvement` Synchronize Flow optional steps, bounded loops, chained candidate lookup and clicks, stable collection snapshots and defaults, and update the offline search index
* `Improvement` Synchronize the runtime local network permission reference and offline search index, covering Android 17 / targetSdk 37 conditions, asynchronous authorization, retries and the raw Socket / MQTT and plugin permission boundaries
* `Improvement` Synchronize the `device.pageSize` reference and offline search index, documenting bytes, read-only access and the distinction between the runtime environment and native library compatibility
* `Improvement` Synchronized the OCR reference and offline search index with automatic engine selection, live mode reads, tap resets, per-call options and behavior when no plugin is available
* `Improvement` Synchronized the MediaInfo reference and offline search index with the legacy `read` versus versioned `snapshot` boundary, plugin snapshot v1/v2 schema negotiation, lightweight `capabilities`, and dynamic v2 track plus engine metadata
* `Improvement` Synchronized the Pinyin reference and offline search index with per-call `customDictionary` reading overrides, completed `compare`/`compact`, and Node.js access through `autojs6:bridge.callAutoJs` with the explicit `pinyin` capability
* `Improvement` Synchronized the Image Quantization v4 reference and offline search index with configurable pixel and working-memory budgets, typed resource-limit diagnostics, accounted peak-memory metrics, and cancellation on explicit requests or script shutdown
* `Improvement` Aligned the plugin versionName with the target AutoJs6 documentation version and automatically incremented each project's build/versionCode by 1 after a successful documentation sync
* `Improvement` Updated the bundled AutoJs6 6.8.0 documentation and offline search index with the YOLO target-detection Preview API, exact-provider setup, model profile, result types, and stable error codes
* `Improvement` Completed the bundled AI reference with plugin model discovery, official and exact-component selectors, multi-role message history, generation controls, precise usage and streaming payloads, and complete routing examples
* `Improvement` Extended the bundled AI reference and offline search index with the persistent `ai.session` Conversation API, fixed session controls, one-prompt-per-turn lifecycle rules, capability discovery, and explicit cleanup semantics
* `Improvement` Extended the bundled AI reference and offline search index with native JSON Schema constrained output through `structuredJson`/`responseSchema`, fixed persistent-session schemas, JSON text return semantics, and failure behavior
* `Improvement` Extended the bundled AI reference and offline search index with explicit CPU/GPU/NPU backend profiles, `ai.catalog` per-device availability and stable unavailable reasons, fixed persistent-session backend selection, GPU compatibility limits, and the no-fallback contract
* `Improvement` Replaced all unpublished AI listing and configuration-probe APIs with the unified `ai.catalog` target directory, exact `target` routing, complete response and session metadata, stable no-fallback failures, and synchronized online/offline assets
* `Improvement` Extended the bundled runtime reference and offline search index with six `loadJarWithR8` overloads for verified mapping/seeds/usage/retrace-metadata export and the protocol 1.1 `retraceR8Stack` API, including provenance binding and fail-closed no-fallback behavior
* `Improvement` Standardize the README layout and Gradle platform version management
* `Improvement` Updated the MediaInfo reference and offline search with streamNumber, countGet, infoKind and original source paths
* `Improvement` Build verification rejects accidental native dependencies and produces a JSON report

# v6.8.2

###### 2026/09/15

* `Improvement` Raise compileSdk and targetSdk to 37 (Android 17); the plugin's behavior does not depend on the new target

# v6.8.1

###### 2026/09/14

* `Improvement` Synchronize packaged-app storage guidance, including requiresSharedStorage, permission denial, settings return and launcher recovery
* `Improvement` Synchronize the Media reference and search index for Media3 music services, script playback ownership, worker-thread preparation, notification controls and packaged-app permissions
* `Improvement` Synchronize the Pangu reference and search index, covering bundled pangu.js 10.1.0, global access, text spacing and spacing checks
* `Improvement` Synchronize HTTP documentation for request-scoped isInsecure / insecure, shared client configuration, certificate trust, CT, ECH and local network permissions
* `Improvement` Synchronize the Media, Device, TTS and Settings references with Android 17 background audio conditions, silent suppression, recovery from the visible app and TTS engine process boundaries
* `Improvement` Release packages are checked for a complete signing configuration, exact APK contents and reproducible documentation

##### For more release history

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/assets/doc/CHANGELOG-en.md)

******

### License

******

Documentation originating in AutoJs6-Documentation is under Apache-2.0. The Node.js documentation template, styles, and derived content are under MIT, as are medium-zoom, docsify-copy-code, and dnt-helper. SHJS is under GPL-3.0. Lato is under OFL-1.1.

Every APK contains an attribution summary plus complete Apache-2.0, GPL-3.0, MIT, and OFL-1.1 texts under `assets/licenses/docs/`.

******

### Resource Layout

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/normalize_offline_docs.py
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
app/src/main/assets/doc/CHANGELOG-*.md
```

`strings.xml` contains localized plugin descriptions; `plugin_instruction.md` contains usage instructions displayed by the host. `.python/normalize_offline_docs.py` is a read-only validator for the generated offline documentation. README and CHANGELOG files are generated from JSON sources by `.python/generate_markdown.py`, with complete CHANGELOG output written to `app/src/main/assets/doc/`.

******

### Links

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/docs/16kb.md)
