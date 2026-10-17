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
fileCount=219
totalBytes=13846415
contentSha256=da914cb790ea798071fc91d02e643fa8f84b03b67cfeab7f978e7e23c8f550df
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=3b2a80f1e4c463c2ad0ba6d82f1715b8a72dcaad
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

# v6.8.6

###### 2026/10/17

* `Corrección` El commit de origen de la documentacion del README podia diferir del registro de procedencia incluido
* `Mejora` Referencia speech de Rhino: reconocimiento, sesiones de activación y dictado, detección de voz, síntesis y gestión speech.models
* `Mejora` Guia de las API de Node.js y Bun: pinyin asincrono, controles de consola, coordenadas y limites de las declaraciones del editor
* `Mejora` Perfiles de Installer por origen/prefijo de paquete, prioridad de opciones explícitas y tres restablecimientos con null, sourceDeleteRequested y conservación de fuentes compartidas del lote; requiere anfitrión 5312+ y plugin compatible
* `Mejora` Documentación y entradas de búsqueda sin conexión para los métodos de selector minDepth/maxDepth/minIndexInParent/maxIndexInParent
* `Mejora` Referencia completa de la API 3-Block Compose: nodos y estado, modificadores, temas, sesiones y ventanas flotantes, propiedades y eventos de componentes, hilos, accesibilidad y aplicaciones empaquetadas
* `Mejora` 3-Block Compose TSX: TSX admite `<compose.Column>`, `<compose:Text>`, referencias a fábricas de nodos, fragmentos, slots y callbacks reactivos; un mismo árbol no puede mezclar Compose y nodos XML existentes
* `Mejora` Referencia del módulo Terminal: sesiones síncronas y asíncronas del plugin 3-Shell Terminal, eventos de salida, scripts npm, permisos y ciclo de vida, además de los tipos TerminalSession, TerminalOpenOptions y TerminalError
* `Mejora` Referencia del módulo colors: conversión OKLab/OKLCH, ajuste de contraste, armonías, escalas tonales, colores derivados, variantes nocturnas, simulación de deficiencias de la visión del color, colores dominantes de una imagen, algoritmo de detección oklab y control del color del tema con colors.theme
* `Mejora` Los iconos del centro de plugins usan los tamaños, posiciones, imágenes claras y oscuras y fondos circulares ajustados en Icon Studio, conservando fuentes y parámetros reproducibles
* `Mejora` Los iconos de información de la aplicación de Android comparten las imágenes y los fondos claros y oscuros de Icon Studio, conservando las imágenes transparentes del centro de plugins y las opciones del lanzador
* `Mejora` 3-Block Compose: Los contenedores XML `<compose>` y compose.attach integran sesiones Compose independientes en páginas UI o ventanas flotantes existentes; compose.AndroidView muestra una View Android existente o devuelta por una fábrica síncrona
* `Mejora` La referencia de 3-Block Compose cubre diálogos independientes y paneles inferiores, reglas de cancelación, permiso de superposición y ciclo de vida de las sesiones
* `Mejora` Referencia de componentes 3-Block Compose V2 con estado controlado, eventos, comandos de foco y desplazamiento, requisitos y compatibilidad
* `Mejora` Referencia de la API device: device.getAndroidId acepta el booleano useSystemId para leer el valor del sistema del usuario Android de la aplicación mediante Shizuku/Root en Android 8.0+, lanza una excepción si falla el permiso o la lectura e ignora el parámetro en sistemas anteriores
* `Mejora` Referencia de AutoJs4 Runtime: finalidad del plugin AutoJs4 Runtime, instalación y sus permisos independientes, la entrada "Ejecutar con AutoJs4" del gestor de archivos para archivos .js / .auto y carpetas de proyecto, reenvío de registros y detención de tareas, límites de ejecución y cómo informar diferencias
* `Mejora` Referencia de AutoJs4 Runtime: modo de comparación "Ejecutar con AutoJs4 y comparar", con las dos ejecuciones, las líneas de inicio y fin y el prefijo omitidos, el resumen y las marcas de diferencia de la página de resultados, la copia de la plantilla de issue y el tiempo límite de 120 segundos
* `Mejora` Referencia de AutoJs4 Runtime: nueva sección "Clases de compatibilidad com.stardust" que explica cómo los nombres de clase con prefijo com.stardust se asignan a las implementaciones de AutoJs6 (asignación completa, parcial y ya no disponibles), cómo las asignaciones renombradas afectan al nombre global de importClass y que Class.forName no se ve afectado
* `Mejora` Referencia del Diseñador de 3-Block Compose: entradas y archivos de proyecto del diseñador visual integrado en el complemento, el lienzo / esquema / propiedades / estado / paleta de componentes del editor, su disposición en vertical y en horizontal y sus borradores, el subconjunto de script reconocido y las reglas de ida y vuelta, el traspaso bidireccional con el editor de AutoJs6, la escritura de vuelta en el origen importado y su reimportación, el estado de vista previa y la vista previa interactiva con sus diferencias respecto a una ejecución real, los proyectos TSX (analizados por TypeScript Engine, en solo lectura sin él), la ejecución del script de un proyecto JavaScript en el entorno aislado de la vista previa interactiva con su consola (Android 8.0 o posterior), los proyectos UI (XML) (desde 1.6.0: edición en el sitio de los diseños XML de los scripts en modo ui, un lienzo dibujado por el servicio de vista previa de AutoJs6, esqueletos de controladores y el panel de enlaces), y las limitaciones actuales; desde 1.7.0 la vista previa interactiva de los proyectos UI (XML) hace que AutoJs6 ejecute todo el script de verdad (Android 13 y posteriores), con una nueva sección sobre ejecutar scripts UI en la vista previa: condiciones, reglas de parada, la consola y las diferencias con una ejecución real; desde 1.8.0, dos secciones nuevas: "Diferencias de vista previa" (líneas que se comportan distinto en la vista previa que en AutoJs6) y "Archivos XML y proyectos de carpeta" (archivos de diseño XML referenciados con rutas literales, Guardar como / Nuevo archivo XML, proyectos de carpeta con project.json, importación y exportación zip, entrega a AutoJs6 para ejecutar o importar, acceso a la carpeta de documentos externos, archivos del proyecto en las vistas previas, edición y comprobación de XML de Android)
* `Mejora` Referencia de atributos XML de Android: para diseños UI en XML nativo de Android, los atributos android: / app: que cada clase View puede o no puede establecer, sus formatos de valor, nombres de enumeraciones y banderas, nivel de API inicial y forma de establecerlos, y los parámetros de diseño que acepta cada padre; la referencia de interfaz de usuario añade los recursos del proyecto (carpeta res/, carpetas con calificadores y vector drawables)
* `Mejora` [Referencia de API](https://docs.autojs6.com/#/documentation): miembros faltantes de Files y RootAutomator, matrices de resultados de color, contextos WebView y sobrecargas opcionales, con correcciones en los parametros de anexado de bytes, deslizamiento y escalado de coordenadas; explica que las llamadas fallidas a setScaleBases no cambian ni consumen las bases y documenta la conversión a enteros de los setters de bases
* `Mejora` Referencia del módulo Gallery: el objeto gallery del plugin 3-Maple Image (selector, sesiones del visor, edición y conversión sin interfaz), el límite de archivos que lee y escribe AutoJs6, el acceso a las fotos, los códigos de error y el tipo GalleryViewSession
* `Mejora` Referencia de files.batchRename: renombrado por lotes del plugin Batch Rename, con vista previa del plan y exclusión por elemento, aplicación, deshacer e historial de lotes, opciones y variables de reemplazo, políticas de conflicto, objetos de resultado y códigos de error
* `Mejora` Referencia de plugins.tools: las herramientas que describen los propios plugins de AutoJs6, con la lista de herramientas y proveedores, las llamadas síncronas y asíncronas, los argumentos de imagen / archivo y los archivos de salida, los objetos de resultado y los errores

# v6.8.5

###### 2026/10/02

* `Mejora` Documentación AI Agent 1.2.0: Herramientas MCP de servidores locales o externos seleccionados, con riesgo por servidor y el grupo mcp desactivado inicialmente
* `Mejora` Documentación de conexión bajo demanda de 3-Stove Agent: centro de plugins como único interruptor, activación inicial automática y desactivaciones respetadas, espera síncrona en un hilo de trabajo, consultas asíncronas, status de solo lectura y sin repetición de tareas
* `Mejora` API de scripts installer / $installer, instalación síncrona y asíncrona, eventos de sesión, inspección de fuentes, desinstalación y autorizaciones, con interacción predeterminada y cancelación
* `Mejora` installer P8: autorización Dhizuku, instalación notification, modos predeterminados preferred/persistent y límites de capacidades del plugin
* `Mejora` Aclarar los valores persistentes del instalador: Dhizuku API 26-33, identidad Root/system en user 0, autorizaciones automáticas admitidas, registros locales y escrituras sin confirmar
* `Mejora` Opciones avanzadas de Installer, observaciones de propiedad y DexOpt, fase optimizing, negociación V3 y límites de las reglas locales de firma/bloqueo

# v6.8.4

###### 2026/09/26

* `Mejora` Documenta el grupo script_dynamic de AI Agent 1.1.0 en desarrollo, la confirmación individual del código, su historial privado y el guardado de scripts registrados mediante el selector de archivos del sistema

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
