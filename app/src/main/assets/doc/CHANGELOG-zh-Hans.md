******

### 发行历史

******

# v6.8.0

###### 2026/09/01

* `修复` 离线文档校验器不再将公开 Node 桥接方法名 `callAutoJs` 误判为旧版裸产品名称
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
