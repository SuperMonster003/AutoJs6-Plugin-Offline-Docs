******

### 发行历史

******

# v6.8.21

###### 2026/10/19

* `新增` Bun 与 Node.js Worker 的传感器采样及订阅 API, 支持取消和监听器自动释放

# v6.8.20

###### 2026/10/19

* `新增` Node.js Worker 与 Bun 的 database/sqlite API, 支持参数化查询, 事务和数据库持久化

# v6.8.19

###### 2026/10/19

* `新增` Bun 文件与持久化存储 API, 支持独立授权的宿主文件读写及 Node.js 存储互通

# v6.8.18

###### 2026/10/19

* `新增` Bun 无障碍, 应用操作与剪贴板 API 对齐 Node.js 对应接口, 支持独立授权和打包应用

# v6.8.17

###### 2026/10/18

* `新增` Node.js/Bun 的 WebView 屏幕共享适配, 前台服务后台录音及原生后台摄像头录像, 包括 Node Worker 封装

# v6.8.16

###### 2026/10/18

* `新增` WebView getUserMedia/MediaRecorder 流式音视频, 支持等待网页 Promise, 显式申请 Android 媒体权限及 Worker 生命周期管理

# v6.8.15

###### 2026/10/18

* `新增` Node.js/Bun: WebView 视频拍摄与前台 AAC/M4A 录音, 支持媒体参数, 可配置选择等待时限和临时文件清理

# v6.8.14

###### 2026/10/18

* `新增` Node.js/Bun: WebView 完整照片拍摄, 保存和目录选择, 文档字节读取, blob/data 分块下载及所选位置输出

# v6.8.13

###### 2026/10/18

* `新增` Node.js/Bun: WebView HTTP(S) 下载, 系统文件选择及异步 WebViewClient/WebChromeClient 回调, 支持原生导航和资源规则

# v6.8.12

###### 2026/10/18

* `新增` Node.js/Bun: WebView 页面加载与 JavaScript 返回值, Drawer 侧栏, Toolbar 导航与菜单, ViewPager 页面及异步原生事件

# v6.8.11

###### 2026/10/18

* `新增` Node.js/Bun 支持常用 XML 表单与布局组件及原生 View 异步属性代理, 包含顺序赋值, 错误恢复与 Worker 调用

# v6.8.10

###### 2026/10/18

* `新增` Node.js/Bun 支持执行所属 View 句柄, 异步 AndroidView 工厂与 XML Compose 容器挂载, 同步支持 Worker 清理及打包应用

# v6.8.9

###### 2026/10/18

* `新增` Node.js/Bun UI 与 Compose 支持原生布局, 数据组件, 响应式状态及窗口事件, 提供独立授权与窗口自动清理

# v6.8.8

###### 2026/10/17

* `新增` Node.js/Bun images 支持高级滤镜, 颜色空间转换, 多点找色, 圆检测, 相似度指标及 URL 载入
* `新增` Node.js/Bun images 支持 SIFT/ORB 特征提取与匹配, 返回场景坐标和 ObjectFrame 几何信息, 并管理执行内的 Mat/特征句柄
* `新增` Node.js/Bun images 支持 PNG 量化和压缩, 提供质量/内存度量, 二进制结果及文件描述符输出

# v6.8.7

###### 2026/10/17

* `新增` Node.js 主线程与 Worker 支持 H.264 MP4 录屏, 麦克风/播放/混合 AAC 音频, 录制期间并行截图及 Worker 未保存录屏清理 (API / TypeScript / Ace)

# v6.8.6

###### 2026/10/17

* `修复` README 中的文档来源提交与实际打包来源记录不一致的问题
* `优化` Bun screenRecorder 支持 H.264 MP4 录屏, 可选麦克风/应用播放/混合 AAC 音轨及录制期间截图, 包含独立音频授权和取消清理 (API documentation)
* `优化` Bun screenRecorder 支持无声 H.264 MP4 录屏文件, 独立授权, 固定输出尺寸, 显式收尾及取消清理 (API documentation)
* `优化` Node.js Worker 支持 pinyin, pinyin4j, 控制台窗口和坐标换算, 共享父执行状态并保留原生输出流 (API documentation)
* `优化` 运行时 API 文档, 包含 Bun 截图授权及 Node.js Worker 的 OpenCC/图像模块
* `优化` Node.js 和 Bun 的 OpenCC 与图像 API 文档, 包含异步句柄, 像素格式, 权限和传输上限
* `优化` Rhino speech API 参考: 识别, 唤醒与听写会话, 语音活动检测, 合成及 speech.models 模型管理
* `优化` Node.js 和 Bun 运行时 API 指南, 覆盖异步拼音, 控制台, 坐标换算与编辑器声明边界
* `优化` Installer 来源/包名前缀配置, 显式选项优先与三个可空重置字段, sourceDeleteRequested 及批量共享来源保留, 需要宿主 5312+ 和插件对应能力
* `优化` 选择器 minDepth/maxDepth/minIndexInParent/maxIndexInParent 的方法说明与离线搜索索引
* `优化` 3-Block Compose 完整 API 参考: 节点与状态, Modifier, 主题, 会话与悬浮窗, 组件属性和事件, 线程规则, 无障碍与打包应用
* `优化` 3-Block Compose TSX: TSX 支持 `<compose.Column>`, `<compose:Text>`, 节点工厂引用, Fragment, 插槽及响应式回调; 同一棵树不能混用 Compose 与旧 XML 节点
* `优化` Terminal 模块参考: 3-Shell Terminal 插件的同步与异步会话, 输出事件, npm 脚本, 权限与生命周期, 以及 TerminalSession, TerminalOpenOptions 与 TerminalError 类型
* `优化` colors 模块参考: OKLab/OKLCH 转换, 对比度调整, 和谐色, 色阶, 派生配色, 夜间对应色, 色觉缺陷模拟, 图像主要颜色提取, oklab 颜色检测算法及 colors.theme 主题色控制
* `优化` 插件中心图标采用统一工作台调整后的尺寸, 位置, 亮暗图稿与圆形底色, 保留可重建原稿和参数
* `优化` Android 系统应用信息图标与图标工作台共用图稿和亮暗底色, 保留插件中心透明图稿及现有启动器选项
* `优化` 3-Block Compose: XML `<compose>` 容器与 compose.attach 可在 UI 页面或旧悬浮窗内嵌入独立 Compose 会话; compose.AndroidView 可承载现有 Android View 或同步工厂返回的 View
* `优化` 3-Block Compose 参考文档补充独立对话框和底部弹层, 包含取消规则, 悬浮窗权限与会话生命周期
* `优化` 3-Block Compose V2 组件参考, 包含受控状态, 事件, 焦点与滚动命令, 使用条件和兼容性
* `优化` 设备模块参考文档: device.getAndroidId 支持 useSystemId 布尔参数, 在 Android 8.0+ 上通过 Shizuku/Root 获取运行应用所属 Android 用户的系统值, 权限或读取失败时抛出异常, 旧系统忽略此参数
* `优化` AutoJs4 运行时参考文档: AutoJs4 Runtime 插件的用途, 安装与独立权限, 文件管理器 "使用 AutoJs4 运行" 对 .js / .auto 文件及项目文件夹的入口, 日志回传与任务停止, 运行限制及差异反馈方式
* `优化` AutoJs4 运行时参考文档: 补充 "使用 AutoJs4 运行并对照" 的对照模式, 说明两次运行流程, 起止行与前缀的剔除规则, 结果页的摘要与差异标记, issue 模板复制以及 120 秒超时
* `优化` AutoJs4 运行时参考文档: 补充 "com.stardust 兼容类" 小节, 说明 com.stardust 前缀的类名如何映射到 AutoJs6 的实现 (完整映射, 部分映射与不再提供三类), 改名映射对 importClass 全局名的影响, 以及 Class.forName 不受映射影响
* `优化` 3-Block Compose 设计器参考文档: 插件内置可视化设计器的入口与工程文件, 编辑页的画布 / 大纲 / 属性 / 状态 / 组件面板, 横竖屏布局与草稿, 可识别的脚本子集与往返规则, 与 AutoJs6 编辑器的双向交接, 导入来源的写回与重新导入, 预览状态与交互预览及其与真实运行的差异, TSX 工程 (经 TypeScript Engine 解析, 缺少时只读打开), 交互预览中在沙箱运行 JavaScript 工程的脚本与控制台 (Android 8.0 或更高版本), UI (XML) 工程 (1.6.0 起: 原样编辑 ui 模式脚本的 XML 布局, 画布由 AutoJs6 的预览服务绘制, 事件桩与绑定值面板), 以及当前限制; 1.7.0 起 UI (XML) 工程的交互预览由 AutoJs6 真实运行整份脚本 (Android 13 起), 新增 "在预览中运行 UI 脚本" 小节说明条件, 停止规则, 控制台与和真实运行的差异; 1.8.0 起新增 "预览差异" 一节 (在预览中与在 AutoJs6 中运行行为不同的写法) 与 "XML 文件与文件夹工程" 一节 (以字面量路径引用的 XML 布局文件, 存为 / 新建 XML 文件, 文件夹工程与 project.json, zip 导入导出, 交给 AutoJs6 运行与导入, 外部文档的文件夹授权, 预览中的工程文件, Android 原生 XML 的编辑与检查)
* `优化` Android XML 属性参考: UI 原生 Android XML 布局中每个 View 类可设置与不能设置的 android: / app: 属性, 取值格式, 枚举与标志名, 起始 API 与设置方式, 以及各父布局接受的布局参数; 用户界面参考补充工程资源 (res/ 目录, 限定符目录与 vector 矢量图)
* `优化` [API 参考](https://docs.autojs6.com/#/documentation) 补齐 Files 与 RootAutomator 成员, 颜色结果容器, WebView 上下文和可选参数重载, 校正字节追加与滑动参数, 同步坐标缩放说明, 说明 setScaleBases 失败时不修改或占用基数, 以及基数 setter 的整数转换规则
* `优化` 相册 (Gallery) 模块参考: 3-Maple Image 插件提供的 gallery 对象, 包括选图, 查看器会话, 编辑与无界面转换, 文件由 AutoJs6 读写的边界, 照片访问权限与错误代码, 以及 GalleryViewSession 类型
* `优化` files.batchRename 参考: Batch Rename 插件提供的批量重命名, 包括方案预览与逐项排除, 执行, 撤销与历史批次, 选项与替换变量, 冲突策略, 结果对象及错误代码
* `优化` plugins.tools 参考: AutoJs6 插件自描述的工具, 包括列出工具与提供者, 同步与异步调用, 图片 / 文件参数与输出文件, 结果对象及错误

# v6.8.5

###### 2026/10/02

* `优化` AI Agent 文档 1.2.0: 本机或外部 MCP 服务器的选定工具, 按服务器设置风险等级, mcp 工具组默认关闭
* `优化` 同步 3-Stove Agent 按需连接文档: 插件中心统一启用, 官方首次安装自动启用并尊重禁用, 同步调用首次连接的工作线程要求, 异步查询, status 只读与任务不重放
* `优化` installer / $installer 脚本接口, 同步与异步安装, 会话事件, 来源检查, 卸载与授权方式, 包含默认交互和取消语义
* `优化` installer P8: Dhizuku 授权, notification 安装, preferred/persistent 默认模式及插件能力限制
* `优化` 明确安装器持久默认边界: Dhizuku API 26-33, Root/system 身份与 user 0, 自动授权筛选, 本地配置回执和未确认写入
* `优化` Installer 高级安装选项, 所有权与 DexOpt 观察结果, optimizing 阶段, V3 能力协商及本地签名/黑名单边界

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

# v6.8.0

###### 2026/09/19

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
* `优化` 增加文档及 APK 校验, 覆盖内容摘要, 契约, 链接, 安装包结构及许可证
* `优化` 记录内置文档对应的宿主提交及源码路径
