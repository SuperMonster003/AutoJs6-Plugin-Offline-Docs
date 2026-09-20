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

###### 2026/09/19

* `Исправление` Валидаторы офлайн-документации больше не принимают публичное имя метода Node bridge `callAutoJs` за устаревшее неполное имя продукта
* `Исправление` Предупреждения чтения SDK XML v4 с AGP 9.1 и ошибочный запуск проверки выравнивания нативных библиотек APK при сборке модульных тестов JVM, устраненные общими плагинами сборки 1.8.3
* `Улучшение` Синхронизация API нажатия по координатам, maxAttempts по умолчанию 0 для неограниченных попыток, стеков ошибок Flow, вывода консоли и индекса автономного поиска
* `Улучшение` Синхронизация необязательных шагов Flow, ограниченных циклов, поиска и нажатия кандидатов в цепочке, стабильных снимков коллекций и значений по умолчанию, обновление индекса офлайн-поиска
* `Улучшение` Синхронизация справочника разрешений локальной сети и автономного индекса поиска с условиями Android 17 / targetSdk 37, асинхронной авторизацией, повторными попытками и границами разрешений Socket / MQTT и плагинов
* `Улучшение` Синхронизация справки `device.pageSize` и индекса автономного поиска с описанием единиц в байтах, доступа только для чтения и различий между средой выполнения и совместимостью нативных библиотек
* `Улучшение` Синхронизированы справка OCR и индекс автономного поиска: автоматический выбор движка, чтение текущего режима, сброс через tap, параметры отдельного вызова и поведение при отсутствии доступных плагинов
* `Улучшение` Синхронизированы справочник MediaInfo и автономный поисковый индекс: граница между прежним `read` и версионированным `snapshot`, согласование схем v1/v2 плагина, облегчённый `capabilities`, а также динамические данные треков v2 и движка
* `Улучшение` Синхронизированы справочник Pinyin и индекс офлайн-поиска: добавлены переопределения чтений `customDictionary` на один вызов, завершенные `compare`/`compact` и доступ из Node.js через `autojs6:bridge.callAutoJs` с явной capability `pinyin`
* `Улучшение` Синхронизированы справочник Image Quantization v4 и индекс автономного поиска: добавлены настраиваемые бюджеты пикселей и рабочей памяти, типизированная диагностика лимитов ресурсов, метрики учтенного пика памяти и отмена по явному запросу или при завершении скрипта
* `Улучшение` Версия versionName плагина согласована с целевой версией документации AutoJs6, а build/versionCode каждого из двух проектов автоматически увеличивается на 1 после успешной синхронизации документации
* `Улучшение` Обновлена встроенная документация AutoJs6 6.8.0 и индекс офлайн-поиска: добавлены Preview API обнаружения объектов YOLO, настройка точного провайдера, профиль модели, типы результатов и стабильные коды ошибок
* `Улучшение` Дополнен встроенный справочник по ИИ: обнаружение моделей плагина, выбор официального или точного компонента, история сообщений с несколькими ролями, параметры генерации, точные данные об использовании и потоковой передаче, а также полные примеры маршрутизации
* `Улучшение` Расширены встроенный справочник по ИИ и индекс офлайн-поиска: постоянный Conversation API `ai.session`, фиксированные параметры сессии, правила жизненного цикла с одной новой подсказкой на ход, обнаружение возможностей и явное освобождение ресурсов
* `Улучшение` Расширены встроенный справочник по ИИ и индекс офлайн-поиска: нативный вывод с ограничениями JSON Schema через `structuredJson`/`responseSchema`, фиксированная schema постоянной сессии, возврат текста JSON и правила ошибок
* `Улучшение` Расширены встроенный справочник по ИИ и индекс офлайн-поиска: явные backend profile CPU/GPU/NPU, доступность устройства и стабильные причины в `ai.catalog`, фиксированный backend постоянной сессии, ограничения совместимости GPU и контракт без отката
* `Улучшение` Все неопубликованные API списка и проверки конфигурации ИИ заменены единым каталогом целей `ai.catalog`, точной маршрутизацией через `target`, полными метаданными ответов и сеансов, стабильными ошибками без отката и синхронизированными сетевыми/офлайн-ресурсами
* `Улучшение` Встроенная справка runtime и офлайн-индекс поиска дополнены шестью перегрузками `loadJarWithR8` для проверенного экспорта mapping/seeds/usage/retrace metadata и API `retraceR8Stack` протокола 1.1, включая привязку происхождения и закрытый отказ без fallback
* `Улучшение` Унифицировать оформление README и управление версиями платформы Gradle
* `Улучшение` Справочник MediaInfo и автономный поиск охватывают streamNumber, countGet, infoKind и исходные пути файлов
* `Улучшение` Проверка сборки отклоняет непреднамеренные нативные зависимости и создает отчет JSON
* `Улучшение` Синхронизирован справочник Mail и офлайн-индекс поиска: глобальный объект mail плагина Angus Mail, методы MailClient для отправки, поиска, вложений, флагов, папок и наблюдения, MailMessage, MailAccountOptions с предустановками провайдеров, MailSearchQuery и коды ошибок MailError

# v6.8.2

###### 2026/09/15

* `Улучшение` Подняты compileSdk и targetSdk до 37 (Android 17); поведение плагина не зависит от нового целевого уровня

# v6.8.1

###### 2026/09/14

* `Улучшение` Синхронизация руководства по хранилищу упакованных приложений: requiresSharedStorage, отказ, возврат из настроек и восстановление значка запуска
* `Улучшение` Синхронизация справки Media и поискового индекса для музыкальных служб Media3, владения воспроизведением, подготовки в рабочем потоке, управления и разрешений упакованных приложений
* `Улучшение` Синхронизация справочника Pangu и поискового индекса, включая встроенный pangu.js 10.1.0, глобальный доступ, расстановку пробелов и проверку
* `Улучшение` Синхронизация документации HTTP об области действия isInsecure / insecure, общих настройках клиента, доверии сертификатам, CT, ECH и разрешениях локальной сети
* `Улучшение` Синхронизация справки Media, Device, TTS и Settings с условиями фонового аудио Android 17, подавлением без ошибки, восстановлением из видимого приложения и границами процесса движка TTS
* `Улучшение` Проверка полной настройки подписи, ожидаемого набора APK и воспроизводимости документации

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
