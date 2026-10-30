package com.example.safepass2026.logic

import com.example.safepass2026.data.Asistente
import com.example.safepass2026.ui.RegistroState

fun Int?.esMayorDeEdad(): Boolean {
    return (this ?: 0) >= 18
}

fun String.esNombreValido(): Boolean {
    return this.isNotBlank() && this.length >= 3 // && !this.equals("prueba", ignoreCase = true) // OTRA CONDICIÓN
                                                // QUE TENGA NOMBRE Y APELLIDO // && this.trim().contains(" ")

}

// EDAD EN RANGO
/*
fun Int?.esEdadValida(): Boolean {
    return (this ?:0) <100 && (this ?:0)>=18
}*/



fun procesarCheckIn(
    nombreEntrada: String,
    edadTexto: String,
    tipoEntrada: String,
    codigoDescuento: String?,
    // email: String,
    calcularPrioridad: (Asistente) -> Boolean //la interfaz tiene la lógica del lambda
): RegistroState {

    val edadSegura: Int? = edadTexto.trim().toIntOrNull()

    if (!nombreEntrada.esNombreValido()) {
        return RegistroState.Error("El nombre ingresado es inválido. Debe contener al menos 3 caracteres.")
    }

    
    if (!edadSegura.esMayorDeEdad()) {
        return RegistroState.Error("Acceso denegado: El evento es exclusivo para mayores de 18 años.")
    }

    
    // RETO WARNING: SI TODO ESTÁ VACÍO, ES UNA ADVERTENCIA, NO UN ERROR CRÍTICO
    /*
    if (nombreEntrada.isBlank() && edadTexto.isBlank()) {
        return RegistroState.Warning("Por favor, llena los campos antes de registrar.")
    }
    */


    // OPCIÓN PARA CUANDO LA EDAD ES NULA
    /*
    if (edadSegura == null) {
        return RegistroState.Error("Debe ingresar un formato numérico válido para la edad.")
    }*/
    
    // EDAD EN EL RANGO PERMITIDO
    /*
    if(edadSegura.esEdadValida()){
        return RegistroState.Error("La edad ingresada es inválida. Debe estar entre 18 y 99.")
    }*/

    // VALIDACIÓN DE EMAIL
    /*
    if(!email.contains("@")){
        return RegistroState.Error("El email ingresado es inválido.")
    }*/

    

    val nuevoAsistente = Asistente(
        nombre = nombreEntrada.trim(),
        edad = edadSegura,
        tipoEntrada = tipoEntrada,
        codigoDescuento = codigoDescuento
        // NO OLVIDES LA COMA, email = email
    ).apply {
        // REPASAR APLICAR ALGO EN ESTE APPLY
        /*
        println("DEBUG: Se ha instanciado un nuevo asistente en memoria con el nombre: $nombre y edad: $edad")
         */
    }

    // RETO: USO DE .LET PARA TRANSFORMAR A MAYÚSCULAS SI HAY CÓDIGO
    val asistenteFinal = nuevoAsistente.codigoDescuento?.let {
        nuevoAsistente.copy(nombre = nuevoAsistente.nombre.uppercase())
    } ?: nuevoAsistente

    val resumenEdad: String = asistenteFinal.edad?.let { edadNoNula -> "Edad: $edadNoNula" } ?: "Edad no disponible"

    return asistenteFinal.run {
        val tienePrioridad = calcularPrioridad(this)
        val resumen = "¡Registro exitoso! $nombre | $tipoEntrada | $resumenEdad | Prioridad: ${if (tienePrioridad) "ALTA" else "ESTÁNDAR"}"

        RegistroState.Success(asistente = this, pasePrioritario = tienePrioridad, mensaje = resumen)
    }
}
