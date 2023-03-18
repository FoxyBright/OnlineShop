package com.satriaadhipradana.data.model

import android.graphics.Color
import com.satriaadhipradana.shared.model.FullProductModel
import com.satriaadhipradana.shared.model.ProductModel

data class Product(
    val category: String,
    val name: String,
    val price: Float,
    val discount: Int? = null,
    val imageUrl: String,
) {
    
    fun map() = ProductModel(
        category, name, price,
        discount, imageUrl
    )
}

data class FullProduct(
    val name: String,
    val description: String,
    val rating: Float,
    val numberOfReviews: Int,
    val price: Float,
    val colors: List<String>,
    val imageUrls: List<String>,
) {
    
    fun map() = FullProductModel(
        name, description, rating,
        numberOfReviews,
        price, colors.map {
            Color.parseColor(it)
        }, imageUrls
    )
}