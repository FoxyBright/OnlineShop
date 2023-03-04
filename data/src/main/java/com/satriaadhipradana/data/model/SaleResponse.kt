package com.satriaadhipradana.data.model

data class SaleResponse(
    val flashSale: List<Product>,
) {
    
    fun map() = flashSale
}