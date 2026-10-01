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
fileCount=200
totalBytes=11721912
contentSha256=9a11dc5d1a8a6ef9c66d00b274a7bc803936859d01a4803c405097184b543c22
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=d5e012e6f0680ceaacc358ce9208aebab3e39c78
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

# v6.8.5

###### 2026/10/02

* `优化` AI Agent 文档 1.2.0: 本机或外部 MCP 服务器的选定工具, 按服务器设置风险等级, mcp 工具组默认关闭
* `优化` 同步 3-Stove Agent 按需连接文档: 插件中心统一启用, 官方首次安装自动启用并尊重禁用, 同步调用首次连接的工作线程要求, 异步查询, status 只读与任务不重放
* `优化` installer / $installer 脚本接口, 同步与异步安装, 会话事件, 来源检查, 卸载与授权方式, 包含默认交互和取消语义
* `优化` installer P8: Dhizuku 授权, notification 安装, preferred/persistent 默认模式及插件能力限制

# v6.8.4

###### 2026/09/26

* `优化` 同步 AI Agent 1.1.0 开发版本的 script_dynamic 工具组, 每份源码单独确认, 私有源码记录及通过系统文件选择器保存登记脚本的流程

# v6.8.3

###### 2026/09/25

* `优化` 说明 Agent 1.0.0 的 Android 与宿主要求, 3-Stone AI 模型目录及文本/OCR 观察范围, 文档内容保持 6.8.0 并使用独立插件发行版本
* `优化` 同步 Agent 全局工具组, 审慎模式, 默认预算与协议上限, 以及预设和单次任务的收紧规则
* `优化` 同步 Agent 偏好记忆, 逐条确认, 作用域查询, JSON 导入/导出及自动注入与记忆工具的区别
* `优化` 同步 Agent 命名预设, 默认选择, 模型选择, 固定上下文合并及工具, 预算, 确认, 脚本目录和记忆作用域的收紧规则
* `优化` 同步 ai.agent 任务 API, AgentRun 生命周期, 询问与确认, 预算, 登记脚本结果, 三个示例及离线搜索索引
* `优化` 同步 EPUB 文档, 覆盖书籍读取, 内容提取, 导出, 搜索及阅读器会话控制
* `优化` 补充 Readium EPUB Reader 1.1.0 的高亮及笔记文档, 包含 annotations 查询, highlight 事件及位置对象

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


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/docs/16kb.md)
