package com.example.safepass2026.logic

import com.example.safepass2026.data.Asistente
import com.example.safepass2026.ui.RegistroState

fun Int?.esMayorDeEdad(): Boolean {
    return (this ?: 0) >= 18
}

fun String.esNombreValido(): Boolean {
    return this.isNotBlank() && this.length >= 3 // && !THIS.EQUALS("PRUEBA", IGNORECASE = TRUE) // OTRA CONDICIÓN
                                                // QUE TENGA NOMBRE Y APELLIDO // && THIS.TRIM().CONTAINS(" ")

}
// EDAD EN RANGO
/*
fun Int?.esEdadValida(): Boolean {
    return (this ?:0) <100
}*/



fun procesarCheckIn(
    nombreEntrada: String,
    edadTexto: String,
    tipoEntrada: String,
    // EMAIL: STRING,
    calcularPrioridad: (Asistente) -> Boolean //la interfaz tiene la lógica del lambda
): RegistroState {

    val edadSegura: Int? = edadTexto.trim().toIntOrNull()

    if (!nombreEntrada.esNombreValido()) {
        return RegistroState.Error("El nombre ingresado es inválido. Debe contener al menos 3 caracteres.")
    }

    // OPCIÓN PARA CUANDO LA EDAD ES NULA
    /*
    if (edadSegura == null) {
        return RegistroState.Error("Debe ingresar un formato numérico válido para la edad.")
    }*/


    if (!edadSegura.esMayorDeEdad()) {
        return RegistroState.Error("Acceso denegado: El evento es exclusivo para mayores de 18 años.")
    }

    // EDAD EN EL RANGO PERMITIDO
    /*
    if(edadSegura.esEdadValida()){
        return RegistroState.Error("La edad ingresada es inválida. Debe estar entre 0 y 100.")
    }*/

    // VALIDACIÓN DE EMAIL
    /*
    if(!email.contains("@")){
        return RegistroState.Error("El email ingresado es inválido.")
    }*/

    val nuevoAsistente = Asistente(
        nombre = nombreEntrada.trim(),
        edad = edadSegura,
        tipoEntrada = tipoEntrada
        // NO OLVIDES LA COMA, EMAIL = EMAIL
    ).apply {
        // REPASAR APLICAR ALGO EN ESTE APPLY
        /*
        println("DEBUG: Se ha instanciado un nuevo asistente en memoria con el nombre: $nombre y edad: $edad")
         */
    }

    val resumenEdad: String = nuevoAsistente.edad?.let { edadNoNula -> "Edad: $edadNoNula" } ?: "Edad no disponible"

    return nuevoAsistente.run {
        val tienePrioridad = calcularPrioridad(this)
        val resumen = "¡Registro exitoso! $nombre | $tipoEntrada | $resumenEdad | Prioridad: ${if (tienePrioridad) "ALTA" else "ESTÁNDAR"}"

        // DEVOLVER EL RESULTADO CON NOMBRE EN MAYÚSCULAS
        // UTILIZAMOS THIS.NOMBRE.UPPERCASE() DENTRO DEL RUN
        //val resumen = "¡Registro exitoso! ${this.nombre.uppercase()} | $tipoEntrada | $resumenEdad | Prioridad: ${if (tienePrioridad) "ALTA" else "ESTÁNDAR"}"

        RegistroState.Success(asistente = this, pasePrioritario = tienePrioridad, mensaje = resumen)
    }
}
