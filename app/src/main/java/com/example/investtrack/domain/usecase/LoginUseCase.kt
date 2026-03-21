package com.example.investtrack.domain.usecase


import com.example.investtrack.domain.model.Resource
import kotlinx.coroutines.delay

class LoginUseCase {

    suspend operator fun invoke(
        email: String,
        password: String
    ): Resource<Boolean> {

        delay(1500) // simulate API

        return if (email == "test@test.com" && password == "1234") {
            Resource.Success(true)
        } else {
            Resource.Error("Invalid credentials")
        }
    }
}