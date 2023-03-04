package com.satriaadhipradana.data.model

import com.satriaadhipradana.shared.model.ProfileModel

data class Profile(
    val id: String,
    val name: String,
    val email: String,
    val balance: Double
){
    fun map() = ProfileModel(
        id, name, email, balance
    )
}