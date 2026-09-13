<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>إضافة محتوى التوثيق دون اتصال 6.6.4 لتطبيق AutoJs6</p>

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

توفر إضافة Offline Documentation لتطبيق AutoJs6 موقع التوثيق الكامل 6.6.4 كحزمة محتوى قابلة للتثبيت بشكل مستقل.

******

### عقد الإضافة

******

```text
applicationId=io.github.supermonster003.autojs6.plugin.offlinedocs
pluginId=offline-docs
engine=offline-docs
variant=6.6.4
contractVersion=1
requiredHostVersionCode=5240
contentVersion=6.8.0
contentFormat=autojs6-static-html-v1
assetRoot=docs
entryPoint=index.html
inventoryFile=offline-docs-inventory-v1.txt
fileCount=184
totalBytes=10557951
contentSha256=c3194e204e92172fa808c5243e564de54d1a7f9bc0dbddb70ab5eee5ecc6f9c9
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=e6bded6c8d0dbeb688c26eec2b5a241a4664ecc4
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

# v6.8.0

###### 2026/09/13

* `إصلاح` لم تعد أدوات التحقق من الوثائق غير المتصلة تعتبر اسم طريقة جسر Node العامة `callAutoJs` اسما قديما مجردا للمنتج
* `تحسين` مزامنة مرجع أذونات الشبكة المحلية وفهرس البحث دون اتصال, مع شروط Android 17 / targetSdk 37 ومنح الإذن غير المتزامن وإعادة المحاولة وحدود أذونات Socket / MQTT الأصلية والإضافات
* `تحسين` مزامنة مرجع `device.pageSize` وفهرس البحث دون اتصال مع توضيح وحدة البايت والقراءة فقط والفرق بين بيئة التشغيل وتوافق المكتبات الأصلية
* `تحسين` مزامنة مرجع OCR وفهرس البحث دون اتصال مع اختيار المحرك تلقائيا وقراءة الوضع مباشرة وإعادة الضبط عبر tap وخيارات كل استدعاء والسلوك عند عدم توفر إضافات
* `تحسين` تمت مزامنة مرجع MediaInfo وفهرس البحث دون اتصال مع الحد الفاصل بين `read` القديم و`snapshot` ذي الإصدار, والتفاوض على مخططي v1/v2 للملحق, و`capabilities` الخفيف, وبيانات tracks v2 والمحرك الديناميكية
* `تحسين` تمت مزامنة مرجع Pinyin وفهرس البحث غير المتصل مع تجاوزات القراءة `customDictionary` لكل استدعاء, وإكمال `compare`/`compact`, وإتاحة الوصول من Node.js عبر `autojs6:bridge.callAutoJs` باستخدام capability صريحة باسم `pinyin`
* `تحسين` مزامنة مرجع Image Quantization v4 وفهرس البحث دون اتصال مع ميزانيات قابلة للضبط لعدد البكسلات وذاكرة العمل, وتشخيصات نوعية لتجاوز الموارد, ومقاييس لذروة الذاكرة المحتسبة, والإلغاء عند الطلب الصريح أو إيقاف البرنامج النصي
* `تحسين` مواءمة versionName للإضافة مع إصدار توثيق AutoJs6 المستهدف, وزيادة build/versionCode تلقائيا بمقدار 1 في كلا المشروعين عند نجاح مزامنة التوثيق
* `تحسين` تم تحديث وثائق AutoJs6 6.8.0 المضمنة وفهرس البحث دون اتصال لإضافة واجهة YOLO Preview لاكتشاف الأهداف, وإعداد المزود الدقيق, وملف تعريف النموذج, وأنواع النتائج, ورموز الأخطاء الثابتة
* `تحسين` استكمال مرجع الذكاء الاصطناعي المضمن باكتشاف نماذج الإضافات, ومحددات الإضافة الرسمية والمكونات الدقيقة, وسجل الرسائل متعدد الأدوار, وعناصر تحكم التوليد, وبيانات الاستخدام والبث الدقيقة, وأمثلة التوجيه الكاملة
* `تحسين` توسيع مرجع الذكاء الاصطناعي المضمن وفهرس البحث دون اتصال بإضافة واجهة Conversation الدائمة `ai.session`, وعناصر تحكم جلسة ثابتة, وقواعد دورة حياة بمطالبة جديدة واحدة لكل دورة, واكتشاف القدرات, ودلالات تحرير الموارد الصريح
* `تحسين` توسيع مرجع الذكاء الاصطناعي المضمن وفهرس البحث دون اتصال بإخراج مقيد أصليا عبر JSON Schema باستخدام `structuredJson` و`responseSchema`, وschema ثابت للجلسات الدائمة, وإرجاع نص JSON, وقواعد الفشل
* `تحسين` توسيع مرجع الذكاء الاصطناعي المضمن وفهرس البحث دون اتصال بملفات backend profile صريحة لـ CPU/GPU/NPU, وتوافر الجهاز والأسباب الثابتة في `ai.catalog`, وbackend ثابت للجلسات الدائمة, وحدود توافق GPU, وعقد منع الرجوع
* `تحسين` استبدال جميع واجهات قائمة الذكاء الاصطناعي وفحص الضبط غير المنشورة مباشرة بدليل الاهداف الموحد `ai.catalog` والتوجيه الدقيق عبر `target` وبيانات الاستجابة والجلسة الكاملة والاخطاء الثابتة دون رجوع, مع مزامنة الاصول المتصلة وغير المتصلة
* `تحسين` توسيع مرجع runtime المضمن وفهرس البحث دون اتصال بستة تحميلات لـ `loadJarWithR8` لتصدير mapping/seeds/usage/retrace metadata بعد التحقق وواجهة `retraceR8Stack` للبروتوكول 1.1, مع ربط المصدر والفشل المغلق دون fallback
* `تحسين` توحيد تخطيط README وطريقة إدارة إصدارات منصة Gradle
* `تحسين` تحديث مرجع MediaInfo والبحث دون اتصال لخيارات streamNumber وcountGet وinfoKind ومسارات الملفات الأصلية
* `تحسين` التحقق أثناء البناء لمنع إدخال تبعيات أصلية غير مقصودة, مع تقرير JSON

# v1.0.1

###### 2026/07/25

* `تحسين` استبدال خط أساس بصمة المحتوى الثابت ببيانات وصفية للمحتوى وقائمة جرد يتم إنشاؤهما تلقائيا من أصول التوثيق الحالية, ما يتيح تحديث الأصول مباشرة
* `تحسين` إنشاء التوثيق دون اتصال ومزامنته من مصادر Markdown الرسمية لـ AutoJs6, بما يحافظ على اتساق المحتوى بين النسختين عبر الإنترنت ودون اتصال
* `تحسين` مواءمة التوثيق المضمن مع نمط مرجع AutoJs6 API وتوحيد اسم المنتج الحالي وتعريفات متغيرات JavaScript وروابط الأنواع المحلية وتنبيهات الأقسام غير المكتملة وعلامات ترقيم ASCII
* `تحسين` تحسين تصفح التوثيق دون اتصال من خلال البحث في النص الكامل للعناوين والمحتوى والانتقال مباشرة إلى الأقسام المطابقة

# v1.0.0

###### 2026/07/23

* `ميزة` إصدار إضافة محتوى التوثيق دون اتصال AutoJs6 6.6.4 المستقلة مع اكتشاف العقد الإصدار 1 وحزمة APK universal واحدة
* `ميزة` تضمين 161 ملف توثيق وبيانات وصفية محلية وإشعارات Apache-2.0 و GPL-3.0 و MIT و OFL-1.1 الكاملة
* `تحسين` إضافة بوابات JVM و APK للتحقق من بصمة المحتوى القياسية وبيانات العقد وخط أساس الروابط المعطلة المعروفة وحزمة universal الواحدة وغياب `lib/*.so` ومواد الترخيص
* `تحسين` تسجيل التزام المصدر ومساره بدقة في AutoJs6 لمحتوى التوثيق المنسوخ بايتا مقابل بايت

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
