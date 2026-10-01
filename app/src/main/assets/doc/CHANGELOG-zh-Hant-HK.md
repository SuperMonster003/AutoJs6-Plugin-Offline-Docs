******

### 發行歷史

******

# v6.8.5

###### 2026/10/02

* `優化` AI Agent 文件 1.2.0: 本機或外部 MCP 伺服器的所選工具, 按伺服器設定風險等級, mcp 工具組預設關閉
* `優化` 同步 3-Stove Agent 按需連線文件: 外掛中心統一啟用, 官方首次安裝自動啟用並尊重停用, 同步呼叫首次連線的工作執行緒要求, 非同步查詢, status 唯讀與任務不重播
* `優化` installer / $installer 指令碼介面, 同步與非同步安裝, 工作階段事件, 來源檢查, 解除安裝與授權方式, 包含預設互動和取消語義
* `優化` installer P8: Dhizuku 授權, notification 安裝, preferred/persistent 預設模式及插件能力限制
* `優化` 明確安裝器持久預設界限: Dhizuku API 26-33, Root/system 身分與 user 0, 自動授權篩選, 本機配置回執和未確認寫入
* `優化` Installer 進階安裝選項, 擁有權與 DexOpt 觀察結果, optimizing 階段, V3 能力協商及本機簽章/黑名單界限

# v6.8.4

###### 2026/09/26

* `優化` 同步 AI Agent 1.1.0 開發版本的 script_dynamic 工具組, 每份原始碼單獨確認, 私有原始碼記錄及透過系統檔案選擇器儲存登記指令碼的流程

# v6.8.3

###### 2026/09/25

* `優化` 說明 Agent 1.0.0 的 Android 與宿主要求, 3-Stone AI 模型目錄及文字/OCR 觀察範圍, 文件內容維持 6.8.0 並使用獨立外掛發行版本
* `優化` 同步 Agent 全域工具組, 審慎模式, 預設預算與協議上限, 以及預設和單次任務的收緊規則
* `優化` 同步 Agent 偏好記憶, 逐項確認, 作用域查詢, JSON 匯入/匯出及自動注入與記憶工具的區別
* `優化` 同步 Agent 命名預設, 預設值選擇, 模型選擇, 固定上下文合併及工具, 預算, 確認, 腳本目錄和記憶作用域的收緊規則
* `優化` 同步 ai.agent 任務 API, AgentRun 生命週期, 詢問與確認, 預算, 登記指令碼結果, 三個範例及離線搜尋索引
* `優化` 同步電子書 (EPUB) 參考文檔與離線搜索索引, 覆蓋 Readium EPUB Reader 插件的 epub 全局對象, EpubBook 的元數據, 目錄, 閱讀順序, 正文提取, 封面與資源導出及全文搜索, EpubReaderSession 的事件, 控制方法與閱讀偏好, EpubLocator 位置對象及 EpubError 錯誤代碼
* `優化` 同步電子書 (EPUB) 參考文檔與離線搜索索引, 補充 Readium EPUB Reader 插件 1.1.0 的高亮與筆記 (EPUB 契約版本 2): EpubBook#annotations 與便捷層 epub.annotations, EpubReaderSession 的 highlight 事件及 EpubLocator 的攜帶位置

# v6.8.0

###### 2026/09/19

* `修復` 離線文件校驗器不再將公開 Node 橋接方法名稱 `callAutoJs` 誤判為舊版裸產品名稱
* `修復` AGP 9.1 構建時的 SDK XML v4 解析警告及 JVM 單元測試組裝任務誤觸發 APK 原生程式庫對齊檢查的問題 (共用構建外掛 1.8.3)
* `優化` 同步座標點擊 API, maxAttempts 預設 0 的無限嘗試語義, Flow 異常任務堆疊與主控台輸出及離線搜尋索引
* `優化` 同步 Flow 可選步驟, 有界循環, 鏈式候選查找與點擊, 集合穩定快照及預設值說明, 並更新離線搜尋索引
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
* `優化` 同步郵件 (Mail) 參考文檔與離線搜索索引, 覆蓋 Angus Mail 插件的 mail 全局對象, MailClient 的收發, 搜索, 附件, 標記, 文件夾與監聽方法, MailMessage, MailAccountOptions 與服務商預設, MailSearchQuery 及 MailError 錯誤代碼

# v6.8.2

###### 2026/09/15

* `優化` 將 compileSdk 與 targetSdk 提升到 37 (Android 17), 插件行為不受新目標版本影響

# v6.8.1

###### 2026/09/14

* `優化` 同步封裝應用程式儲存空間引導文件, 包括 requiresSharedStorage, 拒絕授權, 設定返回及桌面入口恢復
* `優化` 同步 Media 文檔與搜尋索引, 說明 Media3 音樂服務, 指令碼播放擁有權, 工作執行緒準備, 通知控制與打包應用程式權限
* `優化` 同步 Pangu 參考文件與搜尋索引, 涵蓋內置 pangu.js 10.1.0, 全域物件, 文字間距處理與間距檢查
* `優化` 同步 HTTP 的 isInsecure / insecure 請求範圍, 共用用戶端設定及憑證信任, CT, ECH 和本地網絡權限說明
* `優化` 同步 Media, Device, TTS 和 Settings 的 Android 17 後台音頻運行條件, 靜默抑制, 可見介面恢復操作與 TTS 引擎進程邊界
* `優化` 校驗發行簽署設定, 預期 APK 集合與可重現文件

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
