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
fileCount=200
totalBytes=11721912
contentSha256=9a11dc5d1a8a6ef9c66d00b274a7bc803936859d01a4803c405097184b543c22
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=d5e012e6f0680ceaacc358ce9208aebab3e39c78
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

# v6.8.5

###### 2026/10/02

* `改善` AI Agent ドキュメント 1.2.0: 選択したローカルまたは外部 MCP サーバーのツールに対応し, サーバーごとにリスクを設定. mcp グループは初期状態で無効
* `改善` 3-Stove Agent の必要時接続の文書を同期: プラグインセンターでの一元的な有効化, 初回インストール時の自動有効化と無効設定の維持, 初回同期接続を待つ作業スレッド, 非同期クエリ, 読み取り専用 status とタスクを再実行しない動作
* `改善` installer / $installer スクリプト API, 同期および非同期インストール, セッションイベント, ソース検査, アンインストールと認可方式, デフォルトの操作とキャンセルの動作
* `改善` installer P8: Dhizuku 認可, notification インストール, preferred/persistent の既定モードとプラグイン機能の制限

# v6.8.4

###### 2026/09/26

* `改善` AI Agent 1.1.0 開発版の script_dynamic グループ, ソースごとの確認, 非公開のソース履歴とシステムファイル選択画面による登録スクリプト保存を文書化

# v6.8.3

###### 2026/09/25

* `改善` Agent 1.0.0 の Android とホストの要件, 3-Stone AI のモデル一覧, テキスト/OCR 観測を説明し, 文書の内容バージョン 6.8.0 とプラグインのリリース番号を分離
* `改善` Agent の全体ツール群, 慎重モード, 初期予算とプロトコル上限, プリセットとタスク単位の制限規則を同期
* `改善` Agent の設定記憶, 個別確認, スコープ内検索, JSON 入出力と自動注入と記憶ツールの違いを同期
* `改善` Agent の名前付きプリセット, 既定の選択, モデル選択, 固定コンテキストの結合とツール, 予算, 確認, スクリプトディレクトリ, 記憶の範囲の制限を同期
* `改善` ai.agent API, AgentRun のライフサイクル, 質問と確認, 予算, 登録スクリプト結果, 3 つの例, オフライン検索索引を同期
* `改善` 電子書籍 (EPUB) リファレンスとオフライン検索インデックスを同期し, Readium EPUB Reader プラグインの epub グローバル, EpubBook のメタデータ, 目次, 読み順, 本文抽出, 表紙とリソースの書き出しおよび全文検索, EpubReaderSession のイベント, 制御メソッドと閲覧設定, EpubLocator 位置オブジェクトおよび EpubError エラーコードを収録
* `改善` 電子書籍 (EPUB) リファレンスとオフライン検索インデックスを同期し, Readium EPUB Reader プラグイン 1.1.0 のハイライトとノート (EPUB コントラクトバージョン 2) を補完: EpubBook#annotations と簡易層の epub.annotations, EpubReaderSession の highlight イベントおよび EpubLocator の運搬箇所

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
