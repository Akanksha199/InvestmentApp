package com.example.investtrack.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.investtrack.presentation.ui.DashboardScreen
import com.example.investtrack.presentation.ui.InvestSplashScreen
import com.example.investtrack.presentation.ui.auth.LoginScreenUI
import com.example.investtrack.presentation.ui.auth.SignupScreenUI
import com.example.investtrack.presentation.ui.auth.SplashScreenUI

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Splash.route
    ) {

        composable(Routes.Splash.route) {
            SplashScreenUI(navController)
        }

        composable(Routes.Login.route) {
            LoginScreenUI(navController)
        }

        composable(Routes.Dashboard.route) {
            DashboardScreen()
        }

        composable(Routes.Signup.route) {
            SignupScreenUI(navController)
        }
    }
}