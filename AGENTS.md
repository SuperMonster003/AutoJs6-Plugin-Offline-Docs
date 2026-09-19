## 工作区

每次会话开始和结束时, 检查工作区代码, 按需进行一次或分次提交, 除非用户明确表示了本次会话结束时避免自动提交.
提交时, 请检查项目根目录 /.changelog/xxx.json 文件 (多语言支持), 如果本次提交的代码涉及到 "feature"/"fix"/"improvement"/"dependency" 中的一个或多个分类, 则补充更新日志到对应的版本号 JSON 代码中并更新日期为当日日期 (版本号参考 version.properties, 忽略 Alpha/Beta 等后缀). 当前项目支持多语言 changlog, 利用 json + py 脚本来自动生成多语言 README, 当上述 json 文件更新时, 需遵循以下 5 个原则:
1. 参考之前版本的更新日志 (需要额外注意标点符号和语言表达方式), 将每一个分类的条目按照一定的顺序进行排列. 避免更新日志分散且无章可循. 多语言翻译时尽量保证技术术语的表达规范, 同时需要注意不要出现任何全角符号.
2. 编写 `dependency` 日志时, 需注意每种语言只使用之前版本出现的固定表达术语 (例如简体中文只出现 `附加`, `升级`, `移除`, `模块化`, `本地化` 这样的术语), 表达方式和格式也需要与之前的日志内容保持一致. 依赖只统计 Gradle 构建脚本中 implementation 等使用的依赖, 像字体等内容不应出现在更新日志中.
3. 如果本次 commit 与 AutoJs6 GitHub Issue 有关, 则一定要体现在更新日志中, 并注意日志编写格式.
4. 分类已经暗含了自身含义, 例如 "feature" 分类已经代表了 "新增", 因此日志中应避免再重复出现 "新增" 字样, "fix" 也如此, 但 "improvement" 可以有一定的灵活性.
5. json 文件编辑后, 运行 py 脚本更新 md 文件.

## version.properties 文件

VERSION_BUILD 构建版本号可能随着 Gradle 构建自增, VERSION_NAME 也可能会被开发者手动变更. 此文件如果自动变更后无需撤回修改, 直接与其他工作区文件一并提交即可.

## 文档内容

- 当前文档是两种风格的叠加. 1. 早期 Auto.js 教程式内容: 口语化/逐步讲解/示例和截图较多. 2. 后期 AutoJs6 API 参考 (由我本人编写): 类型/默认值/重载/版本和运行条件标注严格. 现在希望统一全部文档内容为后者, 包括早期内容及新添加内容.
- 当前文档历史内容可能并不完全统一: 同时存在 Auto.js/AutoJs6/var/let/MDN 类型链接/内部类型链接等两代写法; 扫描还发现不少页面保留 "此章节待补充或完善" 标记.
- 严格遵循 API 条目的明确格式约定 (位于 "文档阅读说明" 章节), 其中定义了参数类型/返回值/可选参数/默认值/可变参数/泛型/对象字面量等; 还使用了 Global/Overload/Async/A11Y/API Level/DEPRECATED 等标签.
- 不要出现任何全角符号, 包括但不限于文档正文内容以及示例代码的注释内容; 指代除外, 例如 `中文的逗号 "," 的 Unicode 是...`.
## Shared repository standard (2026-09-13)

Read [the complete repository standard](docs/development/repository-standard.md). It supplements the product-specific instructions above. Use the publicly released platform and native-alignment plugins, currently 1.8.3. Do not use consumer gradle/data overrides or sibling-repository build dependencies.

Inspect status, branch, recent commits and all diffs first. Do not overwrite or include another task's pending documentation, declaration or version changes in a commit. Generated documentation, provenance and public API synchronization require coordination with their owning task. Before each authorized commit set VERSION_BUILD to the current reachable HEAD count plus one, and verify it after committing.
