package com.satriaadhipradana.shared.model

import java.util.UUID.randomUUID

data class ProfileModel(
    val id: String,
    val name: String,
    val email: String,
    val balance: Double,
)

val DemoProfileModel = ProfileModel(
    id = randomUUID().toString(),
    name = "Stria Adi Prada",
    email = "stria.adi.prada@gmail.com",
    balance = 1593.0
)
