package com.satriaadhipradana.data.model

import com.satriaadhipradana.shared.model.ProductModel

data class Product(
    val category: String,
    val name: String,
    val price: Double,
    val discount: Int? = null,
    val imageUrl: String,
) {
    
    fun map() = ProductModel(
        category, name, price,
        discount, imageUrl
    )
}