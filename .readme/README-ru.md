<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Плагин содержимого офлайн-документации 6.8.0 для AutoJs6</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Offline-Docs?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=A24232&label=Issues"/></a>
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

Плагин Offline Documentation для AutoJs6 предоставляет полный сайт документации 6.8.0 как отдельно устанавливаемый пакет содержимого.

******

### Контракт плагина

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
fileCount=199
totalBytes=11610292
contentSha256=e4f1c4ea100278e791878d9d63941cd4fd18c1b23fd43b8c53ae84e93d7ee4f9
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=f9ed7afe41f2cdf2603dc281323be33869ced6d7
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

# v6.8.5

###### 2026/09/29

* `Улучшение` Документация AI Agent 1.2.0: Выбранные инструменты локальных или внешних серверов MCP с отдельным уровнем риска; группа mcp изначально выключена
* `Улучшение` Документация подключения 3-Stove Agent по запросу: единый переключатель в центре плагинов, автоматическое первое включение с сохранением отключения, ожидание первой синхронной связи в рабочем потоке, асинхронные запросы, status только для чтения и отсутствие повтора задач

# v6.8.4

###### 2026/09/26

* `Улучшение` Документация группы script_dynamic в разрабатываемой AI Agent 1.1.0, отдельного подтверждения кода, закрытой истории и сохранения зарегистрированных скриптов через системный выбор файлов

# v6.8.3

###### 2026/09/25

* `Улучшение` Описаны требования Agent 1.0.0 к Android и хосту, каталог моделей 3-Stone AI и наблюдения через текст/OCR; версия содержимого документации 6.8.0 отделена от версии выпуска плагина
* `Улучшение` Синхронизация глобальных групп Agent, осторожного режима, бюджетов и лимитов протокола с ограничениями профилей и отдельных задач
* `Улучшение` Синхронизация памяти предпочтений Agent, отдельных подтверждений, запросов по области, импорта/экспорта JSON и различий между автоматическим добавлением и инструментами памяти
* `Улучшение` Синхронизация именованных предустановок Agent, выбора по умолчанию и модели, объединения контекста и ограничений инструментов, бюджета, подтверждений, каталогов скриптов и памяти
* `Улучшение` Синхронизация API ai.agent, жизненного цикла AgentRun, ответов и подтверждений, бюджетов, результатов скриптов, трех примеров и индекса автономного поиска
* `Улучшение` Синхронизирован справочник EPUB и офлайн-индекс поиска: глобальный объект epub плагина Readium EPUB Reader, члены EpubBook для метаданных, оглавления, порядка чтения, извлечения текста, экспорта обложки и ресурсов и полнотекстового поиска, события, методы управления и настройки чтения EpubReaderSession, объект позиции EpubLocator и коды ошибок EpubError
* `Улучшение` Синхронизирован справочник EPUB и офлайн-индекс поиска с выделениями и заметками плагина Readium EPUB Reader 1.1.0 (версия 2 контракта EPUB): EpubBook#annotations и удобный epub.annotations, событие highlight у EpubReaderSession и носители EpubLocator

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


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/docs/16kb.md)
