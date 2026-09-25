<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>適用於 AutoJs6 的 6.8.0 離線說明文件內容外掛</p>

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

AutoJs6 Offline Documentation 外掛將完整的 6.8.0 說明文件網站作為可獨立安裝的內容套件提供.

******

### 外掛契約

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
fileCount=199
totalBytes=11597017
contentSha256=7c62f38181d82f994c2dac4bde871d9f687cd4e9c40f3330593aa848927fe9d4
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=e9ce36a0dbd175703a04bb554db27eccf97ca652
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

# v6.8.3

###### 2026/09/25

* `優化` 說明 Agent 1.0.0 的 Android 與宿主要求, 3-Stone AI 模型目錄及文字/OCR 觀察範圍, 文件內容維持 6.8.0 並使用獨立外掛發行版本
* `優化` 同步 Agent 全域工具組, 審慎模式, 預設預算與協定上限, 以及預設和單次任務的收緊規則
* `優化` 同步 Agent 偏好記憶, 逐項確認, 作用域查詢, JSON 匯入/匯出及自動注入與記憶工具的區別
* `優化` 同步 Agent 命名預設, 預設值選擇, 模型選擇, 固定上下文合併及工具, 預算, 確認, 腳本目錄和記憶作用域的收緊規則
* `優化` 同步 ai.agent 任務 API, AgentRun 生命週期, 詢問與確認, 預算, 登記腳本結果, 三個範例及離線搜尋索引
* `優化` 同步電子書 (EPUB) 參考文件與離線搜尋索引, 涵蓋 Readium EPUB Reader 外掛的 epub 全域物件, EpubBook 的中繼資料, 目錄, 閱讀順序, 正文擷取, 封面與資源匯出及全文搜尋, EpubReaderSession 的事件, 控制方法與閱讀偏好, EpubLocator 位置物件及 EpubError 錯誤代碼
* `優化` 同步電子書 (EPUB) 參考文件與離線搜尋索引, 補充 Readium EPUB Reader 外掛 1.1.0 的螢光標示與筆記 (EPUB 契約版本 2): EpubBook#annotations 與便捷層 epub.annotations, EpubReaderSession 的 highlight 事件及 EpubLocator 的攜帶位置

# v6.8.0

###### 2026/09/19

* `修復` 離線文件驗證器不再將公開 Node 橋接方法名稱 `callAutoJs` 誤判為舊版裸產品名稱
* `修復` AGP 9.1 建置時的 SDK XML v4 解析警告及 JVM 單元測試組裝工作誤觸發 APK 原生程式庫對齊檢查的問題 (共用建置外掛 1.8.3)
* `優化` 同步座標點擊 API, maxAttempts 預設 0 的無限嘗試語意, Flow 例外工作堆疊與主控台輸出及離線搜尋索引
* `優化` 同步 Flow 可選步驟, 有界迴圈, 鏈式候選查找與點擊, 集合穩定快照及預設值說明, 並更新離線搜尋索引
* `優化` 同步執行時本機網路權限文件及離線搜尋索引, 說明 Android 17 / targetSdk 37 條件, 非同步授權, 重試及原生 Socket / MQTT 和外掛權限邊界
* `優化` 同步 `device.pageSize` 參考文件與離線搜尋索引, 說明頁大小的位元組單位, 唯讀屬性及執行環境與原生程式庫相容性的區別
* `優化` 同步 OCR 參考文件與離線搜尋索引, 補充引擎自動選擇, 即時模式讀取, tap 重設, 單次呼叫選項及無可用外掛時的行為
* `優化` 同步 MediaInfo 參考文件與離線搜尋索引, 補充相容 `read` 與版本化 `snapshot` 的邊界, 外掛快照 v1/v2 schema 協商, 輕量 `capabilities` 以及動態 v2 track 和引擎資訊
* `優化` 同步 Pinyin 參考文件與離線搜尋索引, 補充僅目前呼叫生效的 `customDictionary` 自訂讀音覆寫, 已完成的 `compare`/`compact`, 以及透過具備明確 `pinyin` capability 的 `autojs6:bridge.callAutoJs` 進行 Node.js 存取
* `優化` 同步 Image Quantization v4 參考文件與離線搜尋索引, 新增可設定的像素及工作記憶體預算, 型別化資源上限診斷, 已計入預算的尖峰記憶體指標, 以及明確要求或指令碼結束時的取消機制
* `優化` 使外掛 versionName 與目標 AutoJs6 說明文件版本保持一致, 並在說明文件同步成功時將兩個專案各自的 build/versionCode 自動增加 1
* `優化` 更新內建 AutoJs6 6.8.0 文件及離線搜尋索引, 補充 YOLO 物件偵測 Preview API 的精確提供端設定, 模型設定檔, 結果型別及穩定錯誤碼
* `優化` 完善內建 AI 參考說明文件, 涵蓋外掛模型探索, 官方與精確元件選擇器, 多角色訊息歷程, 生成參數, 精確用量和串流負載, 以及完整路由範例
* `優化` 擴充內建 AI 參考說明文件及離線搜尋索引, 補充持久 `ai.session` Conversation API, 固定會話參數, 每輪僅傳新提示詞的生命週期規則, 能力探索及明確資源釋放語意
* `優化` 擴充內建 AI 參考說明文件及離線搜尋索引, 補充 `structuredJson`/`responseSchema` 原生 JSON Schema 約束輸出, 持久工作階段固定 schema, JSON 文字回傳及失敗語意
* `優化` 擴充內建 AI 參考說明文件及離線搜尋索引, 補充明確 CPU/GPU/NPU backend profile, `ai.catalog` 裝置可用性及穩定不可用原因, 持久工作階段固定 backend, GPU 相容性限制與禁止回退契約
* `優化` 以統一 `ai.catalog` 目標目錄直接取代全部未發布的 AI 清單與設定探測 API, 補齊精確 `target` 路由, 完整回應與工作階段中繼資料, 穩定禁止回退錯誤, 並同步線上/離線資產
* `優化` 擴充內建 runtime 參考文件與離線搜尋索引, 加入用於驗證 mapping/seeds/usage/retrace metadata 匯出的 6 個 `loadJarWithR8` 多載及通訊協定 1.1 `retraceR8Stack` API, 並說明溯源綁定與失敗即終止的禁止回退語義
* `優化` 統一 README 版式與 Gradle 平台版本管理方式
* `優化` MediaInfo 參考文件與離線搜尋同步 streamNumber, countGet, infoKind 和原始檔案路徑語義
* `優化` 建置階段阻止意外引入原生相依套件, 並輸出 JSON 校驗報告
* `優化` 同步郵件 (Mail) 參考文件與離線搜尋索引, 涵蓋 Angus Mail 外掛的 mail 全域物件, MailClient 的收發, 搜尋, 附件, 標記, 資料夾與監聽方法, MailMessage, MailAccountOptions 與服務商預設, MailSearchQuery 及 MailError 錯誤代碼

# v6.8.2

###### 2026/09/15

* `優化` 將 compileSdk 與 targetSdk 提升到 37 (Android 17), 外掛程式行為不受新目標版本影響

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


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/docs/16kb.md)
