package com.example.investtrack.presentation.navigation

sealed class Routes(val route: String) {
    object Splash : Routes("splash")
    object Login : Routes("login")
    object Dashboard : Routes("dashboard")
}