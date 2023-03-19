package com.satriaadhipradana.shared.model

import java.util.UUID.randomUUID

data class ProfileModel(
    val id: String,
    val name: String,
    val email: String,
    val balance: Int,
    val avatar: String? = null,
)

val DemoProfileModel = ProfileModel(
    id = randomUUID().toString(),
    name = "Satria Adhi Pradana",
    email = "satria.adhi.pradana@gmail.com",
    balance = 1593,
)
