<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>適用於 AutoJs6 的 6.6.4 離線說明文件內容外掛</p>

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
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-HK.md)
- 繁體中文 (台灣) [zh-Hant-TW] # 目前
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

AutoJs6 Offline Documentation 外掛將完整的 6.6.4 說明文件網站作為可獨立安裝的內容套件提供.

******

### 外掛契約

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
totalBytes=10058908
contentSha256=f8ce88d1e03a3e8ef0aeac3b616d7ca09b03cc20e8a5b0036418620a9d11b5fa
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=e6bded6c8d0dbeb688c26eec2b5a241a4664ecc4
sourcePath=api
sourceGenerator=generator/auto-generate-for-autojs6.bat
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

OfflineDocsPluginInfoService 透過 IPluginInfoProvider 發布 PluginInfo. 主程式只在固定套件名稱通過啟用狀態, 相容性, 簽章, 中繼資料, 清單和檔案內容一致性檢查後接受外掛.

******

### 內容

******

內容中繼資料和清單會根據 `assets/docs/` 中的目前說明文件資產自動產生. 主程式會驗證中繼資料, 清單和檔案內容彼此一致. 離線說明文件支援依標題和內文進行全文搜尋, 並可從搜尋結果直接跳轉至相符章節.

******

### 建置與驗證

******

建置兩種變體, 執行 JVM 測試, 並套用 APK 門檻, 驗證動態產生的內容中繼資料, 契約中繼資料, 失效連結, 單一 universal APK, 無 `lib/*.so` 內容和授權:

```powershell
.\gradlew.bat :app:testDebugUnitTest :app:verifyOfflineDocsApks
```

可發布 Release APK 的驗證還要求設定未納入版本控制的 `sign.properties`:

```powershell
.\gradlew.bat :app:verifyOfflineDocsPublishableApks
```

******

### 執行階段行為

******

外掛不提供獨立介面. AutoJs6 依需求探索並驗證外掛, 然後透過專用 WebView 資源載入器直接從外掛 AssetManager 提供說明文件. 外掛被取代或停用時, 主程式會偵測到狀態變更.

******

### 發行歷史

******

# v6.8.0

###### 2026/08/21

* `優化` 同步 Image Quantization v4 參考文件與離線搜尋索引, 新增可設定的像素及工作記憶體預算, 型別化資源上限診斷, 已計入預算的尖峰記憶體指標, 以及明確要求或指令碼結束時的取消機制
* `優化` 使外掛 versionName 與目標 AutoJs6 說明文件版本保持一致, 並在說明文件同步成功時將兩個專案各自的 build/versionCode 自動增加 1
* `優化` 更新內建 AutoJs6 6.8.0 文件及離線搜尋索引, 補充 YOLO 物件偵測 Preview API 的精確提供端設定, 模型設定檔, 結果型別及穩定錯誤碼
* `優化` 完善內建 AI 參考說明文件, 涵蓋外掛模型探索, 官方與精確元件選擇器, 多角色訊息歷程, 生成參數, 精確用量和串流負載, 以及完整路由範例
* `優化` 擴充內建 AI 參考說明文件及離線搜尋索引, 補充持久 `ai.session` Conversation API, 固定會話參數, 每輪僅傳新提示詞的生命週期規則, 能力探索及明確資源釋放語意
* `優化` 擴充內建 AI 參考說明文件及離線搜尋索引, 補充 `structuredJson`/`responseSchema` 原生 JSON Schema 約束輸出, 持久工作階段固定 schema, JSON 文字回傳及失敗語意
* `優化` 擴充內建 AI 參考說明文件及離線搜尋索引, 補充明確 CPU/GPU/NPU backend profile, `ai.catalog` 裝置可用性及穩定不可用原因, 持久工作階段固定 backend, GPU 相容性限制與禁止回退契約
* `優化` 以統一 `ai.catalog` 目標目錄直接取代全部未發布的 AI 清單與設定探測 API, 補齊精確 `target` 路由, 完整回應與工作階段中繼資料, 穩定禁止回退錯誤, 並同步線上/離線資產
* `優化` 擴充內建 runtime 參考文件與離線搜尋索引, 加入用於驗證 mapping/seeds/usage/retrace metadata 匯出的 6 個 `loadJarWithR8` 多載及通訊協定 1.1 `retraceR8Stack` API, 並說明溯源綁定與失敗即終止的禁止回退語義

# v1.0.1

###### 2026/07/25

* `優化` 將固定內容指紋基準改為根據目前說明文件資產自動產生內容中繼資料和清單, 使資產可直接更新
* `優化` 改為從 AutoJs6 官方 Markdown 來源產生並同步離線說明文件, 使線上和離線內容保持一致
* `優化` 將內建說明文件統一為 AutoJs6 API 參考風格, 規範目前產品名稱, JavaScript 變數宣告, 內部型別連結, 待完善章節提示和 ASCII 標點符號
* `優化` 改善離線說明文件瀏覽體驗, 支援依標題和全文內容搜尋並直接跳轉至相符章節

# v1.0.0

###### 2026/07/23

* `新增` 發布獨立的 AutoJs6 6.6.4 離線說明文件內容外掛, 支援契約版本 1 探索機制並提供單一 universal APK
* `新增` 封裝 161 個說明文件檔案, 本地化外掛中繼資料及完整的 Apache-2.0, GPL-3.0, MIT 和 OFL-1.1 授權說明
* `優化` 加入 JVM 和 APK 門檻, 驗證規範內容指紋, 契約中繼資料, 已知失效連結基準, 單一 universal 成品, 無 `lib/*.so` 內容和授權資產
* `優化` 記錄逐位元組說明文件內容對應的 AutoJs6 來源提交和來源路徑

##### 更多發行歷史可參閱

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/assets/doc/CHANGELOG-zh-Hant-TW.md)

******

### 授權

******

源自 AutoJs6-Documentation 的說明文件依 Apache-2.0 授權. Node.js 說明文件範本, 樣式和衍生內容與 medium-zoom, docsify-copy-code 及 dnt-helper 依 MIT. SHJS 依 GPL-3.0. Lato 依 OFL-1.1.

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

`strings.xml` 提供外掛描述本地化; `plugin_instruction.md` 提供主程式端展示的外掛說明. `.python/normalize_offline_docs.py` 以唯讀方式驗證產生後的離線說明文件. README 與 CHANGELOG 由 `.python/generate_markdown.py` 根據 JSON 來源檔產生, 完整 CHANGELOG 輸出至 `app/src/main/assets/doc/`.

******

### 相關連結

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)
