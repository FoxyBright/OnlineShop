package com.satriaadhipradana.shared.model

import com.satriaadhipradana.shared.R

data class CategoryModel(
    val name: Int,
    val icon: Int,
) {
    
    companion object {
        
        val list = listOf(
            CategoryModel(R.string.categories_phones, R.drawable.ic_phone_category),
            CategoryModel(R.string.categories_headphones, R.drawable.ic_headphones_category),
            CategoryModel(R.string.categories_games, R.drawable.ic_games_category),
            CategoryModel(R.string.categories_cars, R.drawable.ic_cars_category),
            CategoryModel(R.string.categories_furniture, R.drawable.ic_furniture_category),
            CategoryModel(R.string.categories_kids, R.drawable.ic_kids_category),
        )
    }
}