<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Offline documentation 6.6.4 content plugin for AutoJs6</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Offline-Docs?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=A24232&label=Issues"/></a>
    <br>
    <a href="https://developer.android.com/studio/archive"><img alt="Android Studio" src="https://img.shields.io/badge/Android%20Studio-2023.3+-B64FC8"/></a>
    <a href="https://www.jetbrains.com/idea/download/other.html"><img alt="IntelliJ IDEA" src="https://img.shields.io/badge/IntelliJ%20IDEA-2023.3+-EE4677"/></a>
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

The AutoJs6 Offline Documentation plugin supplies the complete 6.6.4 documentation website as an independently installable content package.

******

### Plugin contract

******

```text
applicationId=io.github.supermonster003.autojs6.plugin.offlinedocs
pluginId=offline-docs
engine=offline-docs
variant=6.6.4
contractVersion=1
requiredHostVersionCode=5240
contentVersion=6.8.0
contentFormat=autojs6-static-html-v1
assetRoot=docs
entryPoint=index.html
inventoryFile=offline-docs-inventory-v1.txt
fileCount=181
totalBytes=10032472
contentSha256=88502a147c30a2f5e53e2d1aee779c420b9af11a8de3d9400b1324f5699561c9
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=fc3a420e04dd27a4015cf331179685dea89c503c
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

###### 2026/08/21

* `Improvement` Aligned the plugin versionName with the target AutoJs6 documentation version and automatically incremented each project's build/versionCode by 1 after a successful documentation sync
* `Improvement` Updated the bundled AutoJs6 6.8.0 documentation and offline search index with the YOLO target-detection Preview API, exact-provider setup, model profile, result types, and stable error codes
* `Improvement` Completed the bundled AI reference with plugin model discovery, official and exact-component selectors, multi-role message history, generation controls, precise usage and streaming payloads, and complete routing examples
* `Improvement` Extended the bundled AI reference and offline search index with the persistent `ai.session` Conversation API, fixed session controls, one-prompt-per-turn lifecycle rules, capability discovery, and explicit cleanup semantics
* `Improvement` Extended the bundled AI reference and offline search index with native JSON Schema constrained output through `structuredJson`/`responseSchema`, fixed persistent-session schemas, JSON text return semantics, and failure behavior

# v1.0.1

###### 2026/07/25

* `Improvement` Replaced the fixed content fingerprint baseline with content metadata and an inventory generated automatically from the current documentation assets, allowing the assets to be updated directly
* `Improvement` Generated and synchronized the offline documentation from the official AutoJs6 Markdown sources, keeping the online and offline content aligned
* `Improvement` Aligned the built-in documentation with the AutoJs6 API reference style and standardized the current product name, JavaScript variable declarations, local type links, incomplete-section notices, and ASCII punctuation
* `Improvement` Improved offline documentation navigation with full-text search across titles and content and direct jumps to matching sections

# v1.0.0

###### 2026/07/23

* `Feature` Released the standalone AutoJs6 6.6.4 Offline Documentation content plugin with contract version 1 discovery and one universal APK
* `Feature` Packaged 161 documentation files with localized plugin metadata and complete Apache-2.0, GPL-3.0, MIT, and OFL-1.1 notices
* `Improvement` Added JVM and APK gates for the canonical content fingerprint, contract metadata, known broken-link baseline, single universal artifact, absence of `lib/*.so` payloads, and license assets
* `Improvement` Recorded the exact AutoJs6 source commit and source path for the byte-for-byte documentation payload

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
