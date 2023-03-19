package com.satriaadhipradana.shared.model

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt

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
    private val colorList: List<String>,
    val images: List<String>,
) {
    
    val colors = colorList.map {
        Color(it.toColorInt())
    }
}

val DemoFullProductModel = FullProductModel(
    name = "New balance Sneakers",
    description = "Features waterproof, fire, air " +
            "resistant shoes. all changed when " +
            "the country of fire attacked",
    rating = 3.9f,
    reviews = 4000,
    price = 22.50f,
    colorList = listOf(
        "#ffffff",
        "#b5b5b5",
        "#000000"
    ),
    images = emptyList()
)

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