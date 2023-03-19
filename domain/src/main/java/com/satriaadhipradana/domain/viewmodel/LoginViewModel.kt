package com.satriaadhipradana.domain.viewmodel

import androidx.lifecycle.ViewModel
import com.satriaadhipradana.data.repository.ProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class LoginViewModel(
    private val store: ProfileRepository,
): ViewModel() {
    
    private val _firstName = MutableStateFlow("")
    val firstName = _firstName.asStateFlow()
    
    private val _lastName = MutableStateFlow("")
    val lastName = _lastName.asStateFlow()
    
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()
    
    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()
    
    private val _eyeState = MutableStateFlow(false)
    val eyeState = _eyeState.asStateFlow()
    
    private val _authorized = MutableStateFlow(false)
    val authorized = _authorized.asStateFlow()
    
    suspend fun changeAuthorized() {
        _authorized.emit(!authorized.value)
    }
    
    suspend fun changeLastName(text: String) {
        _lastName.emit(text)
    }
    
    suspend fun changeEmail(text: String) {
        _email.emit(text)
    }
    
    suspend fun eyeStateChange() {
        _eyeState.emit(!eyeState.value)
    }
    
    suspend fun changePassword(text: String) {
        _password.emit(text)
    }
    
    suspend fun changeFirstName(text: String) {
        _firstName.emit(text)
    }
    
    fun register() =
        store.checkRegister(
            firstName.value,
            password.value
        )?.let {
            store.register(
                firstName.value,
                lastName.value,
                email.value,
                password.value,
            )
        }
    
    
    fun externalLogin() = store.externalLogin()
    
    fun login() = store.login(
        firstName.value,
        password.value
    )
}