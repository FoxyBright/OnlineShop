package com.satriaadhipradana.data.repository

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.net.Uri
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.satriaadhipradana.shared.model.DemoProfileModel
import com.satriaadhipradana.shared.model.ProfileModel


class ProfileRepository(
    context: Context,
) {
    
    private val realmObj = ProfileRealm()
    
    private val key = "profile"
    private var preference = context
        .getSharedPreferences(key, MODE_PRIVATE)
    private var editor = preference.edit()
    
    private val mapper = jsonMapper {
        propertyNamingStrategy(SnakeCaseStrategy())
        addModule(kotlinModule())
    }
    
    private fun saveProfile(profile: ProfileModel) {
        editor.putString(
            key, mapper.writeValueAsString(profile)
        ).apply()
    }
    
    fun register(
        firstname: String,
        lastname: String,
        email: String,
        password: String,
    ) = realmObj.register(
        firstname, lastname,
        email, password
    )?.also { saveProfile(it) }
    
    fun checkRegister(
        name: String,
        password: String,
    ) = realmObj.findProfile(
        name, password
    )
    
    fun login(
        name: String,
        password: String,
    ) = checkRegister(name, password)
        ?.also { saveProfile(it) }
    
    fun isAuthorized() = getProfile() != null
    
    fun logout() {
        editor.remove(key).apply()
    }
    
    fun externalLogin(): ProfileModel {
        saveProfile(DemoProfileModel)
        return DemoProfileModel
    }
    
    fun updatePhoto(uri: Uri?) {
        val path = "$uri"
        val profile = getProfile()
        realmObj.updatePhoto(
            path, profile?.name
                ?.substringBefore(" ")
        )
        profile?.let {
            logout()
            saveProfile(it.copy(avatar = path))
        }
    }
    
    fun getProfile() = try {
        mapper.readValue(
            preference.getString(key, null),
            ProfileModel::class.java
        )
    } catch(e: Exception) {
        e.stackTraceToString()
        null
    }
}