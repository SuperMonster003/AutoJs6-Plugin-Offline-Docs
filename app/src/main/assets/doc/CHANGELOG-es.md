******

### Historial de versiones

******

# v6.8.0

###### 2026/09/16

* `Corrección` Los validadores de documentación sin conexión ya no confunden el nombre público del método del puente Node `callAutoJs` con un nombre de producto heredado sin calificar
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
