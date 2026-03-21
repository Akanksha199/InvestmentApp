package com.example.investtrack.presentation.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.investtrack.presentation.ui.components.PasswordTextField
import com.example.investtrack.presentation.ui.components.PrimaryButton
import com.example.investtrack.presentation.ui.components.PrimaryTextField

@Composable
fun SignupScreenUI(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF2962FF).copy(alpha = 0.12f),
                    Color(0xFF82B1FF).copy(alpha = 0.08f),
                    Color.White
                )
            )
        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "📈 InvestTrack",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(40.dp))

            Card(
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.95f)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(24.dp)) {

                    Text(
                        text = "Create Account 🚀",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    PrimaryTextField(
                        value = name,
                        onValueChange = { name = it },
                        placeholder = "Name"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    PrimaryTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = "Email"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    PasswordTextField(
                        value = password,
                        onValueChange = { password = it },
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    PrimaryTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        placeholder = "Confirm Password"
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    PrimaryButton(
                        text = "Sign Up",
                        onClick = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
}