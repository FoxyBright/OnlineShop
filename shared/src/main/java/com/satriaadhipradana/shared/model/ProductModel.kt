package com.satriaadhipradana.shared.model

data class ProductModel(
    val category: String,
    val name: String,
    val price: Double,
    val discount: Int? = null,
    val imageUrl: String,
)