package com.satriaadhipradana.data.model

data class FlashSaleResponse(
    val flashSale: List<Product>,
) {
    
    fun map() = flashSale
}