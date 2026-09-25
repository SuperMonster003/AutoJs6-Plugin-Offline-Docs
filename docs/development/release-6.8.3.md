# Offline Documentation 6.8.3

Validated on 2026-09-25 for the AI Agent 1.0.0 companion release.

- Plugin version: 6.8.3, build 60. Documentation content remains 6.8.0.
- Source: AutoJs6-Documentation commit `5d3ec6e5eab6d8174581fa02bee401dcb91eacc5`.
  Both source provenance files identify that committed source tree.
- The new release contains Agent task APIs, presets, memory and global settings,
  current host/Provider requirements, and the EPUB additions since published
  6.8.0. These entries were moved out of the already released 6.8.0 section;
  its published date was restored while preserving subsequent wording edits.
- Full generation/check: 143 modules, search index 6224 entries. The complete
  online/offline asset inventories match; five unchanged historical JavaScript
  and CSS files differ only by the required LF normalization.
- Python repository/line-ending tests: 4 passed. JVM tests: 2 passed.
- Temurin debug, androidTest, signed release, exact APK inventory, content
  digest, license and metadata gates passed. Lint: 0 errors, 27 warnings.
- Redmi 12C / API 33 and API 37 / 16 KB emulator: debug contract tests each
  passed 2/2. The release APK was then installed on both devices, and the real
  AutoJs6 host verified Wake, INFO Binder metadata and validated documentation
  loading, including missing/path-traversal 404 responses.
- A first attempt to run the debug instrumentation APK directly against the
  R8 release failed before any tests because that runner expects unminified
  Kotlin classes. Release acceptance instead uses the host-side
  `CompanionReleaseSmokeTest` and `OfflineDocsPluginHostDeviceTest`.
- No ColorOS device was available; this does not claim a ColorOS activation test.

Artifact: `autojs6-plugin-offline-docs-v6.8.3-universal-7a93968d.apk`

- Bytes: 3792082
- SHA-256: `60481110fa7dc25ca57fbf520741c3168a4154d1b5622112cc422cb3896c297f`
- CRC32: `7a93968d`

The release APK has no native libraries and is architecture independent.
