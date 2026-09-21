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
fileCount=194
totalBytes=11442956
contentSha256=3831c6a745e0a9a8fbd2f410e6c478e42c7d891b0febb8291fe2c7f2026ec509
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=b20d9601fba77b1f67cb1931f42ca83f0273df6f
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

###### 2026/09/21

* `修复` 离线文档校验将公开方法 callAutoJs 误判为旧版产品名称的问题
* `修复` AGP 9.1 构建时的 SDK XML v4 解析警告, 以及 JVM 单元测试误触发 APK 原生库对齐检查的问题 (共享构建插件 1.8.3)
* `优化` 同步坐标点击, 无限重试及 Flow 异常诊断文档和搜索索引
* `优化` 同步 Flow 可选步骤, 循环, 链式查找, 集合快照及默认值文档
* `优化` 同步 Android 17 本地网络权限文档, 补充授权, 重试及 Socket/MQTT 和插件的权限说明
* `优化` 同步 device.pageSize 文档, 说明返回值单位及内存页兼容性
* `优化` 同步 OCR 引擎选择, 模式读取, tap 重置及单次调用选项文档
* `优化` 同步 MediaInfo read/snapshot/capabilities 文档, 补充 v1/v2 快照及引擎信息
* `优化` 同步 Pinyin 自定义词典, compare/compact 及 Node.js 桥接文档
* `优化` 同步 Image Quantization v4 文档, 补充像素及内存预算, 资源诊断和取消机制
* `优化` 插件版本名跟随目标文档版本, 同步成功后自动更新构建号
* `优化` 同步 YOLO 预览版接口文档, 补充插件选择, 模型配置, 返回值及错误码
* `优化` 补充 AI 模型发现, 目标选择, 多角色历史, 生成参数, 用量及流式输出文档
* `优化` 补充 ai.session 持久会话文档, 包含会话参数, 多轮输入及资源释放
* `优化` 补充 structuredJson/responseSchema 文档, 包含 JSON Schema 约束, 持久会话及错误处理
* `优化` 补充 CPU/GPU/NPU 后端选择及 ai.catalog 可用性文档, 说明兼容性和不可用时的行为
* `优化` AI 文档改用统一的 ai.catalog 目录, 补充目标路由, 响应及会话元数据
* `优化` 补充 loadJarWithR8 导出及 retraceR8Stack 调用栈还原文档, 说明产物校验及失败行为
* `优化` 统一 README 版式与 Gradle 平台版本管理方式
* `优化` MediaInfo 参考文档与离线搜索同步 streamNumber, countGet, infoKind 和原始文件路径语义
* `优化` 构建阶段阻止意外引入原生依赖, 并输出 JSON 校验报告
* `优化` 同步 Mail 文档, 覆盖账户, 收发, 搜索, 附件, 标记, 文件夹, 监听及错误码
* `优化` 同步 EPUB 文档, 覆盖书籍读取, 内容提取, 导出, 搜索及阅读器会话控制
* `优化` 补充 Readium EPUB Reader 1.1.0 的高亮及笔记文档, 包含 annotations 查询, highlight 事件及位置对象

# v6.8.2

###### 2026/09/15

* `优化` compileSdk/targetSdk 升级至 37 (Android 17)

# v6.8.1

###### 2026/09/14

* `优化` 同步打包应用存储引导文档, 包括 requiresSharedStorage, 拒绝授权, 设置返回及桌面入口恢复
* `优化` 同步 Media 文档与搜索索引, 说明 Media3 音乐服务, 脚本播放所有权, 工作线程准备, 通知控制与打包应用权限
* `优化` 同步 Pangu 参考文档与搜索索引, 覆盖内置 pangu.js 10.1.0, 全局对象, 文本间距处理与间距检查
* `优化` 同步 HTTP 的 isInsecure / insecure 请求范围, 共享客户端配置及证书信任, CT, ECH 和本地网络权限说明
* `优化` 同步 Media, Device, TTS 和 Settings 的 Android 17 后台音频运行条件, 静默抑制, 可见界面恢复操作与 TTS 引擎进程边界
* `优化` 完善发行签名, APK 变体及生成文档一致性校验

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
