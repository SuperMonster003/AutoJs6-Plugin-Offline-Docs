package io.github.supermonster003.autojs6.plugin.offlinedocs

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.autojs.plugin.offlinedocs.api.OfflineDocsPluginContract

class OfflineDocsContractTest {

    @Test
    fun `publishes stable compatibility contract`() {
        assertEquals("offline-docs", OfflineDocsPluginContract.PLUGIN_ID)
        assertEquals("offline-docs", OfflineDocsPluginContract.ENGINE)
        assertEquals(1, OfflineDocsPluginContract.VERSION)
        assertEquals(5240L, OfflineDocsPluginContract.REQUIRED_HOST_VERSION_CODE)
        assertEquals("docs", OfflineDocsPluginContract.ASSET_ROOT)
        assertEquals("index.html", OfflineDocsPluginContract.ENTRY_POINT)
        assertEquals("autojs6-static-html-v1", OfflineDocsPluginContract.CONTENT_FORMAT)
        assertEquals("offline-docs-inventory-v1.txt", OfflineDocsPluginContract.INVENTORY_FILE)
        assertEquals(512L, OfflineDocsPluginContract.MAX_FILE_COUNT)
        assertEquals(16L * 1024L * 1024L, OfflineDocsPluginContract.MAX_FILE_BYTES)
        assertEquals(64L * 1024L * 1024L, OfflineDocsPluginContract.MAX_TOTAL_BYTES)
        assertEquals(1024L * 1024L, OfflineDocsPluginContract.MAX_INVENTORY_BYTES)
        assertTrue(BuildConfig.OFFLINE_DOCS_CONTENT_SHA256.matches(Regex("[0-9a-f]{64}")))
    }

    @Test
    fun `build metadata matches contract`() {
        assertEquals(OfflineDocsPluginContract.VERSION, BuildConfig.OFFLINE_DOCS_CONTRACT_VERSION)
        assertEquals("6.6.4", BuildConfig.OFFLINE_DOCS_CONTENT_VERSION)
        assertEquals(161, BuildConfig.OFFLINE_DOCS_FILE_COUNT)
        assertEquals(6_996_000L, BuildConfig.OFFLINE_DOCS_TOTAL_BYTES)
        assertEquals(
            "3cb93aa2a8228a5566c6fec278f0e625886694f6fc9b57f8a36224d8f030ecf8",
            BuildConfig.OFFLINE_DOCS_CONTENT_SHA256,
        )
    }
}
