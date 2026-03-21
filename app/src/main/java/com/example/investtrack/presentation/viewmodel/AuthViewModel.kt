package com.example.investtrack.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.investtrack.presentation.state.AuthUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class AuthViewModel : ViewModel() {

    private val _state = MutableStateFlow(AuthUiState())
    val state: StateFlow<AuthUiState> = _state

    fun login(email: String, password: String) {

        // 🔹 Validation
        if (email.isBlank() || password.isBlank()) {
            _state.value = AuthUiState(
                error = "Fields cannot be empty"
            )
            return
        }

        viewModelScope.launch {

            // 🔹 Show loading
            _state.value = AuthUiState(isLoading = true)

            delay(1500) // simulate API

            // 🔹 Fake success (for now)
            _state.value = AuthUiState(isSuccess = true)
        }
    }
}