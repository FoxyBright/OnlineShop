package com.satriaadhipradana.data

class DataManager(private val web: WebSource) {
    
    suspend fun getFlashSale() =
        web.getFlashSale()
    
    suspend fun getLatest() =
        web.getLatest()
}