<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Плагин содержимого офлайн-документации 6.6.4 для AutoJs6</p>

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

### Языки (Languages)

******

Текущий README.md поддерживает следующие языки:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-fr.md)
- [Español [es]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-es.md)
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ko.md)
- Русский [ru] # текущий
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ar.md)

******

### Введение

******

Плагин Offline Documentation для AutoJs6 предоставляет полный сайт документации 6.6.4 как отдельно устанавливаемый пакет содержимого.

******

### Контракт плагина

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
fileCount=181
totalBytes=10032472
contentSha256=88502a147c30a2f5e53e2d1aee779c420b9af11a8de3d9400b1324f5699561c9
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=fc3a420e04dd27a4015cf331179685dea89c503c
sourcePath=api
sourceGenerator=generator/auto-generate-for-autojs6.bat
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

OfflineDocsPluginInfoService публикует PluginInfo через IPluginInfoProvider. Хост принимает фиксированный пакет только после проверок включения, совместимости, подписи, метаданных, реестра и согласованности содержимого файлов.

******

### Содержимое

******

Метаданные содержимого и реестр автоматически формируются на основе текущих ресурсов документации в `assets/docs/`. Хост проверяет взаимную согласованность метаданных, реестра и содержимого файлов. Офлайн-документация поддерживает полнотекстовый поиск по заголовкам и содержимому страниц с прямым переходом из результатов к найденным разделам.

******

### Сборка и проверка

******

Собирает оба варианта, запускает тесты JVM и применяет проверки APK для динамически формируемых метаданных содержимого, метаданных контракта, битых ссылок, единственного universal APK, отсутствия `lib/*.so` и лицензий:

```powershell
.\gradlew.bat :app:testDebugUnitTest :app:verifyOfflineDocsApks
```

Для проверки публикуемого Release APK также требуется исключенный из Git файл `sign.properties`:

```powershell
.\gradlew.bat :app:verifyOfflineDocsPublishableApks
```

******

### Поведение среды

******

У плагина нет отдельного интерфейса. AutoJs6 обнаруживает и проверяет его по запросу, а затем отдает документацию непосредственно из AssetManager плагина через собственный загрузчик ресурсов WebView. Хост обнаруживает замену или отключение плагина.

******

### История выпусков

******

# v6.8.0

###### 2026/08/21

* `Улучшение` Версия versionName плагина согласована с целевой версией документации AutoJs6, а build/versionCode каждого из двух проектов автоматически увеличивается на 1 после успешной синхронизации документации
* `Улучшение` Обновлена встроенная документация AutoJs6 6.8.0 и индекс офлайн-поиска: добавлены Preview API обнаружения объектов YOLO, настройка точного провайдера, профиль модели, типы результатов и стабильные коды ошибок
* `Улучшение` Дополнен встроенный справочник по ИИ: обнаружение моделей плагина, выбор официального или точного компонента, история сообщений с несколькими ролями, параметры генерации, точные данные об использовании и потоковой передаче, а также полные примеры маршрутизации
* `Улучшение` Расширены встроенный справочник по ИИ и индекс офлайн-поиска: постоянный Conversation API `ai.session`, фиксированные параметры сессии, правила жизненного цикла с одной новой подсказкой на ход, обнаружение возможностей и явное освобождение ресурсов
* `Улучшение` Расширены встроенный справочник по ИИ и индекс офлайн-поиска: нативный вывод с ограничениями JSON Schema через `structuredJson`/`responseSchema`, фиксированная schema постоянной сессии, возврат текста JSON и правила ошибок

# v1.0.1

###### 2026/07/25

* `Улучшение` Фиксированная база отпечатка содержимого заменена метаданными содержимого и реестром, автоматически формируемыми из текущих ресурсов документации, что позволяет напрямую обновлять эти ресурсы
* `Улучшение` Офлайн-документация переведена на генерацию и синхронизацию из официальных исходных файлов Markdown AutoJs6, что обеспечивает единое содержимое онлайн- и офлайн-версий
* `Улучшение` Встроенная документация приведена к стилю справочника API AutoJs6, а также стандартизированы текущее название продукта, объявления переменных JavaScript, локальные ссылки на типы, уведомления о незавершенных разделах и пунктуация ASCII
* `Улучшение` Навигация по офлайн-документации улучшена полнотекстовым поиском по заголовкам и содержимому с прямым переходом к найденным разделам

# v1.0.0

###### 2026/07/23

* `Функция` Выпущен автономный плагин офлайн-документации AutoJs6 6.6.4 с обнаружением по контракту версии 1 и единственным universal APK
* `Функция` Добавлен 161 файл документации, локализованные метаданные и полные уведомления Apache-2.0, GPL-3.0, MIT и OFL-1.1
* `Улучшение` Добавлены проверки JVM и APK для канонического отпечатка, метаданных контракта, базы известных битых ссылок, единственного universal APK, отсутствия `lib/*.so` и лицензий
* `Улучшение` Записаны точные коммит и путь источника AutoJs6 для побайтово скопированного содержимого документации

##### Больше истории выпусков

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/assets/doc/CHANGELOG-ru.md)

******

### Лицензия

******

Документация из AutoJs6-Documentation распространяется по Apache-2.0. Шаблон, стили и производное содержимое документации Node.js распространяются по MIT, как и medium-zoom, docsify-copy-code и dnt-helper. SHJS распространяется по GPL-3.0. Lato распространяется по OFL-1.1.

Каждый APK содержит сводку атрибуции и полные тексты Apache-2.0, GPL-3.0, MIT и OFL-1.1 в `assets/licenses/docs/`.

******

### Структура ресурсов

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

`strings.xml` содержит локализованные описания плагина; `plugin_instruction.md` содержит инструкции, отображаемые хостом. `.python/normalize_offline_docs.py` проверяет сгенерированную офлайн-документацию, не изменяя ее. README и CHANGELOG генерируются из JSON-источников с помощью `.python/generate_markdown.py`, а полный CHANGELOG записывается в `app/src/main/assets/doc/`.

******

### Ссылки

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)
