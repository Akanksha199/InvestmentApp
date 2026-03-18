package com.example.investtrack.domain.repository

import com.example.investtrack.domain.model.Stock

interface StockRepository {
    suspend fun getStocks(): List<Stock>
}