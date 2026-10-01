<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>إضافة محتوى التوثيق دون اتصال 6.8.0 لتطبيق AutoJs6</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Offline-Docs?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=A24232&label=Issues"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/LICENSE"><img alt="GitHub License" src="https://img.shields.io/github/license/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=534BAE&label=License"/></a>
  </p>
</div>

******

### اللغات (Languages)

******

يدعم README.md الحالي اللغات التالية:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ru.md)
- العربية [ar] # الحالي

******

### مقدمة

******

توفر إضافة Offline Documentation لتطبيق AutoJs6 موقع التوثيق الكامل 6.8.0 كحزمة محتوى قابلة للتثبيت بشكل مستقل.

******

### عقد الإضافة

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

تنشر OfflineDocsPluginInfoService معلومات PluginInfo عبر IPluginInfoProvider. لا يقبل المضيف الحزمة الثابتة إلا بعد فحوص التمكين والتوافق والتوقيع والبيانات الوصفية واتساق قائمة الجرد ومحتوى الملفات.

******

### المحتوى

******

تشتق البيانات الوصفية للمحتوى وقائمة الجرد تلقائيا من أصول التوثيق الحالية ضمن `assets/docs/`. يتحقق المضيف من اتساق البيانات الوصفية وقائمة الجرد ومحتويات الملفات. يدعم التوثيق دون اتصال البحث في النص الكامل للعناوين ومحتوى الصفحات, وتنتقل النتائج مباشرة إلى الأقسام المطابقة.

******

### البناء والتحقق

******

يبني كلا النوعين ويشغل اختبارات JVM ويفرض بوابات APK للبيانات الوصفية للمحتوى المنشأة ديناميكيا والبيانات الوصفية للعقد والروابط المعطلة وحزمة APK universal واحدة وغياب حمولات `lib/*.so` والتراخيص:

```powershell
.\gradlew.bat :app:testDebugUnitTest :app:verifyOfflineDocsApks
```

يتطلب التحقق من حزمة Release APK القابلة للنشر أيضا ملف `sign.properties` المستبعد من Git:

```powershell
.\gradlew.bat :app:verifyOfflineDocsPublishableApks
```

******

### سلوك وقت التشغيل

******

لا تحتوي الإضافة على واجهة مستقلة. يكتشفها AutoJs6 ويتحقق منها عند الحاجة, ثم يقدم التوثيق مباشرة من AssetManager الخاص بالإضافة عبر محمل أصول WebView الخاص به. يكتشف المضيف استبدال الإضافة أو تعطيلها.

******

### سجل الإصدارات

******

# v6.8.5

###### 2026/10/02

* `تحسين` توثيق AI Agent 1.2.0: أدوات MCP المختارة من خوادم محلية أو خارجية مع مستوى خطر لكل خادم ومجموعة mcp معطلة افتراضيا
* `تحسين` مزامنة توثيق اتصال 3-Stove Agent عند الحاجة: مركز المكونات كمفتاح التفعيل الوحيد والتفعيل الأول التلقائي مع حفظ التعطيل وانتظار الاتصال المتزامن الأول في خيط العمل والاستعلامات غير المتزامنة و status للقراءة فقط وعدم إعادة المهام
* `تحسين` واجهة البرامج النصية installer / $installer, التثبيت المتزامن وغير المتزامن, أحداث الجلسة وفحص المصادر والإزالة وطرق التفويض, مع التفاعل الافتراضي وسلوك الإلغاء
* `تحسين` installer P8: تفويض Dhizuku وتثبيت notification وأوضاع preferred/persistent الافتراضية وحدود إمكانات الملحق

# v6.8.4

###### 2026/09/26

* `تحسين` توثيق مجموعة script_dynamic في إصدار التطوير AI Agent 1.1.0, وتأكيد كل مصدر على حدة, وسجل المصدر الخاص وحفظ البرامج المسجلة عبر منتقي ملفات النظام

# v6.8.3

###### 2026/09/25

* `تحسين` توثيق متطلبات Android والمضيف في Agent 1.0.0 ودليل نماذج 3-Stone AI وملاحظات النص و OCR, مع إبقاء محتوى التوثيق عند 6.8.0 وإصدار مستقل للإضافة
* `تحسين` مزامنة مجموعات Agent العامة والوضع الحذر والميزانيات وحدود البروتوكول وقواعد تضييق الإعدادات المسبقة والمهام
* `تحسين` مزامنة ذاكرة تفضيلات Agent والتأكيد الفردي والاستعلامات حسب النطاق واستيراد وتصدير JSON والفرق بين الإضافة التلقائية وأدوات الذاكرة
* `تحسين` مزامنة إعدادات Agent المسبقة المسماة والاختيار الافتراضي واختيار النموذج ودمج السياق الثابت وحدود الأدوات والميزانيات والتأكيدات ومجلدات السكربت ونطاق الذاكرة
* `تحسين` مزامنة واجهة ai.agent ودورة حياة AgentRun والإجابات والتأكيدات والميزانيات ونتائج السكربتات وثلاثة أمثلة وفهرس البحث دون اتصال
* `تحسين` مزامنة مرجع الكتب الإلكترونية (EPUB) وفهرس البحث دون اتصال, بما يشمل الكائن العام epub لإضافة Readium EPUB Reader, وأعضاء EpubBook للبيانات الوصفية وجدول المحتويات وترتيب القراءة واستخراج النص وتصدير الغلاف والموارد والبحث في النص الكامل, وأحداث EpubReaderSession وأساليب التحكم وتفضيلات القراءة, وكائن الموضع EpubLocator ورموز أخطاء EpubError
* `تحسين` مزامنة مرجع الكتب الإلكترونية (EPUB) وفهرس البحث دون اتصال مع تمييزات وملاحظات إضافة Readium EPUB Reader 1.1.0 (الإصدار 2 من عقد EPUB): EpubBook#annotations وطبقة التيسير epub.annotations, وحدث highlight في EpubReaderSession, ومواضع حمل EpubLocator

##### لمزيد من سجل الإصدارات

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/assets/doc/CHANGELOG-ar.md)

******

### الترخيص

******

يوزع التوثيق القادم من AutoJs6-Documentation وفق Apache-2.0. يوزع قالب توثيق Node.js وأنماطه والمحتوى المشتق منه وفق MIT, وكذلك medium-zoom و docsify-copy-code و dnt-helper. يوزع SHJS وفق GPL-3.0. يوزع Lato وفق OFL-1.1.

تحتوي كل حزمة APK على ملخص الإسناد والنصوص الكاملة لتراخيص Apache-2.0 و GPL-3.0 و MIT و OFL-1.1 ضمن `assets/licenses/docs/`.

******

### بنية الموارد

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

يحتوي `strings.xml` على أوصاف الإضافة المترجمة; ويحتوي `plugin_instruction.md` على تعليمات الاستخدام التي يعرضها المضيف. تعمل `.python/normalize_offline_docs.py` كمدقق للقراءة فقط للتوثيق دون اتصال الذي تم إنشاؤه. يتم إنشاء README و CHANGELOG من مصادر JSON بواسطة `.python/generate_markdown.py`, وتكتب مخرجات CHANGELOG الكاملة في `app/src/main/assets/doc/`.

******

### الروابط

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/docs/16kb.md)
