package com.satriaadhipradana.domain.viewmodel

import androidx.lifecycle.ViewModel
import com.satriaadhipradana.data.ProfileStore
import com.satriaadhipradana.shared.model.DemoProfileModel


class LoginViewModel(
    private val store: ProfileStore,
): ViewModel() {
    
    fun login() {
        store.saveProfile(DemoProfileModel)
    }
}