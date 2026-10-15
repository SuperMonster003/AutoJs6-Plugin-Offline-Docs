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
fileCount=216
totalBytes=13277573
contentSha256=cfebb0216048caf6645971e373b937f05017530bdc5281f50060e8c46deb1e31
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=62f55d88843db5a5a38d529de887b756a1d085f0
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

# v6.8.6

###### 2026/10/15

* `修復` README 中的文件來源提交與實際封裝來源記錄不一致的問題
* `優化` Installer 來源/套件名稱前綴設定檔, 明確指定的選項優先與三個可空重設欄位, sourceDeleteRequested 及批次共用來源保留, 需要主程式 5312+ 及外掛對應能力
* `優化` 選擇器 minDepth/maxDepth/minIndexInParent/maxIndexInParent 的方法說明與離線搜尋索引
* `優化` 3-Block Compose 完整 API 參考: 節點與狀態, Modifier, 主題, 工作階段與浮動視窗, 元件屬性和事件, 執行緒規則, 無障礙與封裝應用程式
* `優化` 3-Block Compose TSX: TSX 支援 `<compose.Column>`, `<compose:Text>`, 節點工廠參照, Fragment, 插槽及響應式回呼; 同一棵樹不能混用 Compose 與舊 XML 節點
* `優化` Terminal 模組參考: 3-Shell Terminal 外掛的同步與非同步工作階段, 輸出事件, npm 指令碼, 權限與生命週期, 以及 TerminalSession, TerminalOpenOptions 與 TerminalError 型別
* `優化` colors 模組參考: OKLab/OKLCH 轉換, 對比度調整, 和諧色, 色階, 衍生配色, 夜間對應色, 色覺缺陷模擬, 圖片主要顏色擷取, oklab 顏色偵測演算法及 colors.theme 主題色控制
* `優化` 外掛程式中心圖示採用統一工作台調整後的尺寸, 位置, 明暗圖稿與圓形底色, 保留可重建原稿和參數
* `優化` Android 系統應用程式資訊圖示與圖示工作台共用圖稿及明暗底色, 保留外掛程式中心透明圖稿與現有啟動器選項
* `優化` 3-Block Compose: XML `<compose>` 容器與 compose.attach 可在 UI 頁面或舊浮動視窗內嵌入獨立 Compose 工作階段; compose.AndroidView 可承載現有 Android View 或同步工廠傳回的 View
* `優化` 3-Block Compose 參考文件補充獨立對話框和底部面板, 包含取消規則, 懸浮視窗權限與工作階段生命週期
* `優化` 3-Block Compose V2 元件參考, 包含受控狀態, 事件, 焦點與捲動命令, 使用條件和相容性
* `優化` 裝置模組參考文件: device.getAndroidId 支援 useSystemId 布林參數, 在 Android 8.0+ 上透過 Shizuku/Root 取得執行應用所屬 Android 使用者的系統值, 權限或讀取失敗時擲出例外, 舊系統忽略此參數
* `優化` AutoJs4 執行時參考文件: AutoJs4 Runtime 外掛的用途, 安裝與獨立權限, 檔案管理器 "使用 AutoJs4 執行" 對 .js / .auto 檔案及專案資料夾的入口, 日誌回傳與任務停止, 執行限制及差異回饋方式
* `優化` AutoJs4 執行時參考文件: 補充 "使用 AutoJs4 執行並對照" 的對照模式, 說明兩次執行流程, 起止行與前綴的剔除規則, 結果頁的摘要與差異標記, issue 範本複製以及 120 秒逾時
* `優化` AutoJs4 執行時參考文件: 補充 "com.stardust 相容類別" 小節, 說明 com.stardust 前綴的類別名稱如何對應到 AutoJs6 的實作 (完整對應, 部分對應與不再提供三類), 改名對應對 importClass 全域名稱的影響, 以及 Class.forName 不受對應影響
* `優化` 3-Block Compose 設計器參考文件: 外掛內建視覺化設計器的入口與專案檔案, 編輯頁的畫布 / 大綱 / 屬性 / 狀態 / 元件面板, 直橫向版面與草稿, 可識別的指令碼子集與往返規則, 與 AutoJs6 編輯器的雙向交接, 匯入來源的寫回與重新匯入, 預覽狀態與互動預覽及其與實際執行的差異, TSX 專案 (經 TypeScript Engine 解析, 缺少時唯讀開啟), 互動預覽中在沙盒執行 JavaScript 專案的指令碼與主控台 (Android 8.0 或更新版本), UI (XML) 專案 (1.6.0 起: 原樣編輯 ui 模式指令碼的 XML 佈局, 畫布由 AutoJs6 的預覽服務繪製, 事件樣板與繫結值面板), 以及目前限制; 1.7.0 起 UI (XML) 專案的互動預覽由 AutoJs6 真實執行整份指令碼 (Android 13 起), 新增 "在預覽中執行 UI 指令碼" 小節說明條件, 停止規則, 主控台與和真實執行的差異
* `優化` [API 參考](https://docs.autojs6.com/#/documentation) 補齊 Files 與 RootAutomator 成員, 色彩結果容器, WebView 上下文和選用參數多載, 校正位元組附加與滑動參數, 同步座標縮放說明, 說明 setScaleBases 失敗時不修改或占用基數, 以及基數 setter 的整數轉換規則
* `優化` 相簿 (Gallery) 模組參考: 3-Maple Image 外掛提供的 gallery 物件, 包括選圖, 檢視器工作階段, 編輯與無介面轉換, 檔案由 AutoJs6 讀寫的邊界, 相片存取權限與錯誤代碼, 以及 GalleryViewSession 型別
* `優化` files.batchRename 參考: Batch Rename 外掛提供的批次重新命名, 包括方案預覽與逐項排除, 執行, 復原與歷史批次, 選項與替換變數, 衝突策略, 結果物件及錯誤代碼

# v6.8.5

###### 2026/10/02

* `優化` AI Agent 文件 1.2.0: 本機或外部 MCP 伺服器的所選工具, 按伺服器設定風險等級, mcp 工具群組預設關閉
* `優化` 同步 3-Stove Agent 按需連線文件: 外掛中心統一啟用, 官方首次安裝自動啟用並尊重停用, 同步呼叫首次連線的工作執行緒要求, 非同步查詢, status 唯讀與任務不重播
* `優化` installer / $installer 指令碼介面, 同步與非同步安裝, 工作階段事件, 來源檢查, 解除安裝與授權方式, 包含預設互動和取消語義
* `優化` installer P8: Dhizuku 授權, notification 安裝, preferred/persistent 預設模式及外掛能力限制
* `優化` 明確安裝器持久預設界限: Dhizuku API 26-33, Root/system 身分與 user 0, 自動授權篩選, 本機設定回執和未確認寫入
* `優化` Installer 進階安裝選項, 擁有權與 DexOpt 觀察結果, optimizing 階段, V3 能力協商及本機簽章/封鎖清單界限

# v6.8.4

###### 2026/09/26

* `優化` 同步 AI Agent 1.1.0 開發版本的 script_dynamic 工具組, 每份原始碼個別確認, 私有原始碼記錄及透過系統檔案選擇器儲存登記指令碼的流程

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
