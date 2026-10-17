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
fileCount=219
totalBytes=13927234
contentSha256=ffd92a31dde510cba10288d0f786e312b8dac8a3f4db1e14d23351c3b83daf53
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=7e4cef59327a3534e9f3f1dc16de3b3d23059edd
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

# v6.8.9

###### 2026/10/18

* `新增` Node.js/Bun UI 與 Compose 支援原生版面配置, 資料元件, 響應式狀態及視窗事件, 提供獨立授權與視窗自動清理

# v6.8.8

###### 2026/10/17

* `新增` Node.js/Bun images 支援進階濾鏡, 色彩空間轉換, 多點尋色, 圓形偵測, 相似度指標及 URL 載入
* `新增` Node.js/Bun images 支援 SIFT/ORB 特徵擷取與比對, 回傳場景座標和 ObjectFrame 幾何資訊, 並管理執行內的 Mat/特徵控制代碼
* `新增` Node.js/Bun images 支援 PNG 量化和壓縮, 提供品質/記憶體度量, 二進位結果及檔案描述元輸出

# v6.8.7

###### 2026/10/17

* `新增` Node.js 主執行緒與 Worker 支援 H.264 MP4 螢幕錄影, 麥克風/播放/混合 AAC 音訊, 錄製期間並行截圖及 Worker 未儲存錄影清理 (API / TypeScript / Ace)

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
