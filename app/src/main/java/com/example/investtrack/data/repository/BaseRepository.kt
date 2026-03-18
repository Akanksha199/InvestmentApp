package com.example.investtrack.data.repository

import com.example.investtrack.domain.model.Resource

open class BaseRepository {

    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Resource<T> {
        return try {
            Resource.Success(apiCall())
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Something went wrong")
        }
    }
}