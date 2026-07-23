package io.github.supermonster003.autojs6.plugin.offlinedocs

import android.content.Context
import android.content.pm.PackageInfo
import android.os.Build
import android.os.Bundle
import org.autojs.plugin.common.api.PluginCapabilityKeys
import org.autojs.plugin.common.api.PluginInfo
import org.autojs.plugin.offlinedocs.api.OfflineDocsPluginContract

internal fun Context.offlineDocsPluginInfo(): PluginInfo {
    val packageInfo = packageManager.getPackageInfo(packageName, 0)
    return PluginInfo().apply {
        name = getString(R.string.app_name)
        description = getString(R.string.plugin_description)
        instruction = resources.openRawResource(R.raw.plugin_instruction)
            .bufferedReader(Charsets.UTF_8)
            .use { it.readText().trim() }
        author = "SuperMonster003"
        versionName = packageInfo.versionName.orEmpty()
        versionCode = packageInfo.versionCodeCompat()
        versionDate = BuildConfig.VERSION_DATE
        id = OfflineDocsPluginContract.PLUGIN_ID
        engine = OfflineDocsPluginContract.ENGINE
        variant = BuildConfig.OFFLINE_DOCS_CONTENT_VERSION
        supportedAbis = emptyArray()
        capabilities = Bundle().apply {
            putLong(
                PluginCapabilityKeys.REQUIRES_HOST_VERSION,
                OfflineDocsPluginContract.REQUIRED_HOST_VERSION_CODE,
            )
            putInt(
                OfflineDocsPluginContract.META_DATA_CONTRACT_VERSION,
                OfflineDocsPluginContract.VERSION,
            )
            putString(
                OfflineDocsPluginContract.META_DATA_CONTENT_VERSION,
                BuildConfig.OFFLINE_DOCS_CONTENT_VERSION,
            )
            putString(
                OfflineDocsPluginContract.META_DATA_CONTENT_FORMAT,
                OfflineDocsPluginContract.CONTENT_FORMAT,
            )
            putString(
                OfflineDocsPluginContract.META_DATA_ASSET_ROOT,
                OfflineDocsPluginContract.ASSET_ROOT,
            )
            putString(
                OfflineDocsPluginContract.META_DATA_ENTRY_POINT,
                OfflineDocsPluginContract.ENTRY_POINT,
            )
            putInt(
                OfflineDocsPluginContract.META_DATA_FILE_COUNT,
                BuildConfig.OFFLINE_DOCS_FILE_COUNT,
            )
            putLong(
                OfflineDocsPluginContract.META_DATA_TOTAL_BYTES,
                BuildConfig.OFFLINE_DOCS_TOTAL_BYTES,
            )
            putString(
                OfflineDocsPluginContract.META_DATA_CONTENT_SHA256,
                BuildConfig.OFFLINE_DOCS_CONTENT_SHA256,
            )
        }
    }
}

private fun PackageInfo.versionCodeCompat(): Long {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) return longVersionCode
    @Suppress("DEPRECATION")
    return versionCode.toLong()
}
