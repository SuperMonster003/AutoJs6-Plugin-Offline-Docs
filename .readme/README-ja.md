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
totalBytes=13916002
contentSha256=359a9fd29824cc4af0cedd2facaa87ca059d8da879907d504522d9ef4717d638
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=bd95e545c7fa02dfabbc2ba8d13a3917d2d32a85
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

# v6.8.8

###### 2026/10/17

* `機能` Node.js/Bun images が高度なフィルター, 色空間変換, 複数色検索, 円検出, 類似度指標と URL 読み込みに対応
* `機能` Node.js/Bun images が SIFT/ORB 特徴抽出と照合, シーン座標と ObjectFrame の幾何情報, 実行単位の Mat/特徴ハンドル管理に対応
* `機能` Node.js/Bun images が PNG 量子化と圧縮, 品質/メモリ指標, バイナリ結果とファイル記述子への出力に対応

# v6.8.7

###### 2026/10/17

* `機能` Node.js のメインスレッドと Worker が H.264 MP4 画面録画, マイク/再生/ミックス AAC 音声, 録画中のスクリーンショット, Worker の未保存録画の破棄に対応 (API / TypeScript / Ace)

# v6.8.6

###### 2026/10/17

* `修正` README の文書ソースコミットがパッケージ内の出典記録と一致しない問題
* `改善` Bun screenRecorder が H.264 MP4 録画, マイク/アプリ再生/ミックスの AAC 音声と録画中の画面取得に対応し, 個別の音声許可とキャンセル時の削除を提供 (API documentation)
* `改善` Bun screenRecorder が個別許可, 固定寸法, 明示的な終了処理とキャンセル時の削除を備えた音声なし H.264 MP4 画面録画に対応 (API documentation)
* `改善` Node.js Worker が pinyin, pinyin4j, コンソール操作と座標変換に対応し, 親の実行状態を共有しながらネイティブ出力を維持 (API documentation)
* `改善` Bun の画面キャプチャ許可と Node.js Worker の OpenCC/画像モジュールに関するランタイム API 文書
* `改善` Node.js と Bun の OpenCC と画像 API の説明に非同期ハンドル, ピクセル形式, 権限と転送上限を追加
* `改善` Rhino speech API リファレンス: 認識, ウェイクワードと音声入力セッション, 音声区間検出, 合成と speech.models の管理
* `改善` Node.js と Bun の実行環境 API ガイド. 非同期ピンイン, コンソール, 座標変換とエディター型宣言の範囲を説明
* `改善` Installer の起点/パッケージ名プレフィックス別プロファイル, 明示オプションの優先と 3 項目の null リセット, sourceDeleteRequested とバッチ共有ソースの保持. ホスト 5312+ と対応プラグインが必要
* `改善` セレクター minDepth/maxDepth/minIndexInParent/maxIndexInParent のメソッド説明とオフライン検索インデックス
* `改善` 3-Block Compose の完全な API リファレンス: ノードと状態, Modifier, テーマ, セッションとフローティングウィンドウ, コンポーネントのプロパティとイベント, スレッド, アクセシビリティ, パッケージ化アプリ
* `改善` 3-Block Compose TSX: TSX は `<compose.Column>`, `<compose:Text>`, ノードファクトリへの参照, Fragment, スロットとリアクティブなコールバックに対応. 同じツリーで Compose と従来の XML ノードを混在させることはできません
* `改善` Terminal モジュールのリファレンス: 3-Shell Terminal プラグインの同期/非同期セッション, 出力イベント, npm スクリプト, 権限とライフサイクル, および TerminalSession, TerminalOpenOptions, TerminalError 型
* `改善` colors モジュールのリファレンス: OKLab/OKLCH 変換, コントラスト調整, 調和色, 色階, 派生配色, 夜間の対応色, 色覚特性のシミュレーション, 画像の主要色の抽出, oklab 色検出アルゴリズム, colors.theme によるテーマカラー制御
* `改善` プラグインセンターのアイコンに Icon Studio で調整したサイズ, 位置, 明暗の図稿と円形背景を適用し, 再生成可能な原稿とパラメーターを保持
* `改善` Android のアプリ情報アイコンに Icon Studio と共通の図案と明暗の背景色を使用し, プラグインセンターの透明な図案と既存のランチャー設定を維持
* `改善` 3-Block Compose: XML `<compose>` コンテナと compose.attach は UI ページや既存のフローティングウィンドウに独立した Compose セッションを埋め込みます. compose.AndroidView は既存の Android View または同期ファクトリが返す View を表示します
* `改善` 3-Block Compose リファレンスに独立ダイアログとボトムシート, 終了の規則, オーバーレイ権限, セッションのライフサイクルを追加
* `改善` 3-Block Compose V2 コンポーネントリファレンスで制御状態, イベント, フォーカスとスクロールのコマンド, 利用条件と互換性を説明
* `改善` device API リファレンス: device.getAndroidId が useSystemId 真偽値引数に対応し, Android 8.0+ では Shizuku/Root を通じてアプリの Android ユーザーのシステム値を取得. 権限または読み取りの失敗時は例外を送出し, 旧システムでは引数を無視
* `改善` AutoJs4 ランタイムリファレンス: AutoJs4 Runtime プラグインの用途, インストールと独立した権限, ファイルマネージャーの "AutoJs4 で実行" による .js / .auto ファイルとプロジェクトフォルダーの実行入口, ログ転送とタスク停止, 実行制限, 差異の報告方法
* `改善` AutoJs4 ランタイムリファレンス: "AutoJs4 で実行して比較" の比較モードを追加し, 2 回の実行の流れ, 開始と終了の行および接頭辞の除去規則, 結果ページの概要と差分マーカー, issue テンプレートのコピー, 120 秒のタイムアウトを説明
* `改善` AutoJs4 ランタイムリファレンス: "com.stardust 互換クラス" 節を追加し, com.stardust 接頭辞のクラス名が AutoJs6 の実装にどう対応付けられるか (完全対応, 部分対応, 提供終了の 3 種), 改名対応が importClass のグローバル名に与える影響, Class.forName が対応付けの対象外であることを説明
* `改善` 3-Block Compose デザイナーのリファレンス: プラグイン内蔵のビジュアルデザイナーの入口とプロジェクトファイル, 編集画面のキャンバス / アウトライン / プロパティ / 状態 / コンポーネントパレット, 縦向きと横向きのレイアウト, 下書き, 認識されるスクリプトのサブセットと往復のルール, AutoJs6 エディターとの双方向の受け渡し, インポート元への書き戻しと再インポート, プレビュー状態と操作プレビューおよび実際の実行との違い, TSX プロジェクト (TypeScript Engine で解析, ない場合は読み取り専用), 操作プレビューのサンドボックスでの JavaScript プロジェクトのスクリプト実行とコンソール (Android 8.0 以降), UI (XML) プロジェクト (1.6.0 以降: ui モードスクリプトの XML レイアウトのその場編集, AutoJs6 のプレビューサービスが描画するキャンバス, ハンドラーのスタブとバインディングパネル), 現在の制限; 1.7.0 以降は UI (XML) プロジェクトのインタラクティブプレビューで AutoJs6 がスクリプト全体を実際に実行し (Android 13 以降), プレビューでの UI スクリプト実行に関する節 (条件, 停止規則, コンソール, 実際の実行との差異) を追加; 1.8.0 から "プレビューの差異" (プレビューと AutoJs6 での実行で動作が異なる書き方) と "XML ファイルとフォルダープロジェクト" (リテラルのパスで参照する XML レイアウトファイル, XML ファイルとして保存 / 新規 XML ファイル, project.json を含むフォルダープロジェクト, zip のインポート / エクスポート, AutoJs6 での実行とインポート, 外部ドキュメントのフォルダーへのアクセス, プレビューでのプロジェクトファイル, Android XML の編集と検査) の 2 節を追加
* `改善` Android XML 属性リファレンス: ネイティブ Android XML の UI レイアウトで各 View クラスが設定できる / できない android: / app: 属性, 値の形式, 列挙とフラグの名前, 初出の API レベルと設定方法, 各親レイアウトが受け付けるレイアウトパラメーター. ユーザーインターフェースのリファレンスにプロジェクトのリソース (res/ フォルダー, 修飾子フォルダー, vector ドローアブル) を追加
* `改善` [API リファレンス](https://docs.autojs6.com/#/documentation): Files と RootAutomator の不足メンバー, 色の結果配列, WebView コンテキストと省略可能な引数のオーバーロードを補完し, バイト追記とスワイプの引数, 座標スケーリングの説明を修正, setScaleBases の失敗時に基準値を変更せず設定機会も消費しないことと, 基準値 setter の整数変換規則を説明
* `改善` ギャラリー (Gallery) モジュールのリファレンス: 3-Maple Image プラグインが提供する gallery オブジェクト (画像選択, ビューアセッション, 編集, UI なしの変換), AutoJs6 がファイルを読み書きする境界, 写真へのアクセス権限, エラーコード, GalleryViewSession 型
* `改善` files.batchRename リファレンス: Batch Rename プラグインが提供する一括リネーム. プランのプレビューと項目ごとの除外, 実行, 元に戻す操作とバッチ履歴, オプションと置換変数, 競合ポリシー, 結果オブジェクトとエラーコード
* `改善` plugins.tools リファレンス: AutoJs6 プラグインが自ら記述するツール. ツールとプロバイダーの一覧, 同期と非同期の呼び出し, 画像 / ファイル引数と出力ファイル, 結果オブジェクトとエラーを含む

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
