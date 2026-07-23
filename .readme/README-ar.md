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
    <br>
    <a href="https://developer.android.com/studio/archive"><img alt="Android Studio" src="https://img.shields.io/badge/Android%20Studio-2023.3+-B64FC8"/></a>
    <a href="https://www.jetbrains.com/idea/download/other.html"><img alt="IntelliJ IDEA" src="https://img.shields.io/badge/IntelliJ%20IDEA-2023.3+-EE4677"/></a>
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
contentVersion=6.6.4
contentFormat=autojs6-static-html-v1
assetRoot=docs
entryPoint=index.html
inventoryFile=offline-docs-inventory-v1.txt
fileCount=161
totalBytes=6973820
contentSha256=572023f28fb24499b34c021b8e8ec83451c4346eb5f48c00cb677905ab5aefda
sourceRepository=SuperMonster003/AutoJs6
sourceCommit=37190cd9681b9d4bdc8e786f146b1b88f7818dc2
sourcePath=app/src/main/assets-app/docs
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

تنشر OfflineDocsPluginInfoService معلومات PluginInfo عبر IPluginInfoProvider. لا يقبل المضيف الحزمة الثابتة إلا بعد فحوص التمكين والتوافق والتوقيع والبيانات الوصفية واتساق قائمة الجرد ومحتوى الملفات.

******

### المحتوى

******

تشتق البيانات الوصفية للمحتوى وقائمة الجرد تلقائيا من أصول التوثيق الحالية ضمن `assets/docs/`. يتحقق المضيف من اتساق البيانات الوصفية وقائمة الجرد ومحتويات الملفات.

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

# v1.0.1

###### 2026/07/24

* `تحسين` استبدال خط أساس بصمة المحتوى الثابت ببيانات وصفية للمحتوى وقائمة جرد يتم إنشاؤهما تلقائيا من أصول التوثيق الحالية, ما يتيح تحديث الأصول مباشرة
* `تحسين` مواءمة التوثيق المضمن مع نمط مرجع AutoJs6 API وتوحيد اسم المنتج الحالي وتعريفات متغيرات JavaScript وروابط الأنواع المحلية وتنبيهات الأقسام غير المكتملة وعلامات ترقيم ASCII

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

يحتوي `strings.xml` على أوصاف الإضافة المترجمة; ويحتوي `plugin_instruction.md` على تعليمات الاستخدام التي يعرضها المضيف. يتم إنشاء README و CHANGELOG من مصادر JSON بواسطة `.python/generate_markdown.py`, وتكتب مخرجات CHANGELOG الكاملة في `app/src/main/assets/doc/`.

******

### الروابط

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)
