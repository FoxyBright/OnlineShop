package com.satriaadhipradana.data.model

data class LatestResponse(
    val latest: List<Product>,
) {
    
    fun map() = latest
}