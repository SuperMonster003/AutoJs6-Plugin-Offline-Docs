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
fileCount=224
totalBytes=14730312
contentSha256=21ff636a0a4bd3d76ec3d676923e32ea28eabc39be88876ac9014b8f87351eaa
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=e8749a1e33c55b2a3cf949eea3e8cec130abbc94
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

# v6.8.34

###### 2026/10/21

* `优化` 文档同步: 邮件账户连接, 邮件操作, 附件与邮箱监听, 支持取消及 Worker 退出清理

# v6.8.33

###### 2026/10/21

* `优化` 文档 - Node.js/Bun/Worker: EPUB 书籍读取, 资源导出, 搜索及带事件的阅读器会话

# v6.8.32

###### 2026/10/20

* `新增` Node.js/Bun/Worker 的 speech 语音识别与模型管理接口, 支持 WAV/PCM, 听写与唤醒会话, 模型安装/导入, 语音合成和取消清理

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
