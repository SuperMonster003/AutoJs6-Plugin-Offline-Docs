<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>適用於 AutoJs6 的 6.6.4 離線文件內容插件</p>

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

### 語言 (Languages)

******

目前 README.md 支援以下語言:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hans.md)
- 繁體中文 (香港) [zh-Hant-HK] # 目前
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ar.md)

******

### 簡介

******

AutoJs6 Offline Documentation 插件將完整的 6.6.4 文件網站作為可獨立安裝的內容套件提供.

******

### 插件契約

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
totalBytes=10038249
contentSha256=a109d2f0746b118d772a44a5ebd0512e208f7955d83cff6563c0a0c21d3b77fc
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=e6bded6c8d0dbeb688c26eec2b5a241a4664ecc4
sourcePath=api
sourceGenerator=generator/auto-generate-for-autojs6.bat
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

OfflineDocsPluginInfoService 透過 IPluginInfoProvider 發佈 PluginInfo. 宿主只在固定套件名稱通過啟用狀態, 相容性, 簽署, 中繼資料, 清單和檔案內容一致性檢查後接受插件.

******

### 內容

******

內容中繼資料和清單會根據 `assets/docs/` 中的目前文件資產自動產生. 宿主會驗證中繼資料, 清單和檔案內容互相一致. 離線文件支援按標題和正文進行全文搜尋, 並可從搜尋結果直接跳轉至相符章節.

******

### 建置與驗證

******

建置兩種變體, 執行 JVM 測試, 並套用 APK 門禁, 驗證動態產生的內容中繼資料, 契約中繼資料, 失效連結, 單一 universal APK, 無 `lib/*.so` 載荷和授權:

```powershell
.\gradlew.bat :app:testDebugUnitTest :app:verifyOfflineDocsApks
```

可發佈 Release APK 的驗證還要求設定未納入版本控制的 `sign.properties`:

```powershell
.\gradlew.bat :app:verifyOfflineDocsPublishableApks
```

******

### 執行階段行為

******

插件不提供獨立介面. AutoJs6 按需探索並驗證插件, 然後透過專用 WebView 資源載入器直接從插件 AssetManager 提供文件. 插件被取代或停用時, 宿主會偵測到狀態變更.

******

### 發行歷史

******

# v6.8.0

###### 2026/08/21

* `優化` 使插件 versionName 與目標 AutoJs6 文件版本保持一致, 並在文件同步成功時將兩個項目各自的 build/versionCode 自動增加 1
* `優化` 更新內置 AutoJs6 6.8.0 文檔及離線搜尋索引, 補充 YOLO 物件偵測 Preview API 的精確提供方設定, 模型設定檔, 結果類型及穩定錯誤碼
* `優化` 完善內置 AI 參考文件, 涵蓋插件模型探索, 官方與精確元件選擇器, 多角色訊息歷史, 生成參數, 精確用量和串流負載, 以及完整路由範例
* `優化` 擴充內置 AI 參考文件及離線搜尋索引, 補充持久 `ai.session` Conversation API, 固定會話參數, 每輪只傳新提示詞的生命週期規則, 能力探索及明確資源釋放語義
* `優化` 擴充內置 AI 參考文件及離線搜尋索引, 補充 `structuredJson`/`responseSchema` 原生 JSON Schema 約束輸出, 持久會話固定 schema, JSON 文字回傳及失敗語義
* `優化` 擴充內置 AI 參考文件及離線搜尋索引, 補充明確 CPU/GPU/NPU backend profile, `ai.models` 裝置可用性及穩定不可用原因, 持久會話固定 backend, GPU 兼容性限制及禁止回退契約

# v1.0.1

###### 2026/07/25

* `優化` 將固定內容指紋基線改為根據目前文件資產自動產生內容中繼資料和清單, 使資產可直接更新
* `優化` 改為從 AutoJs6 官方 Markdown 來源產生並同步離線文件, 使線上和離線內容保持一致
* `優化` 將內置文件統一為 AutoJs6 API 參考風格, 規範目前產品名稱, JavaScript 變數宣告, 本地類型連結, 待完善章節提示和 ASCII 標點符號
* `優化` 完善離線文件瀏覽體驗, 支援按標題和全文內容搜尋並直接跳轉至相符章節

# v1.0.0

###### 2026/07/23

* `新增` 發佈獨立的 AutoJs6 6.6.4 離線文件內容插件, 支援契約版本 1 探索機制並提供單一 universal APK
* `新增` 封裝 161 個文件檔案, 本地化插件中繼資料及完整的 Apache-2.0, GPL-3.0, MIT 和 OFL-1.1 授權說明
* `優化` 加入 JVM 和 APK 門禁, 驗證規範內容指紋, 契約中繼資料, 已知失效連結基線, 單一 universal 成品, 無 `lib/*.so` 載荷和授權資產
* `優化` 記錄逐位元組文件載荷對應的 AutoJs6 來源提交和來源路徑

##### 更多發行歷史可參閱

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/assets/doc/CHANGELOG-zh-Hant-HK.md)

******

### 授權

******

源自 AutoJs6-Documentation 的文件依 Apache-2.0 授權. Node.js 文件範本, 樣式和衍生內容與 medium-zoom, docsify-copy-code 及 dnt-helper 依 MIT. SHJS 依 GPL-3.0. Lato 依 OFL-1.1.

每個 APK 均在 `assets/licenses/docs/` 中包含署名摘要及完整的 Apache-2.0, GPL-3.0, MIT 和 OFL-1.1 授權文字.

******

### 資源結構

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

`strings.xml` 提供插件描述本地化; `plugin_instruction.md` 提供宿主端展示的插件說明. `.python/normalize_offline_docs.py` 以唯讀方式驗證產生後的離線文件. README 與 CHANGELOG 由 `.python/generate_markdown.py` 根據 JSON 來源檔產生, 完整 CHANGELOG 輸出至 `app/src/main/assets/doc/`.

******

### 相關連結

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)
