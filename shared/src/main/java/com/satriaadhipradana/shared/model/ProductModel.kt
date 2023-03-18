package com.satriaadhipradana.shared.model

import androidx.compose.ui.graphics.Color

data class ProductModel(
    val category: String,
    val name: String,
    val price: Float,
    val discount: Int? = null,
    val imageUrl: String,
)

data class FullProductModel(
    val name: String,
    val description: String,
    val rating: Float,
    val reviews: Int,
    val price: Float,
    private val colorList: List<Int>,
    val imageUrls: List<String>,
) {
    
    val colors = colorList.map {
        Color(it)
    }
}

val DemoProductModel = ProductModel(
    category = "Phones",
    name = "Samsung S10",
    price = 180.0f,
    discount = 30,
    imageUrl = ""
)

val DemoProductModelList = listOf(
    DemoProductModel,
    DemoProductModel,
    DemoProductModel,
    DemoProductModel,
    DemoProductModel,
    DemoProductModel,
)