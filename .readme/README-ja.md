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
fileCount=185
totalBytes=10634684
contentSha256=1acb438488934ed154351c7ada39e8218fba21bf43075f9fae184c0e471c0a72
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=b20d9601fba77b1f67cb1931f42ca83f0273df6f
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

###### 2026/09/16

* `修正` オフライン文書 validator は公開 Node bridge method 名 `callAutoJs` を旧製品の裸名称として誤判定しなくなりました
* `改善` Flow の任意ステップ, 回数と時間を制限したループ, チェーン内の候補検索とクリック, コレクションの安定スナップショットと既定値の説明を同期し, オフライン検索インデックスを更新
* `改善` ローカルネットワーク権限のリファレンスとオフライン検索索引を同期し, Android 17 / targetSdk 37 の条件, 非同期の許可, 再試行, ネイティブ Socket / MQTT とプラグイン権限の境界を説明
* `改善` `device.pageSize` のリファレンスとオフライン検索インデックスを同期し, バイト単位, 読み取り専用属性, 実行環境とネイティブライブラリの互換性の違いを説明
* `改善` OCR リファレンスとオフライン検索インデックスを同期し, エンジンの自動選択, リアルタイムのモード取得, tap によるリセット, 呼び出しごとのオプション, 利用可能なプラグインがない場合の動作を補足
* `改善` MediaInfo リファレンスとオフライン検索インデックスを同期し, 従来の `read` とバージョン付き `snapshot` の境界, プラグイン snapshot v1/v2 schema ネゴシエーション, 軽量 `capabilities`, 動的な v2 track とエンジン情報を追加
* `改善` Pinyin リファレンスとオフライン検索インデックスを同期し, 呼び出し単位の `customDictionary` 読み上書き, 完成した `compare`/`compact`, および明示的な `pinyin` capability を伴う `autojs6:bridge.callAutoJs` 経由の Node.js アクセスを追加
* `改善` Image Quantization v4 リファレンスとオフライン検索索引を同期し, 設定可能なピクセル数と作業メモリの予算, 型付きリソース上限診断, 計上済みピークメモリ指標, 明示要求またはスクリプト終了時のキャンセルを追加
* `改善` プラグインの versionName を対象の AutoJs6 ドキュメントバージョンに合わせ, ドキュメント同期成功時に両プロジェクトの build/versionCode をそれぞれ自動で 1 増加
* `改善` 内蔵 AutoJs6 6.8.0 ドキュメントとオフライン検索インデックスを更新し, YOLO 物体検出 Preview API, 厳密なプロバイダー設定, モデルプロファイル, 結果型, 安定したエラーコードを追加
* `改善` 内蔵 AI リファレンスを拡充し, プラグインモデル探索, 公式/厳密コンポーネント選択, 複数ロールのメッセージ履歴, 生成パラメータ, 正確な使用量とストリーミングペイロード, 完全なルーティング例に対応
* `改善` 内蔵 AI リファレンスとオフライン検索索引を拡充し, 永続 `ai.session` Conversation API, 固定セッション設定, 各ターンで新しいプロンプトだけを渡すライフサイクル規則, 能力探索, 明示的なリソース解放に対応
* `改善` 内蔵 AI リファレンスとオフライン検索索引を拡充し, `structuredJson`/`responseSchema` によるネイティブ JSON Schema 制約出力, 永続セッション固定 schema, JSON テキストの戻り値と失敗規則に対応
* `改善` 内蔵 AI リファレンスとオフライン検索索引を拡充し, 明示的 CPU/GPU/NPU backend profile, `ai.catalog` のデバイス可用性と安定した使用不可理由, 永続セッション固定 backend, GPU 互換性制限, フォールバック禁止契約に対応
* `改善` 未公開の AI 一覧/設定確認 API を統一 `ai.catalog` ターゲットディレクトリ, `target` による厳密なルーティング, 完全なレスポンス/セッションメタデータ, フォールバックしない安定エラーへ直接置換し, オンライン/オフライン資産を同期
* `改善` 内蔵 runtime リファレンスとオフライン検索インデックスを拡張し, 検証済み mapping/seeds/usage/retrace metadata を出力する 6 つの `loadJarWithR8` オーバーロードとプロトコル 1.1 `retraceR8Stack` API, 来歴の結合, フォールバックしない fail-closed 動作を追加
* `改善` README のレイアウトと Gradle プラットフォームのバージョン管理方式を統一
* `改善` MediaInfo リファレンスとオフライン検索に streamNumber, countGet, infoKind と元のファイルパスの仕様を反映
* `改善` 意図しないネイティブ依存関係をビルド時に拒否し, JSON レポートを生成

# v6.8.2

###### 2026/09/15

* `改善` compileSdk と targetSdk を 37 (Android 17) に引き上げ, プラグインの動作は新しいターゲットの影響を受けない

# v6.8.1

###### 2026/09/14

* `改善` requiresSharedStorage, 権限拒否, 設定からの復帰, 起動アイコンの復元を含むパッケージアプリのストレージ案内を同期
* `改善` Media3 音楽サービス, スクリプトの再生所有権, ワーカースレッドでの準備, 通知操作とパッケージアプリの権限について Media リファレンスと検索索引を同期
* `改善` Pangu リファレンスと検索インデックスを同期し, 組み込み pangu.js 10.1.0, グローバルアクセス, 文字間隔の調整と確認を説明
* `改善` HTTP の isInsecure / insecure のリクエスト単位の適用範囲, 共有クライアント設定, 証明書の信頼, CT, ECH とローカルネットワーク権限の説明を同期
* `改善` Media, Device, TTS, Settings のリファレンスに Android 17 のバックグラウンド音声条件, 通知のない抑制, アプリ表示中の復旧操作, TTS エンジンプロセスの範囲を反映
* `改善` リリース署名の設定, APK の構成, ドキュメントの再生成結果を検証

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
