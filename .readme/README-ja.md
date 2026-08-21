<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>AutoJs6 用オフラインドキュメント 6.6.4 コンテンツプラグイン</p>

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

AutoJs6 Offline Documentation プラグインは完全な 6.6.4 ドキュメントサイトを個別にインストールできるコンテンツパッケージとして提供します.

******

### プラグイン契約

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
totalBytes=10025521
contentSha256=2fe7755ab4409120f183cbbb4af691cb9fd9ecfc0d44c0e19b7af847340f01c3
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=845d4a94b1ada26ccc9b9a697f45d25c03e0195a
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

# v6.8.0

###### 2026/08/21

* `改善` プラグインの versionName を対象の AutoJs6 ドキュメントバージョンに合わせ, ドキュメント同期成功時に両プロジェクトの build/versionCode をそれぞれ自動で 1 増加
* `改善` 内蔵 AutoJs6 6.8.0 ドキュメントとオフライン検索インデックスを更新し, YOLO 物体検出 Preview API, 厳密なプロバイダー設定, モデルプロファイル, 結果型, 安定したエラーコードを追加
* `改善` 内蔵 AI リファレンスを拡充し, プラグインモデル探索, 公式/厳密コンポーネント選択, 複数ロールのメッセージ履歴, 生成パラメータ, 正確な使用量とストリーミングペイロード, 完全なルーティング例に対応
* `改善` 内蔵 AI リファレンスとオフライン検索索引を拡充し, 永続 `ai.session` Conversation API, 固定セッション設定, 各ターンで新しいプロンプトだけを渡すライフサイクル規則, 能力探索, 明示的なリソース解放に対応

# v1.0.1

###### 2026/07/25

* `改善` 固定コンテンツ指紋基準を現在のドキュメント資産から自動生成するコンテンツメタデータとインベントリに置き換え, 資産を直接更新可能に変更
* `改善` AutoJs6 公式 Markdown ソースからオフラインドキュメントを生成して同期し, オンライン版とオフライン版の内容を統一
* `改善` 内蔵ドキュメントを AutoJs6 API リファレンス形式に統一し, 現行の製品名, JavaScript 変数宣言, ローカル型リンク, 未完成セクションの案内, ASCII 句読点を標準化
* `改善` タイトルと本文を対象とする全文検索と一致するセクションへの直接移動により, オフラインドキュメントの閲覧性を改善

# v1.0.0

###### 2026/07/23

* `機能` 契約バージョン 1 の検出と単一 universal APK を備えた独立 AutoJs6 6.6.4 オフラインドキュメントコンテンツプラグインを公開
* `機能` 161 個のドキュメントファイル, ローカライズしたメタデータ, 完全な Apache-2.0, GPL-3.0, MIT, OFL-1.1 通知を同梱
* `改善` 正規コンテンツ指紋, 契約メタデータ, 既知のリンク切れ基準, 単一 universal APK, `lib/*.so` ペイロード不在, ライセンス資産の JVM と APK 検査を追加
* `改善` バイト単位でコピーしたドキュメント内容の正確な AutoJs6 ソースコミットとソースパスを記録

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
