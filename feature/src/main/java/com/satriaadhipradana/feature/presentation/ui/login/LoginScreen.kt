package com.satriaadhipradana.feature.presentation.ui.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.satriaadhipradana.domain.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    vm: LoginViewModel,
    nav: NavHostController,
) {
    
    val scope = rememberCoroutineScope()
    
    val firstName = ""
    val password = ""
    val eyeState = false
    
    LoginContent(
        LoginState(
            firstName, password, eyeState
        ), Modifier, object: LoginCallback {
            override fun onFirstNameChange(text: String) {
            }
            
            override fun onPasswordChange(text: String) {
            }
            
            override fun onLogin() {
                scope.launch {
                    vm.login()
                    nav.navigate("profile")
                }
            }
        }
    )
}