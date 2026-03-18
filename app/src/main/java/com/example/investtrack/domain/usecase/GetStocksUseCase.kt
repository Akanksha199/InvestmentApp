package com.example.investtrack.domain.usecase

import com.example.investtrack.domain.model.Stock
import com.example.investtrack.domain.repository.StockRepository

class GetStocksUseCase(
    private val repository: StockRepository
) {
    suspend operator fun invoke(): List<Stock> {
        return repository.getStocks()
    }
}