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
fileCount=219
totalBytes=13916002
contentSha256=359a9fd29824cc4af0cedd2facaa87ca059d8da879907d504522d9ef4717d638
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=bd95e545c7fa02dfabbc2ba8d13a3917d2d32a85
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

# v6.8.8

###### 2026/10/17

* `Feature` Node.js/Bun images supports advanced filters, color conversion, multi-color searches, circles, similarity metrics and URL loading
* `Feature` Node.js/Bun images supports SIFT/ORB extraction and matching with scene coordinates, ObjectFrame geometry and execution-owned Mat/feature handles
* `Feature` Node.js/Bun images supports PNG quantization and compression with quality/memory metrics, binary results and descriptor-backed file output

# v6.8.7

###### 2026/10/17

* `Feature` Node.js main thread and Workers support H.264 MP4 recording with microphone, playback or mixed AAC audio, concurrent screenshots and cleanup of unsaved Worker recordings (API / TypeScript / Ace)

# v6.8.6

###### 2026/10/17

* `Fix` README documentation source commit differing from the packaged provenance record
* `Improvement` Bun screenRecorder writes H.264 MP4 with optional microphone, app-playback or mixed AAC audio and screenshots during recording, with independent audio grants and cancellation cleanup (API documentation)
* `Improvement` Bun screenRecorder records silent H.264 MP4 files with a separate opt-in grant, fixed output dimensions, explicit finalization and cancellation cleanup (API documentation)
* `Improvement` Node.js Workers support pinyin, pinyin4j, console controls and coordinate conversion, sharing the parent execution while retaining native output streams (API documentation)
* `Improvement` Runtime API documentation for Bun screen capture consent and Node.js Worker OpenCC/image modules
* `Improvement` Node.js and Bun OpenCC and image API reference, including asynchronous handles, pixel formats, permissions and transport limits
* `Improvement` Rhino speech API reference: recognition, wake and dictation sessions, voice activity, synthesis and speech.models management
* `Improvement` Node.js and Bun runtime API guide covering asynchronous pinyin, console controls, screen coordinates and editor declaration boundaries
* `Improvement` Installer source/package-prefix profiles, explicit-option precedence and three nullable resets, sourceDeleteRequested and shared batch-source retention; requires host 5312+ and matching plugin support
* `Improvement` Documentation and offline search entries for the minDepth/maxDepth/minIndexInParent/maxIndexInParent selector methods
* `Improvement` Complete 3-Block Compose API reference: nodes and state, modifiers, themes, sessions and floating windows, component properties and events, threading, accessibility and packaged applications
* `Improvement` 3-Block Compose TSX: TSX supports `<compose.Column>`, `<compose:Text>`, references to node factories, fragments, slots and reactive callbacks; a single tree cannot mix Compose and legacy XML nodes
* `Improvement` Terminal module reference: synchronous and asynchronous sessions of the 3-Shell Terminal plugin, output events, npm scripts, permissions and lifecycle, plus the TerminalSession, TerminalOpenOptions and TerminalError types
* `Improvement` colors module reference: OKLab/OKLCH conversion, contrast adjustment, harmonies, tonal scales, derived colors, night variants, color vision deficiency simulation, dominant image colors, the oklab detection algorithm and colors.theme theme color control
* `Improvement` Plugin Center icons use the sizes, positions, light and dark artwork, and circular backgrounds adjusted in Icon Studio, retaining reproducible sources and parameters
* `Improvement` Android App info icons share Icon Studio artwork and light/dark backgrounds while preserving transparent Plugin Center artwork and existing launcher choices
* `Improvement` 3-Block Compose: XML `<compose>` containers and compose.attach embed independent Compose sessions in UI pages or legacy floating windows; compose.AndroidView embeds an existing Android View or one returned by a synchronous factory
* `Improvement` 3-Block Compose reference covers independent dialogs and bottom sheets, cancellation rules, overlay permission and session lifecycle
* `Improvement` 3-Block Compose V2 component reference covering controlled state, events, focus and scrolling commands, requirements and compatibility
* `Improvement` Device API reference: device.getAndroidId accepts a useSystemId boolean to read the system value for the app's Android user through Shizuku/Root on Android 8.0+, throws on permission or read failure, and ignores the flag on older systems
* `Improvement` AutoJs4 Runtime reference: purpose of the AutoJs4 Runtime plugin, installation and its separate permissions, the file manager "Run with AutoJs4" entry for .js / .auto files and project folders, log forwarding and task stopping, runtime limits and how to report differences
* `Improvement` AutoJs4 Runtime reference: comparison mode of "Run with AutoJs4 and compare", covering the two runs, the stripped framing lines and prefix, the summary and diff markers of the result page, the issue template copy and the 120-second timeout
* `Improvement` AutoJs4 Runtime reference: new "com.stardust compatibility classes" section explaining how com.stardust class names map to the AutoJs6 implementations (fully mapped, partially mapped and no longer provided), how renamed mappings affect the importClass global name, and that Class.forName is not affected
* `Improvement` 3-Block Compose Designer reference: entries and project files of the visual designer built into the plugin, the editor's canvas / outline / properties / state / component palette, its portrait and landscape layouts and drafts, the recognized script subset and round-trip rules, the two-way hand-over with the AutoJs6 editor, writing back to and re-importing from an imported source, preview state and the interactive preview with how they differ from a real run, TSX projects (parsed by TypeScript Engine, read-only without it), running a JavaScript project's script in the interactive preview's sandbox with its console (Android 8.0 or later), UI (XML) projects (since 1.6.0: editing the XML layouts of ui mode scripts in place, a canvas drawn by the AutoJs6 preview service, handler stubs and the bindings panel), and current limitations; from 1.7.0 the interactive preview of UI (XML) projects has AutoJs6 run the whole script for real (Android 13 and later), with a new section on running UI scripts in the preview: conditions, stop rules, the console and the differences from a real run; from 1.8.0 two new sections: "Preview Differences" (lines that behave differently in the preview than in AutoJs6) and "XML files and folder projects" (XML layout files referenced by literal paths, Save as / New XML file, folder projects with a project.json, zip import and export, handing them to AutoJs6 to run or import, the folder grant of external documents, the project's files in previews, editing and checking Android XML)
* `Improvement` Android XML attributes reference: for native Android XML UI layouts, the android: / app: attributes each View class can and cannot set, their value formats, enum and flag names, first API level and how they are set, and the layout parameters each parent takes; the user interface reference adds project resources (the res/ folder, qualifier folders and vector drawables)
* `Improvement` [API reference](https://docs.autojs6.com/#/documentation) covers missing Files and RootAutomator members, color result arrays, WebView contexts and optional overloads, and corrects byte append, swipe parameters and coordinate scaling descriptions; explains that failed setScaleBases calls neither change nor consume scale bases, and documents integer conversion by the base setters
* `Improvement` Gallery module reference: the gallery object provided by the 3-Maple Image plugin, covering the picker, viewer sessions, editing and headless conversion, the host-owned file boundary, photo access and error codes, plus the GalleryViewSession type
* `Improvement` files.batchRename reference: batch renaming provided by the Batch Rename plugin, covering plan preview and per-item exclusion, applying, undo and batch history, options and replacement variables, conflict policies, result objects and error codes
* `Improvement` plugins.tools reference: the tools AutoJs6 plugins describe themselves, including listing tools and providers, synchronous and asynchronous calls, image / file arguments and output files, result objects and errors

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
