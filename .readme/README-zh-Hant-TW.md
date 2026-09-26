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
totalBytes=11605704
contentSha256=5d60c61cce1d134871562773370b2138dc9471676557b7a49288673d166c6da6
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=f9ed7afe41f2cdf2603dc281323be33869ced6d7
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

# v6.8.5

###### 2026/09/26

* `優化` AI Agent 文件 1.2.0: 本機或外部 MCP 伺服器的所選工具, 按伺服器設定風險等級, mcp 工具群組預設關閉

# v6.8.4

###### 2026/09/26

* `優化` 同步 AI Agent 1.1.0 開發版本的 script_dynamic 工具組, 每份原始碼個別確認, 私有原始碼記錄及透過系統檔案選擇器儲存登記指令碼的流程

# v6.8.3

###### 2026/09/25

* `優化` 說明 Agent 1.0.0 的 Android 與宿主要求, 3-Stone AI 模型目錄及文字/OCR 觀察範圍, 文件內容維持 6.8.0 並使用獨立外掛發行版本
* `優化` 同步 Agent 全域工具組, 審慎模式, 預設預算與協定上限, 以及預設和單次任務的收緊規則
* `優化` 同步 Agent 偏好記憶, 逐項確認, 作用域查詢, JSON 匯入/匯出及自動注入與記憶工具的區別
* `優化` 同步 Agent 命名預設, 預設值選擇, 模型選擇, 固定上下文合併及工具, 預算, 確認, 腳本目錄和記憶作用域的收緊規則
* `優化` 同步 ai.agent 任務 API, AgentRun 生命週期, 詢問與確認, 預算, 登記腳本結果, 三個範例及離線搜尋索引
* `優化` 同步電子書 (EPUB) 參考文件與離線搜尋索引, 涵蓋 Readium EPUB Reader 外掛的 epub 全域物件, EpubBook 的中繼資料, 目錄, 閱讀順序, 正文擷取, 封面與資源匯出及全文搜尋, EpubReaderSession 的事件, 控制方法與閱讀偏好, EpubLocator 位置物件及 EpubError 錯誤代碼
* `優化` 同步電子書 (EPUB) 參考文件與離線搜尋索引, 補充 Readium EPUB Reader 外掛 1.1.0 的螢光標示與筆記 (EPUB 契約版本 2): EpubBook#annotations 與便捷層 epub.annotations, EpubReaderSession 的 highlight 事件及 EpubLocator 的攜帶位置

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
