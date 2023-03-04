package com.satriaadhipradana.data

import com.satriaadhipradana.data.model.Product

class DataManager(private val web: WebSource) {
    
    private fun List<Product>.map() =
        this.map { it.map() }
    
    suspend fun getFlashSale() =
        web.getFlashSale().map()
    
    suspend fun getLatest() =
        web.getLatest().map()
}