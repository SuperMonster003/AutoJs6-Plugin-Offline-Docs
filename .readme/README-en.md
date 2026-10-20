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
fileCount=224
totalBytes=14691761
contentSha256=3a614c029773036bde0f0c9a8a56bf0d325d9805df2bfc6ab33a7966a8252663
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=90ca57c07495a459db49b744126664a9ecc2d525
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

# v6.8.32

###### 2026/10/20

* `Feature` Speech recognition and model management APIs for Node.js, Bun and Workers, with WAV/PCM, dictation and wake sessions, model installation/import, synthesis and cancellation cleanup

# v6.8.31

###### 2026/10/20

* `Feature` Text-to-speech APIs for Node.js, Bun and Workers, with engine and voice queries, speech, silence, audio file synthesis and task events

# v6.8.30

###### 2026/10/20

* `Improvement` Speech module reference: the speech object provided by the 3-Macaw Speech plugin, covering microphone dictation, file and PCM recognition, voice activity detection, wake words, speech synthesis and model management, the model catalog and licenses, background recording and the temporary takeover of wake sessions, error codes and limits, the digital assistant, system voice input, the system speech recognition service and the VOICE_COMMAND entry contract, plus the SpeechSession, SpeechWakeSession, SpeechRecognitionResult and SpeechModelInfo types
* `Improvement` TTS reference: voice names, language availability and the speech.speak voice selection rules of the 3-Macaw Speech engine; Plugins reference: the list of plugins that provide script modules

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
