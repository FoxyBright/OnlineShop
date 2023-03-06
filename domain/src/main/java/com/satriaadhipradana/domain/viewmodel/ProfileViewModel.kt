package com.satriaadhipradana.domain.viewmodel

import androidx.lifecycle.ViewModel
import com.satriaadhipradana.data.ProfileStore
import com.satriaadhipradana.shared.model.ProfileModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class ProfileViewModel(
    private val store: ProfileStore,
): ViewModel() {
    
    private val _profile = MutableStateFlow<ProfileModel?>(null)
    val profile = _profile.asStateFlow()
    
    suspend fun getProfile(){
        _profile.emit(store.getProfile())
    }
    
    fun logout(){
        store.logout()
    }
    
}