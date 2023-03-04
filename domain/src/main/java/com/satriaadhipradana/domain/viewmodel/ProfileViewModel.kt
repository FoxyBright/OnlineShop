package com.satriaadhipradana.domain.viewmodel

import androidx.lifecycle.ViewModel
import com.satriaadhipradana.data.ProfileStore


class ProfileViewModel(
    store: ProfileStore,
): ViewModel() {
    
    private val profile = store.getProfile()

}