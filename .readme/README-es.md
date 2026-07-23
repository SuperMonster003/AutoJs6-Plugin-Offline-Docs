<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Plugin de contenido de documentación sin conexión 6.6.4 para AutoJs6</p>

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

### Idiomas (Languages)

******

El README.md actual admite los siguientes idiomas:

- [简体中文 [zh-Hans]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hans.md)
- [繁體中文 (香港) [zh-Hant-HK]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-HK.md)
- [繁體中文 (台灣) [zh-Hant-TW]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-zh-Hant-TW.md)
- [English [en]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-en.md)
- [Français [fr]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-fr.md)
- Español [es] # actual
- [日本語 [ja]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ja.md)
- [한국어 [ko]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ko.md)
- [Русский [ru]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ru.md)
- [العربية [ar]](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/.readme/README-ar.md)

******

### Introducción

******

El plugin Offline Documentation de AutoJs6 proporciona el sitio completo de documentación 6.6.4 como paquete de contenido instalable por separado.

******

### Contrato del plugin

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
totalBytes=6996000
contentSha256=3cb93aa2a8228a5566c6fec278f0e625886694f6fc9b57f8a36224d8f030ecf8
sourceRepository=SuperMonster003/AutoJs6
sourceCommit=37190cd9681b9d4bdc8e786f146b1b88f7818dc2
sourcePath=app/src/main/assets-app/docs
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

OfflineDocsPluginInfoService publica PluginInfo mediante IPluginInfoProvider. El host acepta el paquete fijo solo después de comprobar habilitación, compatibilidad, firma, metadatos y huella del contenido.

******

### Contenido

******

El APK universal contiene 161 archivos en `assets/docs/`, con un total de 6996000 bytes. Su huella de árbol SHA-256 canónica forma parte del contrato versión 1.

******

### Compilación y verificación

******

Compila ambas variantes, ejecuta las pruebas JVM y aplica verificaciones de APK único, huella, metadatos, enlaces rotos conocidos, ausencia de cargas `lib/*.so` y licencias:

```powershell
.\gradlew.bat :app:testDebugUnitTest :app:verifyOfflineDocsApks
```

La verificación de una versión publicable también requiere el archivo `sign.properties`, ignorado por Git:

```powershell
.\gradlew.bat :app:verifyOfflineDocsPublishableApks
```

******

### Comportamiento en ejecución

******

El plugin no tiene interfaz independiente. AutoJs6 lo descubre y valida cuando es necesario, y sirve la documentación directamente desde el AssetManager del plugin mediante su cargador privado de recursos WebView. El host detecta si el plugin se sustituye o deshabilita.

******

### Historial de versiones

******

# v1.0.0

###### 2026/07/23

* `Función` Publicó el plugin independiente de documentación sin conexión AutoJs6 6.6.4 con descubrimiento por contrato versión 1 y un único APK universal
* `Función` Incluyó 161 archivos de documentación, metadatos localizados y avisos completos Apache-2.0, GPL-3.0, MIT y OFL-1.1
* `Mejora` Añadió verificaciones JVM y APK para la huella canónica, metadatos del contrato, base de enlaces rotos conocidos, único APK universal, ausencia de cargas `lib/*.so` y licencias
* `Mejora` Registró el commit y la ruta fuente exactos de AutoJs6 para el contenido de documentación copiado byte por byte

##### Para ver más historial de versiones

* [CHANGELOG.md](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/assets/doc/CHANGELOG-es.md)

******

### Licencia

******

La documentación procedente de AutoJs6-Documentation está bajo Apache-2.0. La plantilla, los estilos y el contenido derivado de la documentación de Node.js están bajo MIT, al igual que medium-zoom, docsify-copy-code y dnt-helper. SHJS está bajo GPL-3.0. Lato está bajo OFL-1.1.

Cada APK contiene un resumen de atribuciones y los textos completos Apache-2.0, GPL-3.0, MIT y OFL-1.1 en `assets/licenses/docs/`.

******

### Estructura de recursos

******

```text
.readme/lang_*.json
.changelog/lang_*.json
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
app/src/main/assets/doc/CHANGELOG-*.md
```

`strings.xml` contiene descripciones localizadas del plugin; `plugin_instruction.md` contiene las instrucciones de uso que muestra el host. README y CHANGELOG se generan desde fuentes JSON mediante `.python/generate_markdown.py`, y la salida CHANGELOG completa se escribe en `app/src/main/assets/doc/`.

******

### Enlaces

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)
