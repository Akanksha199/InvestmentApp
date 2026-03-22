package com.example.investtrack.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.investtrack.data.repository.AuthRepositoryImpl
import com.example.investtrack.domain.model.Resource
import com.example.investtrack.domain.usecase.LoginUseCase
import com.example.investtrack.domain.usecase.SignupUseCase
import com.example.investtrack.presentation.state.AuthUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class AuthViewModel : ViewModel() {

    private val _state = MutableStateFlow(AuthUiState())
    val state: StateFlow<AuthUiState> = _state
    private val repository = AuthRepositoryImpl()

    private val loginUseCase = LoginUseCase(repository)
    private val signupUseCase = SignupUseCase(repository)

    fun login(email: String, password: String) {

        // 🔹 Email validation
        if (email.isBlank()) {
            _state.value = AuthUiState(error = "Email is required")
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _state.value = AuthUiState(error = "Invalid email format")
            return
        }

        // 🔹 Password validation
        if (password.isBlank()) {
            _state.value = AuthUiState(error = "Password is required")
            return
        }

        if (password.length < 6) {
            _state.value = AuthUiState(error = "Password must be at least 6 characters")
            return
        }

        viewModelScope.launch {
            _state.value = AuthUiState(isLoading = true)

            val result = loginUseCase(email, password)

            _state.value = when (result) {
                is Resource.Success -> AuthUiState(isSuccess = true)
                is Resource.Error -> AuthUiState(error = result.message)
                else -> { AuthUiState() }
            }
        }
    }

    fun signup(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {

        if (name.isBlank()) {
            _state.value = AuthUiState(error = "Name is required")
            return
        }

        if (email.isBlank()) {
            _state.value = AuthUiState(error = "Email is required")
            return
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _state.value = AuthUiState(error = "Invalid email format")
            return
        }

        if (password.length < 6) {
            _state.value = AuthUiState(error = "Password must be at least 6 characters")
            return
        }

        if (password != confirmPassword) {
            _state.value = AuthUiState(error = "Passwords do not match")
            return
        }

        viewModelScope.launch {
            _state.value = AuthUiState(isLoading = true)

            val result = signupUseCase(name, email, password)

            _state.value = when (result) {
                is Resource.Success -> AuthUiState(isSuccess = true)
                is Resource.Error -> AuthUiState(error = result.message)
                else -> { AuthUiState() }
            }
        }
    }
}