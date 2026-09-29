package com.example.safepass2026.ui

import com.example.safepass2026.data.Asistente
/**
 * Jerarquía sellada que modela de forma finita y exhaustiva
 * todos los estados posibles de la interfaz de registro.
 */

sealed class RegistroState {

    // AUMENTAR UN ESTADO O MODIFICAR UNO EXISTENTE

    /** Estado inicial pasivo: el usuario aún no interactúa con el botón de registro. */
    data object Idle : RegistroState()

    /**
     * Estado exitoso: validación completada y reglas de negocio superadas.
     *
     * @property asistente Objeto con los datos consolidados.
     * @property pasePrioritario Booleano calculado por la función de orden superior.
     * @property mensaje Resumen legible generado mediante plantillas de cadena.
     */
    data class Success(
        val asistente: Asistente,
        val pasePrioritario: Boolean,
        val mensaje: String
    ) : RegistroState()

    /**
     * Estado de error controlado: datos incompletos o reglas no cumplidas.
     *
     * @property causa Descripción clara del error que se mostrará al usuario.
     */
    data class Error(val causa: String) : RegistroState()


    // ESTADO DE CARGA
    // data object Loading : RegistroState()

    /*ESTADO DE ADVERTENCIA PARA CAMPOS VACIOS
    data class Warning(val mensaje:String) : RegistroState()
    */
}



/*Aumento de una sealed interface para que Error lo herede*/
/*
sealed interface ValidacionError{
    val mensaje: String
}

data class NombreInvalido(override val mensaje: String) : ValidacionError
data class EdadInvalida(override val mensaje: String) : ValidacionError
data class TipoEntradaInvalido(override val mensaje: String) : ValidacionError

sealed class RegistroState{
    data object Idle : RegistroState()
    data class Success(
        val asistente: Asistente,
        val pasePrioritario: Boolean,
        val mensaje: String ) : RegistroState()
    data class Error (val error: ValidacionError) : RegistroState()
}
*/
