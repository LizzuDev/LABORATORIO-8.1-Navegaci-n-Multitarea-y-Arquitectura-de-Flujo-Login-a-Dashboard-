package com.example.safepass2026.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
//import com.example.safepass2026.data.Asistente
import com.example.safepass2026.logic.procesarCheckIn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SafePassScreen(modifier: Modifier = Modifier) {
    // Estados locales para los campos de texto
    var nombreInput by remember { mutableStateOf("") }
    var edadInput by remember { mutableStateOf("") }
    var tipoEntradaInput by remember { mutableStateOf("General") }
    var codigoDescuentoInput by remember { mutableStateOf("") }

    // Estado reactivo que gobierna la pantalla, inicializado en Idle
    var estadoRegistro by remember { mutableStateOf<RegistroState>(RegistroState.Idle) }

    //OPCIÓN CUANDO PIDE GUARDAR LOS NOMBRES EN UNA LISTA
    //val historialAsistente = remember { mutableStateListOf<Asistente>() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("SafePass 2026 - Check-in", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Registro de Asistentes",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold
            )

            // Campo de Nombre
            OutlinedTextField(
                value = nombreInput,
                onValueChange = { nombreInput = it },
                label = { Text("Nombre Completo") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            // Campo de Edad con blindaje: configurado para teclado numérico pero protegido ante texto
            OutlinedTextField(
                value = edadInput,
                onValueChange = { edadInput = it },
                label = { Text("Edad") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            // RETO: Campo de Código de Descuento
            OutlinedTextField(
                value = codigoDescuentoInput,
                onValueChange = { codigoDescuentoInput = it },
                label = { Text("Código de Descuento (Opcional)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            // Selector simple de Entrada
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                listOf("General", "VIP", "Estudiante").forEach { tipo ->
                    FilterChip(
                        selected = tipoEntradaInput == tipo,
                        onClick = { tipoEntradaInput = tipo },
                        label = { Text(tipo) }
                    )
                }
            }

            // Botón de Procesamiento
            Button(
                
                // EL BOTÓN SOLO APARECE SI SE ESCRIBE ALGO
                //enabled = nombreInput.isNotBlank() && edadInput.isNotBlank() && tipoEntradaInput.isNotBlank(),

                onClick = {
                    // Se ejecuta la lógica de negocio pasando la lambda de cálculo de prioridad
                    estadoRegistro = procesarCheckIn(
                        nombreEntrada = nombreInput,
                        edadTexto = edadInput,
                        tipoEntrada = tipoEntradaInput,
                        codigoDescuento = codigoDescuentoInput.takeIf { it.isNotBlank() },
                        calcularPrioridad = { asistente ->
                            // Regla de negocio: Entradas VIP tienen prioridad automática
                            asistente.tipoEntrada.equals("VIP", ignoreCase = true)


                            // REGLA DOBLE VIP Y ANCIANO
                            /*
                            val esVip= asistente.tipoEntrada.equals("VIP", ignoreCase = true)
                            val esTerceraEdad=(asistente.edad ?:0)>=65
                            esVip && esTerceraEdad*/

                            // REGLA DOBLE VIP Y ESTUDIANTE
                            /*
                            val esVip= asistente.tipoEntrada.equals("VIP", ignoreCase = true)
                            val esEstudiante=(asistente.tipoEntrada.equals("Estudiante", ignoreCase = true))
                            esVip && esEstudiante*/

                            // REGLA PARA ESTUDIANTES MENORES A 25 AÑOS
                            /*
                            asistente.tipoEntrada.equals("Estudiante", ignoreCase = true) && (asistente.edad ?: 0) < 25*/
                        }
                    )

                    // SI EL RESULTADO FUE EXITOSO, LIMPIAMOS LAS VARIABLES DE ESTADO
                    /*if (estadoRegistro is RegistroState.Success) {
                        nombreInput = ""
                        edadInput = ""
                    }*/

                    //OPCIÓN PARA USAR LA LISTA DE ASISTENTES
                    /*if (estadoRegistro is RegistroState.Success) {
                        val asistenteAprobado = (estadoRegistro as RegistroState.Success).asistente
                        historialAsistente.add(asistenteAprobado) // Guarda en la lista
                    }*/


                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrar Asistente")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // RENDERIZADO REACTIVO EXHAUSTIVO MEDIANTE WHEN
            // No se utiliza rama 'else', garantizando manejo total de estados
            when (val state = estadoRegistro) {
                is RegistroState.Idle -> {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Esperando el ingreso de datos del asistente.",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
                is RegistroState.Success -> {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "ESTADO: APROBADO",
                                color = Color(0xFF2E7D32),
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = state.mensaje,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xFF1B5E20)
                            )
                            // RETO: Distintivo de Cupón Aplicado
                            if (state.asistente.codigoDescuento != null) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "¡Cupón Aplicado!",
                                    color = Color(0xFF388E3C), // Verde oscuro
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
                is RegistroState.Error -> {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "ERROR DE VALIDACIÓN",
                                color = MaterialTheme.colorScheme.onErrorContainer,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = state.causa,

                                //OPCIÓN PARA CUANDO LA CAUSA AHORA ES UNA INTERFACE
                                //text= state.error.mensaje,

                                color = MaterialTheme.colorScheme.onErrorContainer,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }

                
                // ESTADO DE CARGA
                /*
                is RegistroState.Loading -> {
                    CircularProgressIndicator()
                }*/

                                // RETO WARNING: RENDERIZADO DE LA ADVERTENCIA
                /*
                is RegistroState.Warning -> {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF9C4)), // Amarillo claro
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "ADVERTENCIA",
                                color = Color(0xFFF57F17), // Texto naranja/amarillo oscuro
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = state.mensaje,
                                color = Color(0xFFF57F17),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
                */

            }

            // --- RETO DEL LAB 9: CONTADOR DE PASES VIP ---
            // (Descomentar si el ingeniero lo pide)
            /*
            Spacer(modifier = Modifier.height(16.dp))
            val totalVip = historialAsistente.count { it.tipoEntrada.equals("VIP", ignoreCase = true) }
            Text(
                text = "Total VIPs Registrados en el historial: $totalVip",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            */
        }
    }
}