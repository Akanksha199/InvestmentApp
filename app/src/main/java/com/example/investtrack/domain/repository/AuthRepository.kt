package com.example.investtrack.domain.repository

import com.example.investtrack.domain.model.Resource

interface AuthRepository {

    suspend fun login(email: String, password: String): Resource<String>

    suspend fun signup(name: String, email: String, password: String): Resource<String>
}