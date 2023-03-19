package com.satriaadhipradana.domain.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.satriaadhipradana.data.repository.ProfileRepository
import com.satriaadhipradana.shared.model.ProfileModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class ProfileViewModel(
    private val store: ProfileRepository,
): ViewModel() {
    
    private val _profile = MutableStateFlow<ProfileModel?>(null)
    val profile = _profile.asStateFlow()
    
    fun updatePhoto(uri: Uri?) {
        store.updatePhoto(uri)
    }
    
    suspend fun getProfile() {
        _profile.emit(store.getProfile())
    }
    
    fun logout() {
        store.logout()
    }
}