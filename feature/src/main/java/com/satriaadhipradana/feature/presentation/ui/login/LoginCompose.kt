package com.satriaadhipradana.feature.presentation.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.components.OSButton
import com.satriaadhipradana.shared.theme.OnlineShopTheme

private val ls = LoginState(
    firstName = "",
    password = "ghbdtn1234",
    eyeState = false
)

@Preview
@Composable
private fun LoginWithDataPreview() {
    OnlineShopTheme { LoginContent(ls) }
}

@Preview
@Composable
private fun LoginShowPassPreview() {
    OnlineShopTheme {
        LoginContent(
            ls.copy(
                eyeState = true
            )
        )
    }
}

@Preview
@Composable
private fun LoginWithOutDataPreview() {
    OnlineShopTheme {
        LoginContent(
            ls.copy(
                firstName = (""),
                password = ("")
            )
        )
    }
}

data class LoginState(
    val firstName: String,
    val password: String,
    val eyeState: Boolean,
)

interface LoginCallback {
    
    fun onFirstNameChange(text: String)
    
    fun onPasswordChange(text: String)
    
    fun onLogin()
}

@Composable
fun LoginContent(
    state: LoginState,
    modifier: Modifier = Modifier,
    callback: LoginCallback? = null,
) {
    Column(
        modifier
            .fillMaxSize()
            .background(colorScheme.background)
            .padding(horizontal = 43.dp)
    ) {
        OSButton(stringResource(R.string.login_button)) {
            callback?.onLogin()
        }
    }
}