package com.example.investtrack.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.investtrack.presentation.navigation.Routes

@Composable
fun LoginScreen(navController: NavController) {

    Column {
        Text("Login Screen")

        Button(onClick = {
            navController.navigate(Routes.Dashboard.route)
        }) {
            Text("Go to Dashboard")
        }
    }
}