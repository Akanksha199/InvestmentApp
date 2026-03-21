package com.example.investtrack.data.repository


import com.example.investtrack.domain.model.Resource
import com.example.investtrack.domain.repository.AuthRepository
import kotlinx.coroutines.delay

class AuthRepositoryImpl : AuthRepository {

    override suspend fun login(email: String, password: String): Resource<String> {

        delay(1500)

        return if (email == "test@gmail.com" && password == "123456") {
            Resource.Success("Akanksha")
        } else {
            Resource.Error("Invalid credentials")
        }
    }

    override suspend fun signup(
        name: String,
        email: String,
        password: String
    ): Resource<String> {

        delay(1500)

        return if (name.isNotBlank() && email.isNotBlank() && password.isNotBlank()) {
            Resource.Success(name)
        } else {
            Resource.Error("Invalid input")
        }
    }
}