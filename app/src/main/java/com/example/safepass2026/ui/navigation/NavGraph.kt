package com.example.safepass2026.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.safepass2026.ui.screens.DashboardScreen
import com.example.safepass2026.ui.screens.LoginScreen

@Composable
fun AppNavigation() {
    // 1. Instanciamos el NavController (El "conductor" de la aplicación)
    val navController = rememberNavController()

    // 2. Definimos el NavHost (El mapa de rutas)
    // startDestination define qué pantalla se carga primero.
    NavHost(navController = navController, startDestination = "auth") {

        // Destino 1: Login
        composable("auth") {
            LoginScreen(
                onLoginSuccess = {
                    // POR QUÉ: Navegamos al 'main', pero limpiamos 'auth' de la pila
                    // para que el usuario no pueda regresar con el botón físico "Atrás".
                    navController.navigate("main") {
                        popUpTo("auth") { inclusive = true }
                    }
                }
            )
        }

        // Destino 2: Dashboard
        composable("main") {
            DashboardScreen(
                onLogout = {
                    navController.navigate("auth") {
                        popUpTo("main") { inclusive = true } // Destruye el dashboard
                    }
                }
            )
        }
    }
}
