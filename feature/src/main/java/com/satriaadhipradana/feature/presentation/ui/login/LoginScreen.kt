package com.satriaadhipradana.feature.presentation.ui.login

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.satriaadhipradana.domain.viewmodel.LoginViewModel
import com.satriaadhipradana.feature.presentation.ui.login.ExternalType.APPLE
import com.satriaadhipradana.feature.presentation.ui.login.ExternalType.GOOGLE
import com.satriaadhipradana.feature.presentation.ui.login.LoginScreenType.LOGIN
import com.satriaadhipradana.feature.presentation.ui.login.LoginScreenType.SIGN_IN
import com.satriaadhipradana.shared.extensions.emailControl
import com.satriaadhipradana.shared.extensions.makeToast
import com.satriaadhipradana.shared.extensions.openInWeb
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    vm: LoginViewModel,
    nav: NavHostController,
) {
    
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    
    val authorized by vm.authorized.collectAsState()
    val firstName by vm.firstName.collectAsState()
    val eyeState by vm.eyeState.collectAsState()
    val lastName by vm.lastName.collectAsState()
    val password by vm.password.collectAsState()
    val email by vm.email.collectAsState()
    
    val loginControl = firstName.isNotBlank()
            && (if(!authorized) emailControl(email)
            && lastName.isNotBlank()
    else password.isNotBlank())
    
    LoginContent(
        LoginState(
            firstName, lastName,
            password, email, eyeState,
            if(authorized) LOGIN else SIGN_IN
        ), Modifier, object: LoginCallback {
            override fun onFirstNameChange(text: String) {
                scope.launch { vm.changeFirstName(text) }
            }
            
            override fun onLastNameChange(text: String) {
                scope.launch { vm.changeLastName(text) }
            }
            
            override fun onEmailChange(text: String) {
                scope.launch { vm.changeEmail(text) }
            }
            
            override fun onSubTextClick() {
                scope.launch { vm.changeAuthorized() }
            }
            
            override fun onEyeStateChange() {
                scope.launch { vm.eyeStateChange() }
            }
            
            override fun onPasswordChange(text: String) {
                scope.launch { vm.changePassword(text) }
            }
            
            override fun onExternalsClick(type: ExternalType) {
                openInWeb(
                    context, when(type) {
                        APPLE -> "https://www.apple.com"
                        GOOGLE -> "https://www.google.com"
                    }
                )
                nav.navigate("pageOne")
            }
            
            override fun onLogin() {
                scope.launch {
                    if(loginControl) {
                        if(authorized) {
                            vm.login()
                            nav.navigate("profile")
                        } else {
                            vm.register()
                            nav.navigate("profile")
                        }
                    } else makeToast(
                        context, ("Invalid entered data")
                    )
                }
            }
        }
    )
}