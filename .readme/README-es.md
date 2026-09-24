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
totalBytes=11591728
contentSha256=86dc59d481e1d99d3f8f466735751ba24c2f8927f17f19e4dccdddf3a9c10779
sourceRepository=SuperMonster003/AutoJs6-Documentation
sourceBaseCommit=8155a4f9a8133e619dacae7f00f76662668d7726
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

# v6.8.0

###### 2026/09/24

* `Corrección` Los validadores de documentación sin conexión ya no confunden el nombre público del método del puente Node `callAutoJs` con un nombre de producto heredado sin calificar
* `Corrección` Advertencias de lectura de SDK XML v4 con AGP 9.1 y comprobaciones de alineación nativa de APK activadas por error al ensamblar pruebas unitarias JVM, mediante los plugins de compilación compartidos 1.8.3
* `Mejora` Sincronizar la memoria de preferencias Agent, confirmaciones individuales, consultas por ámbito, importación/exportación JSON y la diferencia entre inyección automática y herramientas de memoria
* `Mejora` Sincronización de preajustes Agent con nombre, selección predeterminada y de modelo, combinación de contexto fijo y restricciones de herramientas, presupuestos, confirmaciones, carpetas de scripts y memoria
* `Mejora` Sincronización de API ai.agent, ciclo de vida AgentRun, respuestas y confirmaciones, presupuestos, resultados de scripts, tres ejemplos e índice de búsqueda sin conexión
* `Mejora` Sincronizar las API de clic por coordenadas, maxAttempts en 0 para intentos ilimitados, las pilas de errores Flow, la salida de consola y el índice de búsqueda sin conexión
* `Mejora` Sincronizar los pasos opcionales de Flow, los bucles acotados, la búsqueda y los clics de candidatos encadenados, las instantáneas estables de colecciones y los valores predeterminados, y actualizar el índice de búsqueda sin conexión
* `Mejora` Sincronización de la referencia de permisos de red local y el índice sin conexión, con condiciones Android 17 / targetSdk 37, autorización asíncrona, reintentos y límites de Socket / MQTT nativos y permisos de plugins
* `Mejora` Sincronizar la referencia de `device.pageSize` y el índice de búsqueda sin conexión, documentando los bytes, el acceso de solo lectura y la diferencia entre el entorno de ejecución y la compatibilidad de bibliotecas nativas
* `Mejora` Sincronización de la referencia de OCR y el índice de búsqueda sin conexión con la selección automática del motor, la lectura del modo en tiempo real, el restablecimiento con tap, las opciones por llamada y el comportamiento sin plugins disponibles
* `Mejora` Se sincronizaron la referencia de MediaInfo y el índice de búsqueda sin conexión con el límite entre `read` heredado y `snapshot` versiónado, la negociación de schema v1/v2 del plugin, `capabilities` ligero y metadatos dinámicos de tracks v2 y del motor
* `Mejora` Se sincronizaron la referencia Pinyin y el índice de búsqueda sin conexión con sustituciones de lectura `customDictionary` por llamada, `compare`/`compact` completados y acceso desde Node.js mediante `autojs6:bridge.callAutoJs` con la capacidad explícita `pinyin`
* `Mejora` Sincronizada la referencia de Image Quantization v4 y el indice de busqueda sin conexion con presupuestos configurables de pixeles y memoria de trabajo, diagnosticos tipados de limite de recursos, metricas de memoria maxima contabilizada y cancelacion por solicitud explicita o cierre del script
* `Mejora` Alineó el versionName del plugin con la versión de la documentación de AutoJs6 de destino e incrementó automáticamente en 1 el build/versionCode de cada proyecto tras sincronizar correctamente la documentación
* `Mejora` Se actualizaron la documentación integrada de AutoJs6 6.8.0 y el índice de búsqueda sin conexión con la API Preview de detección de objetos YOLO, la configuración del proveedor exacto, el perfil del modelo, los tipos de resultado y los códigos de error estables
* `Mejora` Se completó la referencia de IA integrada con descubrimiento de modelos de plugins, selectores oficiales y de componentes exactos, historial de mensajes multirrol, controles de generación, cargas útiles precisas de uso y streaming, y ejemplos completos de enrutamiento
* `Mejora` Se amplió la referencia de IA integrada y el índice de búsqueda sin conexión con la API de conversación persistente `ai.session`, controles fijos de sesión, reglas de ciclo de vida de un prompt nuevo por turno, descubrimiento de capacidades y semántica de limpieza explícita
* `Mejora` Se amplió la referencia de IA integrada y el índice sin conexión con salida restringida por JSON Schema mediante `structuredJson`/`responseSchema`, schema fijo para sesiones persistentes, retorno de texto JSON y reglas de fallo
* `Mejora` Se ampliaron la referencia de IA integrada y el índice sin conexión con perfiles backend CPU/GPU/NPU explícitos, disponibilidad por dispositivo y razones estables en `ai.catalog`, backend fijo para sesiones persistentes, límites de compatibilidad GPU y contrato sin fallback
* `Mejora` Se sustituyeron todas las API de listado y comprobación de configuración de IA no publicadas por el directorio unificado de destinos `ai.catalog`, el enrutamiento exacto mediante `target`, metadatos completos de respuestas y sesiones, errores estables sin fallback y recursos en línea/sin conexión sincronizados
* `Mejora` Se amplió la referencia runtime integrada y el índice de búsqueda sin conexión con seis sobrecargas de `loadJarWithR8` para exportar mapping/seeds/usage/retrace metadata verificados y la API `retraceR8Stack` del protocolo 1.1, con vínculo de procedencia y fallo cerrado sin fallback
* `Mejora` Unificar el diseño del README y la gestión de versiones de la plataforma Gradle
* `Mejora` La referencia MediaInfo y la búsqueda sin conexión cubren streamNumber, countGet, infoKind y las rutas originales
* `Mejora` La verificación de compilación rechaza dependencias nativas accidentales y genera un informe JSON
* `Mejora` Sincronizada la referencia de Mail y el índice de búsqueda sin conexión, cubriendo el global mail del plugin Angus Mail, los métodos de MailClient para envío, búsqueda, adjuntos, marcas, carpetas y vigilancia, MailMessage, MailAccountOptions con los preajustes de proveedor, MailSearchQuery y los códigos de error de MailError
* `Mejora` Sincronizada la referencia de EPUB y el índice de búsqueda sin conexión, cubriendo el global epub del plugin Readium EPUB Reader, los miembros de EpubBook para metadatos, índice, orden de lectura, extracción de texto, exportación de portada y recursos y búsqueda de texto completo, los eventos, controles y preferencias de lectura de EpubReaderSession, el objeto de posición EpubLocator y los códigos de EpubError
* `Mejora` Sincronizada la referencia de EPUB y el índice de búsqueda sin conexión con los resaltados y notas del plugin Readium EPUB Reader 1.1.0 (versión 2 del contrato EPUB): EpubBook#annotations y la capa de conveniencia epub.annotations, el evento highlight de EpubReaderSession y los portadores de EpubLocator

# v6.8.2

###### 2026/09/15

* `Mejora` compileSdk y targetSdk suben a 37 (Android 17); el comportamiento del plugin no depende del nuevo objetivo

# v6.8.1

###### 2026/09/14

* `Mejora` Sincronizar la guía de almacenamiento de apps empaquetadas, incluidos requiresSharedStorage, denegación de permisos, regreso de ajustes y recuperación del acceso de inicio
* `Mejora` Sincronizar la referencia Media y el índice para servicios de música Media3, propiedad de reproducción, preparación en hilos de trabajo, controles y permisos de aplicaciones empaquetadas
* `Mejora` Sincronización de la referencia Pangu y su índice de búsqueda, que cubre pangu.js 10.1.0 integrado, acceso global, espaciado de texto y comprobación
* `Mejora` Sincronizar la documentación HTTP sobre el alcance por solicitud de isInsecure / insecure, la configuración compartida del cliente, la confianza en certificados, CT, ECH y los permisos de red local
* `Mejora` Sincronizar las referencias de Media, Device, TTS y Settings con las condiciones de audio en segundo plano de Android 17, el bloqueo silencioso, la recuperación desde la aplicación visible y los límites del proceso del motor TTS
* `Mejora` Comprobación de la firma completa, los APK esperados y la documentación reproducible de cada versión

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
