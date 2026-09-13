<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>適用於 AutoJs6 的 6.8.0 離線文件內容插件</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Offline-Docs?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=A24232&label=Issues"/></a>
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

AutoJs6 Offline Documentation 插件將完整的 6.8.0 文件網站作為可獨立安裝的內容套件提供.

******

### 插件契約

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
fileCount=184
totalBytes=10570151
contentSha256=2331d9f04557e9cde2eadc79c8daec32bc732c8ac6316aa82ff6e10f522fd5b4
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=6d24cee179b65cf7f10f7ae16eed6880bab5f853
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

# v6.8.1

###### 2026/09/13

* `優化` 同步 HTTP 的 isInsecure / insecure 請求範圍, 共用用戶端設定及憑證信任, CT, ECH 和本地網絡權限說明
* `優化` 同步 Media, Device, TTS 和 Settings 的 Android 17 後台音頻運行條件, 靜默抑制, 可見介面恢復操作與 TTS 引擎進程邊界
* `優化` 校驗發行簽署設定, 預期 APK 集合與可重現文件

# v6.8.0

###### 2026/09/13

* `修復` 離線文件校驗器不再將公開 Node 橋接方法名稱 `callAutoJs` 誤判為舊版裸產品名稱
* `優化` 同步執行時本地網絡權限文件及離線搜尋索引, 說明 Android 17 / targetSdk 37 條件, 非同步授權, 重試及原生 Socket / MQTT 和插件權限邊界
* `優化` 同步 `device.pageSize` 參考文件與離線搜尋索引, 說明頁大小的位元組單位, 唯讀屬性及執行環境與原生程式庫相容性的區別
* `優化` 同步 OCR 參考文件與離線搜尋索引, 補充引擎自動選擇, 即時模式讀取, tap 重設, 單次呼叫選項及無可用插件時的行為
* `優化` 同步 MediaInfo 參考文檔與離線搜尋索引, 補充兼容 `read` 與版本化 `snapshot` 的邊界, 插件快照 v1/v2 schema 協商, 輕量 `capabilities` 以及動態 v2 track 和引擎資訊
* `優化` 同步 Pinyin 參考文件與離線搜尋索引, 補充僅當前調用生效的 `customDictionary` 自訂讀音覆蓋, 已完成的 `compare`/`compact`, 以及透過帶明確 `pinyin` capability 的 `autojs6:bridge.callAutoJs` 進行 Node.js 存取
* `優化` 同步 Image Quantization v4 參考文件與離線搜尋索引, 新增可配置的像素及工作記憶體預算, 類型化資源上限診斷, 已計入預算的峰值記憶體指標, 以及明確請求或腳本結束時的取消機制
* `優化` 使插件 versionName 與目標 AutoJs6 文件版本保持一致, 並在文件同步成功時將兩個項目各自的 build/versionCode 自動增加 1
* `優化` 更新內置 AutoJs6 6.8.0 文檔及離線搜尋索引, 補充 YOLO 物件偵測 Preview API 的精確提供方設定, 模型設定檔, 結果類型及穩定錯誤碼
* `優化` 完善內置 AI 參考文件, 涵蓋插件模型探索, 官方與精確元件選擇器, 多角色訊息歷史, 生成參數, 精確用量和串流負載, 以及完整路由範例
* `優化` 擴充內置 AI 參考文件及離線搜尋索引, 補充持久 `ai.session` Conversation API, 固定會話參數, 每輪只傳新提示詞的生命週期規則, 能力探索及明確資源釋放語義
* `優化` 擴充內置 AI 參考文件及離線搜尋索引, 補充 `structuredJson`/`responseSchema` 原生 JSON Schema 約束輸出, 持久會話固定 schema, JSON 文字回傳及失敗語義
* `優化` 擴充內置 AI 參考文件及離線搜尋索引, 補充明確 CPU/GPU/NPU backend profile, `ai.catalog` 裝置可用性及穩定不可用原因, 持久會話固定 backend, GPU 兼容性限制及禁止回退契約
* `優化` 以統一 `ai.catalog` 目標目錄直接取代全部未發佈嘅 AI 列表同設定探測 API, 補齊精確 `target` 路由, 完整回應同會話元數據, 穩定禁止回退錯誤, 並同步在線/離線資產
* `優化` 擴充內置 runtime 參考文件同離線搜尋索引, 加入用於驗證 mapping/seeds/usage/retrace metadata 匯出嘅 6 個 `loadJarWithR8` 多載及協議 1.1 `retraceR8Stack` API, 並說明來源綁定同失敗即終止嘅禁止回退語義
* `優化` 統一 README 版式與 Gradle 平台版本管理方式
* `優化` MediaInfo 參考文件與離線搜尋同步 streamNumber, countGet, infoKind 和原始檔案路徑語義
* `優化` 建置階段阻止意外引入原生相依套件, 並輸出 JSON 校驗報告

# v1.0.1

###### 2026/07/25

* `優化` 將固定內容指紋基線改為根據目前文件資產自動產生內容中繼資料和清單, 使資產可直接更新
* `優化` 改為從 AutoJs6 官方 Markdown 來源產生並同步離線文件, 使線上和離線內容保持一致
* `優化` 將內置文件統一為 AutoJs6 API 參考風格, 規範目前產品名稱, JavaScript 變數宣告, 本地類型連結, 待完善章節提示和 ASCII 標點符號
* `優化` 完善離線文件瀏覽體驗, 支援按標題和全文內容搜尋並直接跳轉至相符章節

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


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/docs/16kb.md)
