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
fileCount=164
totalBytes=8565450
contentSha256=521ea5d4e410167d468e7f6dce814017a8fc0f08f6744de7800135bb4c0d6b62
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=8117e0fb4dbb52d13f3b6b958e9f25fd4ce696a9
sourcePath=api
sourceGenerator=generator/auto-generate-for-autojs6.bat
discovery=org.autojs.plugin.INFO|org.autojs.plugin.OFFLINE_DOCS
category=offline-docs
```

OfflineDocsPluginInfoService publica PluginInfo mediante IPluginInfoProvider. El host acepta el paquete fijo solo después de comprobar habilitación, compatibilidad, firma, metadatos, inventario y coherencia del contenido de los archivos.

******

### Contenido

******

Los metadatos del contenido y el inventario se derivan automáticamente de los recursos de documentación actuales en `assets/docs/`. El host verifica que los metadatos, el inventario y el contenido de los archivos sean coherentes entre sí. La documentación sin conexión permite realizar búsquedas de texto completo en los títulos y el contenido de las páginas, y los resultados llevan directamente a las secciones coincidentes.

******

### Compilación y verificación

******

Compila ambas variantes, ejecuta las pruebas JVM y aplica verificaciones de APK para los metadatos de contenido generados dinámicamente, los metadatos del contrato, los enlaces rotos, un único APK universal, la ausencia de cargas `lib/*.so` y las licencias:

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

# v1.0.1

###### 2026/07/25

* `Mejora` Sustituyó la base fija de la huella del contenido por metadatos de contenido y un inventario generados automáticamente a partir de los recursos de documentación actuales, lo que permite actualizar directamente los recursos
* `Mejora` Generó y sincronizó la documentación sin conexión a partir de las fuentes Markdown oficiales de AutoJs6, manteniendo alineados los contenidos en línea y sin conexión
* `Mejora` Unificó la documentación integrada con el estilo de referencia de la API de AutoJs6 y normalizó el nombre actual del producto, las declaraciones de variables JavaScript, los enlaces de tipos locales, los avisos de secciones pendientes y la puntuación ASCII
* `Mejora` Mejoró la navegación de la documentación sin conexión con búsqueda de texto completo en títulos y contenido y saltos directos a las secciones coincidentes

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
.python/normalize_offline_docs.py
.python/generate_markdown.py
app/src/main/res/values-*/strings.xml
app/src/main/res/raw-*/plugin_instruction.md
app/src/main/assets/doc/CHANGELOG-*.md
```

`strings.xml` contiene descripciones localizadas del plugin; `plugin_instruction.md` contiene las instrucciones de uso que muestra el host. `.python/normalize_offline_docs.py` actúa como validador de solo lectura de la documentación sin conexión generada. README y CHANGELOG se generan desde fuentes JSON mediante `.python/generate_markdown.py`, y la salida CHANGELOG completa se escribe en `app/src/main/assets/doc/`.

******

### Enlaces

******

- [AutoJs6](https://docs.autojs6.com/)
- [AutoJs6 Documentation](https://docs.autojs6.com/)
