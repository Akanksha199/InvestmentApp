package com.example.investtrack.domain.usecase


import com.example.investtrack.domain.model.Resource
import com.example.investtrack.domain.repository.AuthRepository
import kotlinx.coroutines.delay
class LoginUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        email: String,
        password: String
    ): Resource<String> {
        return repository.login(email, password)
    }
}