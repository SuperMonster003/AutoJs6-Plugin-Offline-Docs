<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>适用于 AutoJs6 的 6.8.0 离线文档内容插件</p>

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

### 语言 (Languages)

******

当前 README.md 支持以下语言:

- 简体中文 [zh-Hans] # 当前
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ar.md)

******

### 简介

******

AutoJs6 Offline Documentation 插件将完整的 6.8.0 文档站点作为可独立安装的内容包提供.

******

### 插件契约

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
fileCount=180
totalBytes=9940465
contentSha256=85f4791cf50ec068aa31dad06e621ada3cf82f86e3e08b2f0c37ed4753530544
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=8aed22caaa7c1c4dcd3c93389e5f93ce5e18f64c
sourcePath=api
sourceGenerator=generator/auto-generate-for-autojs6.bat
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

OfflineDocsPluginInfoService 通过 IPluginInfoProvider 发布 PluginInfo. 宿主仅在固定包名通过启用状态, 兼容性, 签名, 元数据, 清单和文件内容自洽性检查后接受插件.

******

### 内容

******

内容元数据和清单根据 `assets/docs/` 中的当前文档资产自动生成. 宿主验证元数据, 清单和文件内容相互一致. 离线文档支持按标题和正文进行全文搜索, 并可从搜索结果直接跳转到匹配章节.

******

### 构建与校验

******

构建两种变体, 运行 JVM 测试, 并执行 APK 门禁, 校验动态生成的内容元数据, 契约元数据, 断链, 单一 universal APK, 无 `lib/*.so` 载荷和许可证:

```powershell
.\gradlew.bat :app:testDebugUnitTest :app:verifyOfflineDocsApks
```

可发布 Release APK 的校验还要求配置未纳入版本控制的 `sign.properties`:

```powershell
.\gradlew.bat :app:verifyOfflineDocsPublishableApks
```

******

### 运行时行为

******

插件不提供独立界面. AutoJs6 按需发现并验证插件, 然后通过专用 WebView 资源加载器直接从插件 AssetManager 提供文档. 插件被替换或停用时, 宿主会检测到状态变化.

******

### 发行历史

******

# v6.8.0

###### 2026/08/12

* `优化` 刷新 AutoJs6 6.8.0 API 文档, 补充通过独立 Python Runtime 插件启动本地 Python 文件以及失败时不回退到 JavaScript 的行为
* `优化` 使插件 versionName 与目标 AutoJs6 文档版本保持一致, 并在文档同步成功时将两个项目各自的 build/versionCode 自动增加 1

# v1.0.1

###### 2026/07/25

* `优化` 将固定内容指纹基线改为根据当前文档资产自动生成内容元数据和清单, 使资产可直接更新
* `优化` 改为从 AutoJs6 官方 Markdown 源生成并同步离线文档, 使在线和离线内容保持一致
* `优化` 将内置文档统一为 AutoJs6 API 参考风格, 规范当前产品名称, JavaScript 变量声明, 本地类型链接, 待完善章节提示和 ASCII 标点符号
* `优化` 完善离线文档浏览体验, 支持按标题和全文内容搜索并直接跳转到匹配章节

# v1.0.0

###### 2026/07/23

* `新增` 发布独立的 AutoJs6 6.6.4 离线文档内容插件, 支持契约版本 1 发现机制并提供单一 universal APK
* `新增` 打包 161 个文档文件, 本地化插件元数据及完整的 Apache-2.0, GPL-3.0, MIT 和 OFL-1.1 许可证说明
* `优化` 增加 JVM 和 APK 门禁, 校验规范内容指纹, 契约元数据, 已知断链基线, 单一 universal 产物, 无 `lib/*.so` 载荷和许可证资产
* `优化` 记录逐字节文档载荷对应的 AutoJs6 源提交和源路径

##### 更多发行历史可参阅

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/assets/doc/CHANGELOG-zh-Hans.md)

******

### 许可证

******

源自 AutoJs6-Documentation 的文档使用 Apache-2.0 授权. Node.js 文档模板, 样式和衍生内容与 medium-zoom, docsify-copy-code 及 dnt-helper 使用 MIT. SHJS 使用 GPL-3.0. Lato 使用 OFL-1.1.

每个 APK 均在 `assets/licenses/docs/` 中包含署名摘要及完整的 Apache-2.0, GPL-3.0, MIT 和 OFL-1.1 许可证文本.

******

### 资源结构

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

`strings.xml` 提供插件描述本地化; `plugin_instruction.md` 提供宿主侧展示的插件说明. `.python/normalize_offline_docs.py` 以只读方式校验生成后的离线文档. README 与 CHANGELOG 由 `.python/generate_markdown.py` 根据 JSON 源文件生成, 完整 CHANGELOG 输出到 `app/src/main/assets/doc/`.

******

### 相关链接

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)
