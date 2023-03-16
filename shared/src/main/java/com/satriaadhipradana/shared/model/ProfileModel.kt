package com.satriaadhipradana.shared.model

import java.io.File
import java.util.UUID.randomUUID

data class ProfileModel(
    val id: String,
    val name: String,
    val email: String,
    val balance: Int,
    val avatar: File? = null,
)

val DemoProfileModel = ProfileModel(
    id = randomUUID().toString(),
    name = "Satria Adhi Pradana",
    email = "satria.adhi.pradana@gmail.com",
    balance = 1593,
)
