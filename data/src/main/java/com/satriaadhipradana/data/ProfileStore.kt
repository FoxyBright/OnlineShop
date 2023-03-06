package com.satriaadhipradana.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.satriaadhipradana.shared.model.ProfileModel


class ProfileStore(context: Context) {
    
    private val key = "profile"
    private var preference = context
        .getSharedPreferences(key, MODE_PRIVATE)
    private var editor = preference.edit()
    
    private val mapper = jsonMapper {
        propertyNamingStrategy(SnakeCaseStrategy())
        addModule(kotlinModule())
    }
    
    fun saveProfile(profile: ProfileModel) {
        editor.putString(
            key, mapper.writeValueAsString(profile)
        ).apply()
    }
    
    fun isAuthorized() = getProfile() != null
    
    fun logout() {
        editor.remove(key).apply()
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