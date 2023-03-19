package com.satriaadhipradana.data.manager

import com.satriaadhipradana.data.model.Product
import com.satriaadhipradana.data.source.WebSource

class DataManager(private val web: WebSource) {
    
    private fun List<Product>.map() =
        this.map { it.map() }
    
    suspend fun getFlashSale() =
        web.getFlashSale().map()
    
    suspend fun getLatest() =
        web.getLatest().map()
    
    suspend fun getProduct() =
        web.getProduct()
    
    suspend fun search() =
        web.search()
}