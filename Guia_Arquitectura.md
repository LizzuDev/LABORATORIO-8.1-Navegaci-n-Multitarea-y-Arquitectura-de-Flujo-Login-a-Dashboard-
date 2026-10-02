# Resumen de la Arquitectura - SafePass 2026

Este documento es tu **mapa mental** para el examen. Resume la función de cada archivo y te ayudará a saber exactamente dónde debes codificar cuando el ingeniero te plantee un reto.

## 1. `Asistente.kt` (Capa de Datos / Entidad)
*   **¿Qué hace?** Es el modelo de datos. Define "qué es" un asistente. Como bien razonaste, actúa como la base de datos o el "backend" de la aplicación.
*   **¿Qué código tiene?** Una `data class` con las propiedades (`nombre`, `edad`, `tipoEntrada`).
*   **Modifica este archivo SI EL RETO IMPLICA:**
    *   Agregar un nuevo dato que el usuario deba ingresar (ej. pedir `email`, `telefono`, `codigoDescuento`).
    *   Cambiar si un dato es obligatorio u opcional (ej. cambiar `Int?` a `Int`).

## 2. `RegistroState.kt` (Capa de Estado UI)
*   **¿Qué hace?** Define de forma cerrada y exhaustiva todos los escenarios o estados posibles en los que puede encontrarse la aplicación en un momento dado.
*   **¿Qué código tiene?** Una `sealed class` (o `sealed interface`) con `data object` para estados estáticos (como `Idle` o `Loading`) y `data class` para estados que transportan datos a la interfaz (como `Success` y `Error`).
*   **Modifica este archivo SI EL RETO IMPLICA:**
    *   Añadir un nuevo escenario general a la aplicación (ej. crear el estado `Warning`, `Duplicado`, `Baneado`, `Loading`).
    *   Categorizar los errores usando una `sealed interface` (ej. `ErrorEdad`, `ErrorNombre`).

## 3. `SafePassLogic.kt` (Capa de Lógica de Negocio / Dominio)
*   **¿Qué hace?** Es el "cerebro" u oficial de seguridad. Aquí ocurren las validaciones estrictas. Recibe los datos crudos de la interfaz, los procesa y decide qué estado (`RegistroState`) se debe devolver.
*   **¿Qué código tiene?** 
    *   Funciones de extensión (ej. `esMayorDeEdad()`, `esNombreValido()`).
    *   La función principal `procesarCheckIn()` que actúa como un embudo de reglas (Guard Clauses).
*   **Modifica este archivo SI EL RETO IMPLICA:**
    *   Cambiar las reglas de acceso (ej. "La edad mínima ahora es 21", "El nombre debe tener 2 palabras").
    *   Manejar datos vacíos lógicamente (ej. "Si no pone edad, que arroje un error específico").
    *   Usar *Scope Functions* como `apply` (para imprimir logs en consola al crear el asistente) o `run` / `let` (para transformar variables internamente).

## 4. `SafePassScreen.kt` (Capa de Interfaz de Usuario / UI)
*   **¿Qué hace?** Dibuja la pantalla usando Jetpack Compose. Captura lo que el usuario escribe, se lo envía a `SafePassLogic` y luego reacciona (redibuja la pantalla) dependiendo del `RegistroState` devuelto. **Además, como bien notaste, inyecta la regla de prioridad mediante la lambda**, desacoplando la lógica de la UI.
*   **¿Qué código tiene?** 
    *   Estados mutables de Compose (`remember { mutableStateOf("") }`).
    *   Componentes visuales puros (`TextField`, `Button`, `Card`, `when` exhaustivo).
*   **Modifica este archivo SI EL RETO IMPLICA:**
    *   Cambiar **quién tiene el Pase Prioritario** (esto se cambia modificando la lambda `calcularPrioridad = { ... }` que se envía en el botón).
    *   Habilitar/Deshabilitar botones dinámicamente si faltan datos (`enabled = ...`).
    *   Limpiar los campos de texto tras un registro exitoso.
    *   Mostrar nuevas cosas gráficas en la pantalla (ej. Historial con una lista - Lab 8, o contador de VIPs - Lab 9).
    *   Pintar nuevas tarjetas de colores si el estado cambia (ej. renderizar el `RegistroState.Warning`).
