package com.example.investtrack.domain.usecase


import com.example.investtrack.domain.model.Resource
import kotlinx.coroutines.delay

class SignupUseCase {

    suspend operator fun invoke(
        name: String,
        email: String,
        password: String
    ): Resource<Boolean> {

        delay(1500)

        return if (name.isNotBlank() && email.isNotBlank() && password.isNotBlank()) {
            Resource.Success(true)
        } else {
            Resource.Error("Invalid input")
        }
    }
}