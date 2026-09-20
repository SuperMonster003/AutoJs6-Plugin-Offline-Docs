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
fileCount=190
totalBytes=11166177
contentSha256=651bff52e5971a21535b50c541aaeec88dda97db9c7cfa2378d27f21c46387fa
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

###### 2026/09/19

* `修复` 离线文档校验器不再将公开 Node 桥接方法名 `callAutoJs` 误判为旧版裸产品名称
* `修复` AGP 9.1 构建时的 SDK XML v4 解析警告及 JVM 单元测试组装任务误触发 APK 原生库对齐检查的问题 (共享构建插件 1.8.3)
* `优化` 同步坐标点击 API, maxAttempts 默认 0 的无限尝试语义, Flow 异常任务栈与控制台输出及离线搜索索引
* `优化` 同步 Flow 可选步骤, 有界循环, 链式候选查找与点击, 集合稳定快照及默认值说明, 并更新离线搜索索引
* `优化` 同步运行时本地网络权限文档与离线搜索索引, 说明 Android 17 / targetSdk 37 条件, 异步授权, 重试及原生 Socket / MQTT 和插件权限边界
* `优化` 同步 `device.pageSize` 参考文档与离线搜索索引, 说明页大小的字节单位, 只读属性及运行环境与原生库兼容性的区别
* `优化` 同步 OCR 参考文档与离线搜索索引, 补充引擎自动选择, 实时模式读取, tap 重置, 单次调用选项及无可用插件时的行为
* `优化` 同步 MediaInfo 参考文档与离线搜索索引, 补充兼容 `read` 与版本化 `snapshot` 的边界, 插件快照 v1/v2 schema 协商, 轻量 `capabilities` 以及动态 v2 track 和引擎信息
* `优化` 同步 Pinyin 参考文档与离线搜索索引, 补充仅当前调用生效的 `customDictionary` 自定义读音覆盖, 已完成的 `compare`/`compact`, 以及通过带显式 `pinyin` capability 的 `autojs6:bridge.callAutoJs` 进行 Node.js 访问
* `优化` 同步 Image Quantization v4 参考文档与离线搜索索引, 新增可配置的像素及工作内存预算, 类型化资源上限诊断, 已计入预算的峰值内存指标, 以及显式请求或脚本退出时的取消机制
* `优化` 使插件 versionName 与目标 AutoJs6 文档版本保持一致, 并在文档同步成功时将两个项目各自的 build/versionCode 自动增加 1
* `优化` 更新内置 AutoJs6 6.8.0 文档及离线搜索索引, 补充 YOLO 目标检测 Preview API 的精确提供方配置, 模型配置, 返回类型及稳定错误码
* `优化` 完善内置 AI 参考文档, 覆盖插件模型发现, 官方与精确组件选择器, 多角色消息历史, 生成参数, 精确用量和流式负载, 以及完整路由示例
* `优化` 扩充内置 AI 参考文档及离线搜索索引, 补充持久 `ai.session` Conversation API, 固定会话参数, 每轮仅传新提示词的生命周期规则, 能力发现及显式资源释放语义
* `优化` 扩充内置 AI 参考文档及离线搜索索引, 补充 `structuredJson`/`responseSchema` 原生 JSON Schema 约束输出, 持久会话固定 schema, JSON 文本返回及失败语义
* `优化` 扩充内置 AI 参考文档及离线搜索索引, 补充显式 CPU/GPU/NPU backend profile, `ai.catalog` 设备可用性及稳定不可用原因, 持久会话固定 backend, GPU 兼容性限制和禁止回退契约
* `优化` 以统一 `ai.catalog` 目标目录直接替换全部未发布的 AI 列表与配置探测 API, 补齐精确 `target` 路由, 完整响应与会话元数据, 稳定禁止回退错误, 并同步在线/离线资产
* `优化` 扩充内置 runtime 参考文档及离线搜索索引, 补充用于校验 mapping/seeds/usage/retrace metadata 导出的 6 个 `loadJarWithR8` 重载及协议 1.1 `retraceR8Stack` API, 并说明溯源绑定与失败即终止的禁止回退语义
* `优化` 统一 README 版式与 Gradle 平台版本管理方式
* `优化` MediaInfo 参考文档与离线搜索同步 streamNumber, countGet, infoKind 和原始文件路径语义
* `优化` 构建阶段阻止意外引入原生依赖, 并输出 JSON 校验报告
* `优化` 同步邮件 (Mail) 参考文档与离线搜索索引, 覆盖 Angus Mail 插件的 mail 全局对象, MailClient 的收发, 搜索, 附件, 标记, 文件夹与监听方法, MailMessage, MailAccountOptions 与服务商预设, MailSearchQuery 及 MailError 错误代码

# v6.8.2

###### 2026/09/15

* `优化` 将 compileSdk 与 targetSdk 提升到 37 (Android 17), 插件行为不受新目标版本影响

# v6.8.1

###### 2026/09/14

* `优化` 同步打包应用存储引导文档, 包括 requiresSharedStorage, 拒绝授权, 设置返回及桌面入口恢复
* `优化` 同步 Media 文档与搜索索引, 说明 Media3 音乐服务, 脚本播放所有权, 工作线程准备, 通知控制与打包应用权限
* `优化` 同步 Pangu 参考文档与搜索索引, 覆盖内置 pangu.js 10.1.0, 全局对象, 文本间距处理与间距检查
* `优化` 同步 HTTP 的 isInsecure / insecure 请求范围, 共享客户端配置及证书信任, CT, ECH 和本地网络权限说明
* `优化` 同步 Media, Device, TTS 和 Settings 的 Android 17 后台音频运行条件, 静默抑制, 可见界面恢复操作与 TTS 引擎进程边界
* `优化` 校验发行签名配置, 预期 APK 集合与可复现文档

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
