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
contentVersion=6.6.4
contentFormat=autojs6-static-html-v1
assetRoot=docs
entryPoint=index.html
inventoryFile=offline-docs-inventory-v1.txt
fileCount=161
totalBytes=6996000
contentSha256=3cb93aa2a8228a5566c6fec278f0e625886694f6fc9b57f8a36224d8f030ecf8
sourceRepository=SuperMonster003/AutoJs6
sourceCommit=37190cd9681b9d4bdc8e786f146b1b88f7818dc2
sourcePath=app/src/main/assets-app/docs
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

OfflineDocsPluginInfoService publishes PluginInfo through IPluginInfoProvider. The host accepts the fixed package only after enablement, compatibility, signer, metadata, inventory, and file-content consistency checks pass.

******

### Content

******

The content metadata and inventory are automatically derived from the current documentation assets under `assets/docs/`. The host verifies that the metadata, inventory, and file contents are mutually consistent.

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

# v1.0.1

###### 2026/07/23

* `Improvement` Replaced the fixed content fingerprint baseline with content metadata and an inventory generated automatically from the current documentation assets, allowing the assets to be updated directly

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
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
app/src/main/assets/doc/CHANGELOG-*.md
```

`strings.xml` contains localized plugin descriptions; `plugin_instruction.md` contains usage instructions displayed by the host. README and CHANGELOG files are generated from JSON sources by `.python/generate_markdown.py`, with complete CHANGELOG output written to `app/src/main/assets/doc/`.

******

### Links

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)
