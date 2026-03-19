package com.example.investtrack.presentation.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.investtrack.presentation.ui.DashboardScreen
import com.example.investtrack.presentation.ui.InvestSplashScreen
import com.example.investtrack.presentation.ui.LoginScreen

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Splash.route
    ) {

        composable(Routes.Splash.route) {
            InvestSplashScreen(navController)
        }

        composable(Routes.Login.route) {
            LoginScreen(navController)
        }

        composable(Routes.Dashboard.route) {
            DashboardScreen()
        }
    }
}