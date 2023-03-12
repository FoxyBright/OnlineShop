package com.satriaadhipradana.feature.presentation.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satriaadhipradana.feature.presentation.ui.login.LoginScreenType.LOGIN
import com.satriaadhipradana.feature.presentation.ui.login.LoginScreenType.SIGN_IN
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.theme.ExtraType
import com.satriaadhipradana.shared.theme.OnlineShopTheme

private val ls = LoginState(
    firstName = "",
    lastName = "IVANOV",
    password = "ghbdtn1234",
    eyeState = false,
    email = "email@gmail.com",
    type = LOGIN
)

@Preview
@Composable
private fun LoginPreview() {
    OnlineShopTheme { LoginContent(ls) }
}

@Preview
@Composable
private fun SignInPreview() {
    OnlineShopTheme {
        LoginContent(
            ls.copy(type = SIGN_IN)
        )
    }
}

enum class LoginScreenType { LOGIN, SIGN_IN }
enum class ExternalType { APPLE, GOOGLE }

data class LoginState(
    val firstName: String,
    val lastName: String,
    val password: String,
    val email: String,
    val eyeState: Boolean,
    val type: LoginScreenType,
)

interface LoginCallback {
    
    fun onFirstNameChange(text: String)
    fun onLastNameChange(text: String)
    fun onEmailChange(text: String)
    fun onPasswordChange(text: String)
    fun onExternalsClick(type: ExternalType)
    fun onEyeStateChange()
    fun onLogin()
    fun onSubTextClick()
}

@Composable
fun LoginContent(
    state: LoginState,
    modifier: Modifier = Modifier,
    callback: LoginCallback? = null,
) {
    val focusManager = LocalFocusManager.current
    Column(
        modifier
            .fillMaxSize()
            .background(colorScheme.background)
            .padding(horizontal = 43.dp)
            .clickable(
                MutableInteractionSource(), (null)
            ) { focusManager.clearFocus() },
    ) {
        Box(Modifier.weight(0.9f), Center) {
            Text(
                stringResource(
                    when(state.type) {
                        LOGIN -> R.string.login_title
                        SIGN_IN -> R.string.sign_in_title
                    }
                ), Modifier.fillMaxWidth(),
                style = ExtraType.loginTitle.copy(
                    textAlign = TextAlign.Center
                )
            )
        }
        Box(Modifier.weight(1f), Center) {
            LoginFields(
                state, callback,
                Modifier.align(TopCenter)
            )
            LoginButtons(
                Modifier.align(BottomCenter),
                state.type, { callback?.onLogin() }
            ) { callback?.onSubTextClick() }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f), Center
        ) {
            if(state.type == SIGN_IN) LoginExternals()
            { callback?.onExternalsClick(it) }
        }
    }
}