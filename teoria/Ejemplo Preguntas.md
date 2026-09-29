Pregunta 1

¿Qué afirmación resume el concepto fundamental del "Embudo de Saneamiento de Datos" explicado en la arquitectura Kotlin para Jetpack Compose?

a. Los objetos crudos evaden al compilador K2 a través de un puente asíncrono para aumentar su rendimiento a costa del NullPointerException.
b. Los datos de la red entran como Singletons (`object`) y terminan renderizados en XML tradicional.
c. Toda la información de la base de datos se almacena dinámicamente usando sentencias `var` mutables para un repintado en vivo más fluido.
d. Los datos en bruto pasan estrictamente a través de filtros de Inmutabilidad (Data Classes) y Seguridad frente a Nulos (Null Safety) antes de llegar como "UI State" puro a la vista.
Correcta

Retroalimentación
La opción correcta es d. El "Embudo de Saneamiento de Datos" consiste en que los datos crudos atraviesan filtros de inmutabilidad y null safety antes de convertirse en UI State puro para la vista.

---

Pregunta 2

¿Cuál es la premisa fundamental que diferencia el enfoque de Programación Funcional en Kotlin frente a la programación imperativa en Java puro?

a. La Programación Funcional en Kotlin compila forzosamente hacia lenguaje interpretado.
b. En Kotlin, las funciones son "Ciudadanos de Primera Clase", lo que significa que pueden almacenarse, pasarse por parámetro o devolverse como resultados de la misma manera que una variable ordinaria.
Correcta
c. En Java las funciones existen fuera de cualquier clase u objeto principal (Top-Level).
d. En Kotlin las funciones operan siempre con estados directamente variables (`var`).

Retroalimentación
La opción correcta es b. En Kotlin las funciones son ciudadanos de primera clase: pueden tratarse como valores, pasarse como argumentos y devolverse como resultados.

---

Pregunta 3

En Kotlin, ¿qué capacidad del compilador elimina la redundancia visual al no requerir que se declare el tipo de forma explícita si el contexto es evidente (ej. `val age = 25`)?

a. Manejo Seguro de Nulos
b. Smart Casting
c. Inferencia de Tipos
Correcta
d. Platform Typing

Retroalimentación
La opción correcta es c. La inferencia de tipos permite que el compilador deduzca el tipo a partir del valor asignado, evitando declaraciones redundantes.

---

Pregunta 4

3. ¿Qué representa una lambda en Kotlin?

a. Una función anónima que puede ser tratada como un valor.
Correcta
b. Una clase que implementa una interfaz funcional.
c. Un tipo especial de variable inmutable.
d. Un método estático dentro de un objeto.

Retroalimentación
La opción correcta es a. Una lambda es una función anónima que puede almacenarse, pasarse o devolverse como cualquier otro valor.

---

Pregunta 5

¿Cuál es el mecanismo de comunicación entre procesos (IPC) de alto rendimiento en Android que sirve como el "corazón" de su sistema nervioso?

a. Mach Ports
b. Binder
Correcta
c. URL Schemes
d. XNU Data Pipes

Retroalimentación
La opción correcta es b. Binder es el mecanismo IPC de alto rendimiento que permite la comunicación entre procesos en Android.

---

Pregunta 6

¿Cuál es la arquitectura subyacente del sistema operativo Android en su capa más profunda?

a. Un entorno de ejecución puramente nativo.
b. Un microkernel modular gestionado por Mach.
c. Un kernel híbrido basado en Darwin.
d. Un kernel monolítico basado en Linux.
Correcta

Retroalimentación
La opción correcta es d. Android se basa en un kernel monolítico Linux en su capa más profunda.

---

Pregunta 7

Para permitir código declarativo limpio (como en Jetpack Compose con `Button(onClick = { /* lógica */ })`), Kotlin implementa una sintaxis idiomática cuando la lambda es el último parámetro de una función. ¿Cómo se denomina esto?

a. Destructuring Declaration
b. Trailing Lambda (Lambda fuera de los paréntesis)
Correcta
c. Inlining Funcional
d. Smart Casting Condicional

Retroalimentación
La opción correcta es b. La sintaxis de trailing lambda permite escribir la lambda fuera de los paréntesis cuando es el último parámetro.

---

Pregunta 8

En 2026, ¿qué modelo de compilación utiliza el Android Runtime (ART) para equilibrar el tiempo de instalación, espacio en disco y rendimiento de ejecución?

a. Un sistema puramente interpretado en tiempo real sin almacenamiento en disco.
b. Ejecución 100% nativa antes de la distribución.
c. Un modelo de compilación híbrido que combina Just-In-Time (JIT) y Ahead-Of-Time (AOT).
Correcta
d. Generación exclusiva de código máquina nativo a través de compilación LLVM.

Retroalimentación
La opción correcta es c. ART utiliza un modelo híbrido JIT + AOT para equilibrar instalación, espacio y rendimiento.

---

Pregunta 9

2. ¿Cuál de las siguientes características distingue a un data class en Kotlin?

a. No puede tener propiedades en el constructor.
b. Solo puede contener funciones abstractas.
c. Permite heredar de múltiples clases.
d. Genera automáticamente equals(), hashCode() y toString().
Correcta

Retroalimentación
La opción correcta es d. Una data class genera automáticamente `equals()`, `hashCode()` y `toString()`, entre otros métodos.

---

Pregunta 10

En las buenas prácticas de arquitectura en Kotlin, es considerado perjudicial y un "Code Smell" el anidar múltiples bloques `let` o `run` consecutivos, ¿por qué?

a. Porque provocan bloqueos permanentes de subprocesos impidiendo que el recolector de basura vacíe memoria.
b. Porque detienen inmediatamente la propagación de corrutinas dentro de las sealed classes.
c. Porque esto genera confusión cognitiva al mezclarse internamente referencias anónimas múltiples (ya no se sabe a qué se refiere `it` o `this`).
Correcta
d. Porque el Android Runtime (ART) los ignorará si se interrumpe la conexión a internet.

Retroalimentación
La opción correcta es c. Anidar múltiples `let`/`run` genera confusión sobre a qué objeto se refieren `it` o `this`, afectando la legibilidad.

---

Pregunta 11

Si necesitamos acceder al objeto mediante el identificador `it` para ejecutar un efecto secundario (como loggear su estado o almacenar un registro), pero deseamos continuar la cadena de ejecución sin alterar el retorno del objeto original, ¿qué Scope Function corresponde?

a. `apply`
b. `run`
c. `also`
Correcta
d. `let`

Retroalimentación
La opción correcta es c. `also` recibe el objeto como `it`, permite efectos secundarios y devuelve el objeto original.

---

Pregunta 12

En Kotlin 2.0, si validas `if (obj is String)`, ¿qué mecanismo del compilador permite utilizar los métodos de `String` directamente dentro del bloque sin hacer conversiones forzadas manuales?

a. Inline Functions
b. Type Erasure
c. Smart Casts (Moldeado Inteligente)
Correcta
d. Null Safety

Retroalimentación
La opción correcta es c. El Smart Casting permite que el compilador trate a `obj` como `String` dentro del bloque luego de la verificación.

---

Pregunta 13

Al procesar un dato proveniente de una fuente insegura (como una API web), si se desea transformar el valor en un modelo UI únicamente en caso de que sea no nulo (encadenando `?.`) y devolver el nuevo resultado renderizado accediendo mediante el alias `it`, ¿qué Scope Function idiomática es obligatoria?

a. `also`
b. `with`
c. `apply`
d. `let`
Correcta

Retroalimentación
La opción correcta es d. `?.let { ... }` es el patrón idiomático para transformar un valor no nulo y devolver el resultado de la transformación.

---

Pregunta 14

¿Cuál de las siguientes características distingue a un data class en Kotlin?

a. Genera automáticamente equals(), hashCode() y toString().
Correcta
b. Solo puede contener funciones abstractas.
c. Permite heredar de múltiples clases.
d. No puede tener propiedades en el constructor.

Retroalimentación
La opción correcta es a. Una data class genera automáticamente `equals()`, `hashCode()` y `toString()`.

---

Pregunta 15

En el mecanismo de seguridad "Sandboxing", ¿cómo engaña el sistema operativo Android a cada aplicación para garantizar el aislamiento?

a. Verifica los permisos de acceso en tiempo de compilación.
b. Le asigna una URL especial de comunicación que no requiere autenticación.
c. Le exige pasar por un puente intermedio de serialización llamado Seatbelt.
d. Le asigna un Identificador de Usuario (UID) único haciéndole creer que es el único usuario en el sistema.
Correcta

Retroalimentación
La opción correcta es d. Android asigna un UID único a cada app y la aísla como si fuera el único usuario del sistema.

---

Pregunta 16

¿Qué es técnicamente una Función de Orden Superior (Higher-Order Function) según los documentos teóricos de Kotlin?

a. Una función que acepta expresiones lambdas como parámetros o que devuelve una función como resultado.
Correcta
b. Una función que, al procesarse en K2, corre con mayor prioridad en el CPU sobre funciones comunes.
c. Toda expresión que devuelva siempre un tipo inmutable para ser renderizado con Compose.
d. Una función que solo puede invocarse internamente usando recursión compleja.

Retroalimentación
La opción correcta es a. Una función de orden superior recibe funciones como parámetros o devuelve una función como resultado.

---

Pregunta 17

Desde Kotlin 1.5, además de `sealed classes`, el lenguaje introdujo `sealed interfaces`. ¿Cuál es su caso de uso ideal frente a las clases selladas tradicionales?

a. Modelar entidades de diseño de pantalla que requieren valores mutables constantes.
b. Actuar únicamente como clases de almacenamiento sin comportamiento en Kotlin Multiplatform.
c. Modelar comportamientos de tipo transversal (ej. un `TimeoutError` que también implementa la interfaz `RetryableError`).
Correcta
d. Declarar métodos `static` de acceso global para compartir memoria caché.

Retroalimentación
La opción correcta es c. Las sealed interfaces permiten modelar jerarquías que también implementan otras interfaces, útil para comportamientos transversales.

---

Pregunta 18

En arquitecturas reactivas (como Jetpack Compose), es vital modificar estados creando nuevas instancias en vez de alterar las existentes (estabilidad de estado). ¿Qué método autogenerado en una `data class` hace esto posible de manera simple?

a. `componentN()`
b. `equals()`
c. `hashCode()`
d. `copy()`
Correcta

Retroalimentación
La opción correcta es d. `copy()` permite crear una nueva instancia modificando solo las propiedades deseadas, manteniendo inmutabilidad.

---

Pregunta 19

Cuando se utiliza `when` como EXPRESIÓN (devolviendo un valor), ¿qué regla exige implacablemente el compilador de Kotlin para evitar comportamientos impredecibles?

a. Que el resultado se evalúe de manera paralela en múltiples hilos concurrentes.
b. Que cada caso solo evalúe valores de variables inmutables creadas por `let`.
c. Que la expresión no use la palabra reservada `else`.
d. Que la exhaustividad sea completa (es obligatorio cubrir todos los casos posibles o colocar un bloque `else`).
Correcta

Retroalimentación
La opción correcta es d. Cuando `when` se usa como expresión, el compilador exige exhaustividad: todos los casos deben cubrirse o debe existir un `else`.

---

Pregunta 20

¿Cuál es la principal diferencia entre el paradigma imperativo y el declarativo?

a. El imperativo describe qué se quiere lograr sin indicar cómo hacerlo.
b. El declarativo obliga a usar programación orientada a objetos.
c. El declarativo se enfoca en describir paso a paso cómo resolver un problema.
d. El imperativo indica cómo lograr un resultado mediante instrucciones explícitas.
Correcta

Retroalimentación
La opción correcta es d. El paradigma imperativo indica explícitamente cómo lograr un resultado mediante instrucciones paso a paso.

---

Pregunta 21

¿Qué diferencia radical existe entre un clásico `enum` en Java/Kotlin y una `sealed class` moderna en Kotlin?

a. La `sealed class` es más difícil de evaluar en una expresión `when` que un `enum` simple.
b. El `enum` solo maneja valores cerrados sin datos adicionales; la `sealed class` es una jerarquía que permite que cada estado contenga un modelo de datos complejo y distinto.
Correcta
c. El `enum` consume memoria excesiva; la `sealed class` se aloja en el procesador.
d. El `enum` es compatible con Compose y la `sealed class` solo funciona en capas de backend.

Retroalimentación
La opción correcta es b. La sealed class permite que cada subtipo tenga su propio modelo de datos, a diferencia del enum simple.

---

Pregunta 22

¿Qué ventaja aporta el uso de `Extension Functions` (Funciones de Extensión) en una arquitectura de software limpia en Kotlin?

a. Evitan que se utilice el Operador Elvis obligando al programador a reescribir utilitarios estáticos complejos.
b. Generan herencia forzada en las bibliotecas de Jetpack Compose haciendo que cada botón deba derivar de un componente raíz.
c. Permiten "pegar" nuevo comportamiento, validaciones o utilidades directamente a tipos estándar y clases cerradas (como `String` o `Int`) sin usar herencia tradicional ni "contaminar" las clases de dominio.
Correcta
d. Requieren que se acceda directamente al núcleo del sistema operativo Android y modifiquen las directrices de Binder IPC.

Retroalimentación
La opción correcta es c. Las extension functions añaden comportamiento a tipos existentes sin herencia ni modificar la clase original.

---

Pregunta 23

Según el análisis del ecosistema móvil en 2026, ¿qué tendencia describe el fenómeno de la "Premiumización"?

a. La renovación de dispositivos hacia modelos con mejor hardware capaz de procesar IA y Realidad Aumentada localmente.
Correcta
b. La migración de todos los usuarios de la gama media hacia plataformas basadas en la nube.
c. La eliminación total del entorno de ejecución mixto en dispositivos móviles básicos.
d. El abandono definitivo de Android en favor del sistema operativo iOS a nivel mundial.

Retroalimentación
La opción correcta es a. La premiumización se refiere a la renovación hacia dispositivos con mejor hardware para IA y RA local.

---

Pregunta 24

¿Qué representa una lambda en Kotlin?

a. Una función anónima que puede ser tratada como un valor.
Correcta
b. Una clase que implementa una interfaz funcional.
c. Un tipo especial de variable inmutable.
d. Un método estático dentro de un objeto.

Retroalimentación
La opción correcta es a. Una lambda es una función anónima que puede tratarse como un valor.

---

Pregunta 25

1. ¿Cuál es la principal diferencia entre el paradigma imperativo y el declarativo?

a. El declarativo se enfoca en describir paso a paso cómo resolver un problema.
b. El imperativo describe qué se quiere lograr sin indicar cómo hacerlo.
c. El imperativo indica cómo lograr un resultado mediante instrucciones explícitas.
Correcta
d. El declarativo obliga a usar programación orientada a objetos.

Retroalimentación
La opción correcta es c. El paradigma imperativo indica explícitamente cómo lograr un resultado mediante instrucciones paso a paso.

---

Pregunta 26

Para solucionar el histórico problema del `NullPointerException` en entornos de producción, ¿cómo aborda Kotlin el problema desde su raíz?

a. Agregando múltiples sentencias obligatorias `try/catch` de forma automática e invisible.
b. Delegando al desarrollador la comprobación manual a través de estructuras `if (variable != null)`.
c. Creando clases anónimas por cada propiedad potencialmente inestable.
d. Integrando la nulidad en el Sistema de Tipos (por defecto, las variables NO aceptan nulos).
Correcta

Retroalimentación
La opción correcta es d. Kotlin integra la nulidad en el sistema de tipos: por defecto las variables no aceptan nulos.

---

Pregunta 27

Analizando los lenguajes Kotlin y Swift en la plataforma móvil (KMP), ¿qué mecanismo en Swift es análogo directo a declarar una variable nula `String?` en Kotlin?

a. Variables estáticas compartidas
b. El tipo Optional (`Optional<String>`)
Correcta
c. Forced Unwrapping
d. Nil-Coalescing

Retroalimentación
La opción correcta es b. En Swift, `Optional<String>` es el análogo directo a `String?` en Kotlin.

---

Pregunta 28

A diferencia de todas las otras Scope Functions de Kotlin, ¿cuál de ellas es invocada como una función independiente normal que recibe el objeto explícitamente como argumento, en vez de llamarse como una función de extensión con el punto (`.`)?

a. `run`
b. `with`
Correcta
c. `also`
d. `apply`

Retroalimentación
La opción correcta es b. `with` es una función independiente que recibe el objeto como primer argumento.

---

Pregunta 29

Deseamos tomar un nuevo objeto instanciado, configurarlo aplicándole múltiples propiedades inmediatamente y devolver esa misma entidad modificada. El contexto ideal de esta función requerirá llamar directamente las propiedades del objeto (sin `it.`). ¿Qué Scope Function aplica aquí?

a. `let`
b. `apply`
Correcta
c. `run`
d. `with`

Retroalimentación
La opción correcta es b. `apply` usa `this` como receptor, permite configurar propiedades y devuelve el objeto original.

---

Pregunta 30

Cuando declaras `object HttpClientProvider` en Kotlin, ¿qué garantías te brinda automáticamente el compilador en un entorno de concurrencia y subprocesos múltiples?

a. Una inicialización perezosa (lazy) totalmente segura (thread-safe) y que garantiza una única instancia en toda la aplicación.
Correcta
b. La obligación de declarar explícitamente el uso de bloques `synchronized` para evitar bloqueos del sistema.
c. Un objeto transitorio que se clona (con `.copy()`) cada vez que un hilo distinto lo invoca.
d. Que el objeto solo existirá en memoria RAM hasta que la pantalla (Actividad) se cierre en Android.

Retroalimentación
La opción correcta es a. La declaración `object` garantiza una única instancia thread-safe en toda la aplicación.

---

Pregunta 31

Al combinar una clase sellada (`sealed class`) para modelar estados de red (ej. NetworkResult) y la expresión `when` para evaluarla en la UI, ¿qué representa el "Escudo del Compilador"?

a. Un entorno (sandbox) en Android Runtime que absorbe fallos lógicos durante el uso del usuario final.
b. El proceso de verificación matemática que asegura la exhaustividad total, prohibiendo la compilación si un caso nuevo (ej. `Timeout`) no ha sido manejado explícitamente.
Correcta
c. La obligación algorítmica del compilador de impedir la ejecución si un nuevo estado no ha sido declarado en la clase sellada base.
d. La capacidad del compilador de inyectar variables de tipo nulo automáticamente al detectar lentitud.

Retroalimentación
La opción correcta es b. El compilador verifica exhaustividad y no permite compilar si un caso de la sealed class no está cubierto en el `when`.

---

Pregunta 32

¿Qué patrón es el estándar idiomático más recomendado en Android moderno para lograr ejecutar código protegido, combinando "null-safety", "smart casting", transformación y ejecución opcional segura?

a. `!!run { ... }`
b. `var as? Class` seguido de `apply`
c. `?.let { ... }`
Correcta
d. `if(var != null) { ... }`

Retroalimentación
La opción correcta es c. `?.let { ... }` combina llamada segura, smart cast, transformación y ejecución opcional.

---

Pregunta 33

Al integrar el paradigma Funcional con la Programación Orientada a Objetos en Kotlin para el desarrollo en Android, ¿cómo se posicionan frente a frente?

a. La Programación Funcional solo se utiliza para construir vistas, delegando el manejo real del estado y seguridad de datos a métodos abstractos polimórficos tradicionales de Java.
b. Ambos paradigmas se complementan: la OOP modela entidades y arquitecturas mientras la FP transforma los datos y pasa comportamiento de forma segura, inmutable y declarativa.
Correcta
c. La Orientación a Objetos se ha abandonado totalmente tras la llegada de las Lambdas y las Scope Functions de Jetpack Compose.
d. La Programación Funcional obliga a desechar las jerarquías de dominios en favor de simples scripts matemáticos y declarativos puros en consola.

Retroalimentación
La opción correcta es b. OOP y FP se complementan: OOP modela entidades y FP transforma datos de forma segura e inmutable.

---

Pregunta 34

Al procesar respuestas de APIs o modelos de datos anidados, ¿qué operador se utiliza para detener la evaluación inmediatamente (cortocircuito) retornando null si algún eslabón es nulo, sin producir una excepción?

a. Operador de Aserción No Nula (!!)
b. Operador de Llamada Segura (?.)
Correcta
c. Operador Elvis (?:)
d. Smart Casts (is)

Retroalimentación
La opción correcta es b. El operador `?.` detiene la evaluación y devuelve null si algún eslabón es nulo, sin lanzar excepción.

---

Pregunta 35

Si comparamos el impacto directo medible del sistema de tipos seguro de Kotlin en los proyectos Android modernos frente a los desarrollados exclusivamente en Java, ¿cuál es un beneficio estadístico validado en la industria?

a. La anulación absoluta del consumo de datos en red al usar lambdas optimizadas por el compilador AOT de Android 16.
b. Una reducción probada de casi el 20% en la probabilidad de "crashes" (cierres inesperados) en producción gracias a la detección temprana del compilador de los errores de referencia nula.
Correcta
c. Un ahorro del 94% del espacio total en disco del sistema de archivos al compilar los proyectos.
d. Un rendimiento un 50% superior al ejecutar Garbage Collection en gamas medias locales en Latinoamérica.

Retroalimentación
La opción correcta es b. Kotlin reduce aproximadamente un 20% los crashes por errores de referencia nula.

---

Pregunta 36

Para elegir correctamente entre las "Scope Functions" del lenguaje Kotlin (apply, run, with, let, also), se deben contestar dos preguntas fundamentales. ¿Cuáles son?

a. ¿Cómo quiero acceder al objeto dentro del bloque (como `this` o como `it`)? y ¿Qué necesito que devuelva la función (el objeto original o el resultado del cálculo)?
Correcta
b. ¿El valor a evaluar proviene de red o base de datos local? y ¿Será procesado en JIT o AOT?
c. ¿El objeto es de un tipo Platform (`!`) o Nullable (`?`)? y ¿Qué estado sellado lo engloba?
d. ¿El proyecto fue iniciado con "Kotlin-First" o migrado desde Java heredado? y ¿Utiliza Jetpack Compose?

Retroalimentación
La opción correcta es a. Las dos preguntas clave son el tipo de acceso (`this` o `it`) y el tipo de retorno (objeto original o resultado).

---

Pregunta 37

¿Por qué adoptó Google la filosofía "Kotlin-First" como estándar mandatorio para el ecosistema Android?

a. Porque Kotlin reduce el ruido sintáctico (boilerplate) permitiendo que la lógica de negocio resalte y se disminuya la deuda técnica.
Correcta
b. Porque es el único lenguaje que el compilador LLVM puede leer.
c. Para reemplazar por completo y eliminar el uso de la Máquina Virtual de Java (JVM).
d. Porque Kotlin compila mucho más rápido que Java convirtiendo las aplicaciones en ejecutables iOS.

Retroalimentación
La opción correcta es a. Kotlin reduce boilerplate y deuda técnica, permitiendo que la lógica de negocio sea más clara.

---

Pregunta 38

¿Qué concepto utiliza Kotlin para reemplazar definitivamente a los miembros `static` del lenguaje Java, eliminando la compleja necesidad de sincronizar el código defensivo multihilo?

a. La clase `data class Singleton`
b. Las Funciones de Orden Superior
c. Las Extension Functions
d. La declaración `object` (El Patrón Singleton Nativo)
Correcta

Retroalimentación
La opción correcta es d. La declaración `object` crea un singleton nativo thread-safe, reemplazando a los miembros estáticos.

---

Pregunta 39

¿Qué salto arquitectónico introduce el nuevo compilador K2 de Kotlin 2.0+ en comparación con el K1 (Legacy)?

a. Reemplaza el uso de la memoria virtual en favor del compilador Ahead-Of-Time exclusivamente.
b. Exige la mutabilidad por defecto en todas las funciones declaradas.
c. Presenta una arquitectura unificada (FIR) que permite hasta un 94% más de velocidad en compilaciones limpias e inferencia semántica inteligente.
Correcta
d. Elimina las corrutinas en favor de la gestión manual de hilos del procesador.

Retroalimentación
La opción correcta es c. K2 introduce una arquitectura unificada FIR con mejoras de velocidad e inferencia semántica.

---

Pregunta 40

Cuando Kotlin consume un método de Java que carece de anotaciones de nulidad (@Nullable o @NotNull), ¿qué tipo de dato problemático le asigna el compilador?

a. Tipo estrictamente seguro (String)
b. Platform Type o Tipo de Plataforma (String!)
Correcta
c. Tipo Opcional (Optional)
d. Tipo anulable por defecto (String?)

Retroalimentación
La opción correcta es b. Kotlin asigna un Platform Type (`String!`) que puede tratarse como nulo o no nulo, con riesgo de error.

---

Pregunta 41

El uso intensivo de lambdas en funciones de colección (como `.filter`, `.map`) crearía numerosos objetos en memoria en Java. Para evitar este costo de rendimiento sin sacrificar código idiomático en Kotlin, ¿qué modificador se utiliza en la declaración de estas funciones de orden superior?

a. `crossinline`
b. `reified`
c. `inline`
Correcta
d. `suspend`

Retroalimentación
La opción correcta es c. `inline` evita la creación de objetos lambda y mejora el rendimiento en funciones de orden superior.

---

Pregunta 42

¿Qué sintaxis indica que una variable pertenece al conjunto de tipos que sí tienen capacidad de contener la ausencia de valor en Kotlin?

a. La anotación `@Nullable` antes del tipo de variable.
b. El sufijo de un signo de interrogación (ej. `String?`).
Correcta
c. La palabra reservada `optional`.
d. El sufijo del signo de exclamación (ej. `String!`).

Retroalimentación
La opción correcta es b. El sufijo `?` indica que el tipo puede contener null.

---

Pregunta 43

¿Qué define una función de orden superior?

a. Una función que solo puede ejecutarse dentro de una coroutine.
b. Una función que recibe o devuelve otra función.
Correcta
c. Una función que no puede tener parámetros.
d. Una función que se ejecuta únicamente en tiempo de compilación.

Retroalimentación
La opción correcta es b. Una función de orden superior recibe o devuelve otra función.

---

Pregunta 44

A diferencia de Android que utiliza "Garbage Collection", ¿qué sistema utiliza iOS para liberar la memoria en el instante exacto en que un objeto deja de usarse?

a. Low Memory Killer (LMK)
b. Just-In-Time Compiler (JIT)
c. Profile Guided Optimization (PGO)
d. Automatic Reference Counting (ARC)
Correcta

Retroalimentación
La opción correcta es d. iOS utiliza Automatic Reference Counting (ARC) para liberar memoria cuando un objeto deja de usarse.

---

Pregunta 45

¿Por qué el operador de Aserción No Nula (`!!`) se considera una mala práctica y un "Code Smell" en ingeniería móvil?

a. Porque fuerza a tratar un valor anulable como seguro, lanzando inmediatamente un `NullPointerException` si la suposición falla.
Correcta
b. Porque ignora por completo la eficiencia de consumo de batería de ART (Android Runtime).
c. Porque obliga al compilador K2 a deshabilitar la inferencia de tipos general.
d. Porque hace que el código compilado no sea compatible con dispositivos iOS.

Retroalimentación
La opción correcta es a. `!!` fuerza un valor anulable como no nulo y lanza `NullPointerException` si falla.

---

Pregunta 46

4. ¿Qué define una función de orden superior?

a. Una función que recibe o devuelve otra función.
Correcta
b. Una función que se ejecuta únicamente en tiempo de compilación.
c. Una función que no puede tener parámetros.
d. Una función que solo puede ejecutarse dentro de una coroutine.

Retroalimentación
La opción correcta es a. Una función de orden superior recibe o devuelve otra función.

---

Pregunta 47

¿Cuál es el propósito principal de una extension function en Kotlin?

a. Añadir comportamiento adicional a un tipo sin necesidad de herencia.
Correcta
b. Modificar el código fuente de una clase existente.
c. Crear una nueva clase que reemplace a la original.
d. Agregar nuevas propiedades almacenadas a un tipo.

Retroalimentación
La opción correcta es a. Las extension functions añaden comportamiento a un tipo sin herencia ni modificar la clase original.

---

Pregunta 48

¿A qué equivalente sintáctico de Kotlin en el manejo de nulos (el Operador Elvis `?:`) corresponde la estructura Nil-Coalescing (`??`) en el lenguaje Swift?

a. Funciones Lambda
b. Proveer un valor por defecto o de respaldo en caso de recibir un nulo
Correcta
c. Smart Casting
d. Inferencia de Tipos

Retroalimentación
La opción correcta es b. Tanto `?:` en Kotlin como `??` en Swift proveen un valor por defecto si el valor es nulo.

---

Pregunta 49

¿Cuál es la "Regla de Oro" respecto a la mutabilidad de las variables recomendada en ingeniería móvil?

a. Utilizar arreglos mutables de Java para asegurar la interoperabilidad con servicios Legacy.
b. Usar siempre `var` para no agotar la memoria disponible en el dispositivo.
c. Intercambiar entre `val` y `var` dependiendo del tamaño de la clase de datos (data class).
d. Siempre declarar con `val` como estado por defecto y cambiar a `var` solo si es estrictamente necesario.
Correcta

Retroalimentación
La opción correcta es d. La regla de oro es usar `val` por defecto y `var` solo cuando sea estrictamente necesario.

---

Pregunta 50

En Kotlin, la sentencia `when` no requiere la instrucción `break` utilizada en el antiguo `switch` de Java. ¿Qué error de diseño humano se elimina completamente con este cambio?

a. El uso innecesario de bucles `for` y `while`.
b. El "Fall-through", donde por olvido del programador el código "cae" al siguiente caso accidentalmente.
Correcta
c. La mutabilidad no deseada generada en las variables de control.
d. El desbordamiento de pila (StackOverflow) en funciones recursivas anidadas.

Retroalimentación
La opción correcta es b. `when` elimina el fall-through accidental típico del `switch` de Java.