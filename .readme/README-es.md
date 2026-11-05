<!--suppress HtmlDeprecatedAttribute, HttpUrlsUsage -->

<div align="center">
  <p>
    <picture>
      <img src="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/app/src/main/res/mipmap/ic_launcher.png?raw=true" alt="autojs6-plugin-offline-docs-ic-launcher" border="0" width="128" />
    </picture>
  </p>

  <p>Plugin de contenido de documentación sin conexión 6.8.0 para AutoJs6</p>

  <p>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/releases"><img alt="GitHub release (latest by date)" src="https://img.shields.io/github/v/release/SuperMonster003/AutoJs6-Plugin-Offline-Docs?label=Release"/></a>
    <a href="https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/issues"><img alt="GitHub closed issues" src="https://img.shields.io/github/issues/SuperMonster003/AutoJs6-Plugin-Offline-Docs?color=A24232&label=Issues"/></a>
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

El plugin Offline Documentation de AutoJs6 proporciona el sitio completo de documentación 6.8.0 como paquete de contenido instalable por separado.

******

### Contrato del plugin

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
fileCount=246
totalBytes=18108641
contentSha256=555fcaba689fc58ce7e48e8c2bc8f04a4f7647074fa33b7332e004e7e6c73ddc
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=78f6c85920961cc7018916ce230b499c0188d010
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

# v6.8.41

###### 2026/11/04

* `Mejora` La documentación incluida incorpora la página async/await y sus enlaces de navegación, y sincroniza las descripciones de las API relacionadas

# v6.8.40

###### 2026/11/02

* `Función` Documentación de API: Control de tareas ai.agent, eventos y contexto/resultados de scripts registrados para Node.js, Bun y Workers, con autorización explícita para las aplicaciones empaquetadas
* `Corrección` Los validadores de documentación sin conexión ya no confunden el nombre de la interfaz de entrada `AutoJsJvmEntry` de los plugins Java y Kotlin Runtime con un nombre de producto heredado sin calificar
* `Mejora` Referencia del Diseñador de 3-Block Compose: desde 1.9.0, tres secciones nuevas: "Novedades de la vista previa interactiva" (diálogos, la tecla Atrás, pausa y reanudación, colores de la barra de estado y de navegación, límite de ocupación del hilo principal), "Proyectos UI en TSX" (edición de diseños JSX en scripts .tsx, cómo se escriben los esqueletos de eventos, ejecución de TSX en la vista previa interactiva) y "Edición vinculada de contenedores <compose>" (edición directa en el lienzo de las interfaces Compose acopladas con compose.attach, creación de un contenedor en un paso); la tabla "Diferencias de vista previa" tiene ahora columnas separadas para las versiones de AutoJs6 con y sin el contrato de vista previa v4

# v6.8.39

###### 2026/10/22

* `Función` Generación de texto con IA, transmisión, catálogo de modelos y sesiones persistentes para Node.js, Bun y Workers, con cancelación y consentimiento por aplicación en 3-Stone AI

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


[16 KB page alignment and build verification](https://github.com/SuperMonster003/AutoJs6-Plugin-Offline-Docs/blob/master/docs/16kb.md)
