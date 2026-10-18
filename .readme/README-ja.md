<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>AutoJs6 用オフラインドキュメント 6.8.0 コンテンツプラグイン</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Offline-Docs?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=534BAE&label=License"/></a>
  </p>
</div>

******

### 言語 (Languages)

******

現在の README.md は次の言語に対応しています:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-es.md)
- 日本語 [ja] # 現在
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ar.md)

******

### 概要

******

AutoJs6 Offline Documentation プラグインは完全な 6.8.0 ドキュメントサイトを個別にインストールできるコンテンツパッケージとして提供します.

******

### プラグイン契約

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
totalBytes=14035401
contentSha256=544137f7cd7f0b6725a88073132b30fd0bba2f683953c30cb76a167f5d2e7eeb
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=6d23c2584c72589d768dd40fe08fef689bb20a06
sourcePath=api
sourceGenerator=generator/auto-generate-for-autojs6.bat
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

OfflineDocsPluginInfoService は IPluginInfoProvider を通じて PluginInfo を公開します. ホストは固定パッケージが有効化, 互換性, 署名, メタデータ, インベントリ, ファイル内容の整合性検査に合格した場合だけ受け入れます.

******

### コンテンツ

******

`assets/docs/` の現在のドキュメント資産からコンテンツメタデータとインベントリを自動的に導出します. ホストはメタデータ, インベントリ, ファイル内容が互いに整合していることを検証します. オフラインドキュメントではタイトルと本文を対象に全文検索でき, 検索結果から一致するセクションへ直接移動できます.

******

### ビルドと検証

******

両方のバリアントをビルドし, JVM テストを実行し, APK 検査によって動的に生成されたコンテンツメタデータ, 契約メタデータ, リンク切れ, 単一 universal APK, `lib/*.so` ペイロード不在, ライセンスを検証します:

```powershell
.\gradlew.bat :app:testDebugUnitTest :app:verifyOfflineDocsApks
```

公開可能な Release APK の検証には Git 管理外の `sign.properties` ファイルも必要です:

```powershell
.\gradlew.bat :app:verifyOfflineDocsPublishableApks
```

******

### 実行時動作

******

プラグインに単独のインターフェースはありません. AutoJs6 は必要時に検出して検証し, プラグインの AssetManager から専用の WebView アセットローダーを介してドキュメントを直接提供します. プラグインの交換や無効化はホストが検出します.

******

### リリース履歴

******

# v6.8.16

###### 2026/10/18

* `機能` WebView の getUserMedia/MediaRecorder による音声と動画のストリーミング, ページの Promise 待機, Android メディア権限の明示的な要求と Worker のライフサイクル管理

# v6.8.15

###### 2026/10/18

* `機能` Node.js/Bun: WebView の動画撮影と前面での AAC/M4A 録音, メディア設定, 選択待ち時間の指定と一時ファイルの削除

# v6.8.14

###### 2026/10/18

* `機能` Node.js/Bun: WebView のフルサイズ写真撮影, 保存先とディレクトリの選択, 文書バイトの読み取り, blob/data の分割ダウンロードと選択先への出力

##### その他のリリース履歴

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/assets/doc/CHANGELOG-ja.md)

******

### ライセンス

******

AutoJs6-Documentation 由来のドキュメントは Apache-2.0 です. Node.js ドキュメントのテンプレート, スタイル, 派生コンテンツは medium-zoom, docsify-copy-code, dnt-helper と同じく MIT です. SHJS は GPL-3.0 です. Lato は OFL-1.1 です.

各 APK の `assets/licenses/docs/` には帰属表示の概要と Apache-2.0, GPL-3.0, MIT, OFL-1.1 の全文が含まれます.

******

### リソース構成

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

`strings.xml` にはローカライズされたプラグイン説明が含まれます; `plugin_instruction.md` にはホスト側で表示される使用説明が含まれます. `.python/normalize_offline_docs.py` は生成されたオフラインドキュメントを変更せずに検証します. README と CHANGELOG は `.python/generate_markdown.py` により JSON ソースから生成され, 完全な CHANGELOG は `app/src/main/assets/doc/` に出力されます.

******

### リンク

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/docs/16kb.md)
