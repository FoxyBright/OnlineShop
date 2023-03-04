package com.satriaadhipradana.data

import android.content.Context
import androidx.preference.PreferenceManager.getDefaultSharedPreferences
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.module.kotlin.jsonMapper
import com.fasterxml.jackson.module.kotlin.kotlinModule
import com.satriaadhipradana.shared.model.ProfileModel

class ProfileStore(context: Context) {
    
    private val preference = getDefaultSharedPreferences(context)
    private val builder = preference.edit()
    
    private val mapper = jsonMapper {
        propertyNamingStrategy(SnakeCaseStrategy())
        addModule(kotlinModule())
    }
    
    fun saveProfile(profile: ProfileModel) {
        builder.putString("profile", profile.toString())
    }
    
    fun getProfile() = mapper.readValue(
        preference.getString("profile", ""),
        ProfileModel::class.java
    ) ?: null
}