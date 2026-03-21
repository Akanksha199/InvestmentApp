package com.example.investtrack.domain.usecase


import com.example.investtrack.domain.model.Resource
import com.example.investtrack.domain.repository.AuthRepository
import kotlinx.coroutines.delay

class SignupUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        name: String,
        email: String,
        password: String
    ): Resource<String> {
        return repository.signup(name, email, password)
    }
}