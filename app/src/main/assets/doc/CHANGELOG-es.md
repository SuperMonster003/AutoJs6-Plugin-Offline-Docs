******

### Historial de versiones

******

# v6.8.13

###### 2026/10/18

* `Función` Node.js/Bun: Descargas HTTP(S) de WebView, selección de archivos del sistema y callbacks asíncronos WebViewClient/WebChromeClient con reglas nativas de navegación y recursos

# v6.8.12

###### 2026/10/18

* `Función` Node.js/Bun: Carga WebView y resultados JavaScript, paneles Drawer, navegación y menús Toolbar, páginas ViewPager y eventos nativos asíncronos

# v6.8.11

###### 2026/10/18

* `Función` Node.js/Bun admiten formularios y diseños XML comunes, propiedades View asíncronas, asignaciones ordenadas, recuperación de errores y Workers

# v6.8.10

###### 2026/10/18

* `Función` Node.js/Bun admiten identificadores View de cada ejecución, fábricas AndroidView asíncronas, contenedores XML Compose, limpieza de Workers y aplicaciones empaquetadas

# v6.8.9

###### 2026/10/18

* `Función` Node.js/Bun UI y Compose admiten diseños nativos, componentes de datos, estado reactivo y eventos, con permisos independientes y cierre automático

# v6.8.8

###### 2026/10/17

* `Función` Node.js/Bun images admite filtros avanzados, conversión de color, búsquedas multicolor, círculos, métricas de similitud y carga de URL
* `Función` Node.js/Bun images admite extracción y coincidencia SIFT/ORB con coordenadas de escena, geometría ObjectFrame y handles Mat/características por ejecución
* `Función` Node.js/Bun images admite cuantización PNG y compresión con métricas de calidad/memoria, resultados binarios y salida mediante descriptor de archivo

# v6.8.7

###### 2026/10/17

* `Función` El hilo principal de Node.js y los Workers admiten grabacion H.264 MP4 con audio AAC de microfono, reproduccion o mixto, capturas simultaneas y limpieza de grabaciones Worker sin guardar (API / TypeScript / Ace)

# v6.8.6

###### 2026/10/17

* `Corrección` El commit de origen de la documentacion del README podia diferir del registro de procedencia incluido
* `Mejora` Bun screenRecorder genera MP4 H.264 con audio AAC opcional del micrófono, aplicaciones o mezcla y capturas durante la grabación, con permisos de audio independientes y limpieza al cancelar (API documentation)
* `Mejora` Bun screenRecorder graba vídeos de pantalla H.264 MP4 sin audio con permiso independiente, dimensiones fijas, finalización explícita y limpieza al cancelar (API documentation)
* `Mejora` Los Workers de Node.js ofrecen pinyin, pinyin4j, controles de consola y coordenadas, compartiendo el estado padre y conservando los flujos nativos (API documentation)
* `Mejora` Documentación de API para el consentimiento de captura de Bun y los módulos OpenCC/imágenes de Workers Node.js
* `Mejora` Referencia de OpenCC e imágenes de Node.js y Bun, con identificadores asíncronos, formatos de píxel, permisos y límites de transferencia
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

# v6.8.3

###### 2026/09/25

* `Mejora` Documentar los requisitos de Android y del anfitrión de Agent 1.0.0, el catálogo de modelos de 3-Stone AI y las observaciones de texto/OCR; mantener el contenido en 6.8.0 con una versión independiente del complemento
* `Mejora` Sincronizar grupos globales, modo prudente, presupuestos y límites del protocolo Agent, con restricciones por perfil y tarea
* `Mejora` Sincronizar la memoria de preferencias Agent, confirmaciones individuales, consultas por ámbito, importación/exportación JSON y la diferencia entre inyección automática y herramientas de memoria
* `Mejora` Sincronización de preajustes Agent con nombre, selección predeterminada y de modelo, combinación de contexto fijo y restricciones de herramientas, presupuestos, confirmaciones, carpetas de scripts y memoria
* `Mejora` Sincronización de API ai.agent, ciclo de vida AgentRun, respuestas y confirmaciones, presupuestos, resultados de scripts, tres ejemplos e índice de búsqueda sin conexión
* `Mejora` Sincronizada la referencia de EPUB y el índice de búsqueda sin conexión, cubriendo el global epub del plugin Readium EPUB Reader, los miembros de EpubBook para metadatos, índice, orden de lectura, extracción de texto, exportación de portada y recursos y búsqueda de texto completo, los eventos, controles y preferencias de lectura de EpubReaderSession, el objeto de posición EpubLocator y los códigos de EpubError
* `Mejora` Sincronizada la referencia de EPUB y el índice de búsqueda sin conexión con los resaltados y notas del plugin Readium EPUB Reader 1.1.0 (versión 2 del contrato EPUB): EpubBook#annotations y la capa de conveniencia epub.annotations, el evento highlight de EpubReaderSession y los portadores de EpubLocator

# v6.8.0

###### 2026/09/19

* `Corrección` Los validadores de documentación sin conexión ya no confunden el nombre público del método del puente Node `callAutoJs` con un nombre de producto heredado sin calificar
* `Corrección` Advertencias de lectura de SDK XML v4 con AGP 9.1 y comprobaciones de alineación nativa de APK activadas por error al ensamblar pruebas unitarias JVM, mediante los plugins de compilación compartidos 1.8.3
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
