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

# v6.8.5

###### 2026/09/29

* `Mejora` Documentación AI Agent 1.2.0: Herramientas MCP de servidores locales o externos seleccionados, con riesgo por servidor y el grupo mcp desactivado inicialmente
* `Mejora` Documentación de conexión bajo demanda de 3-Stove Agent: centro de plugins como único interruptor, activación inicial automática y desactivaciones respetadas, espera síncrona en un hilo de trabajo, consultas asíncronas, status de solo lectura y sin repetición de tareas

# v6.8.4

###### 2026/09/26

* `Mejora` Documenta el grupo script_dynamic de AI Agent 1.1.0 en desarrollo, la confirmación individual del código, su historial privado y el guardado de scripts registrados mediante el selector de archivos del sistema

# v6.8.3

###### 2026/09/25

* `Mejora` Documentar los requisitos de Android y del anfitrión de Agent 1.0.0, el catálogo de modelos de 3-Stone AI y las observaciones de texto/OCR; mantener el contenido en 6.8.0 con una versión independiente del complemento
* `Mejora` Sincronizar grupos globales, modo prudente, presupuestos y límites del protocolo Agent, con restricciones por perfil y tarea
* `Mejora` Sincronizar la memoria de preferencias Agent, confirmaciones individuales, consultas por ámbito, importación/exportación JSON y la diferencia entre inyección automática y herramientas de memoria
* `Mejora` Sincronización de preajustes Agent con nombre, selección predeterminada y de modelo, combinación de contexto fijo y restricciones de herramientas, presupuestos, confirmaciones, carpetas de scripts y memoria
* `Mejora` Sincronización de API ai.agent, ciclo de vida AgentRun, respuestas y confirmaciones, presupuestos, resultados de scripts, tres ejemplos e índice de búsqueda sin conexión
* `Mejora` Sincronizada la referencia de EPUB y el índice de búsqueda sin conexión, cubriendo el global epub del plugin Readium EPUB Reader, los miembros de EpubBook para metadatos, índice, orden de lectura, extracción de texto, exportación de portada y recursos y búsqueda de texto completo, los eventos, controles y preferencias de lectura de EpubReaderSession, el objeto de posición EpubLocator y los códigos de EpubError
* `Mejora` Sincronizada la referencia de EPUB y el índice de búsqueda sin conexión con los resaltados y notas del plugin Readium EPUB Reader 1.1.0 (versión 2 del contrato EPUB): EpubBook#annotations y la capa de conveniencia epub.annotations, el evento highlight de EpubReaderSession y los portadores de EpubLocator

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
