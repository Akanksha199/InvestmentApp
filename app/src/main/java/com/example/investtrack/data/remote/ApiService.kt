package com.example.investtrack.data.remote

import com.example.investtrack.domain.model.Stock
import retrofit2.http.GET

interface ApiService {

    @GET("stocks")
    suspend fun getStocks(): List<Stock>
}