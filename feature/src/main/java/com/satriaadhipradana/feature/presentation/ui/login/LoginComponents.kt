package com.satriaadhipradana.feature.presentation.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.satriaadhipradana.feature.presentation.ui.login.ExternalType.APPLE
import com.satriaadhipradana.feature.presentation.ui.login.ExternalType.GOOGLE
import com.satriaadhipradana.feature.presentation.ui.login.LoginScreenType.LOGIN
import com.satriaadhipradana.feature.presentation.ui.login.LoginScreenType.SIGN_IN
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.components.OSButton
import com.satriaadhipradana.shared.components.OSTextField
import com.satriaadhipradana.shared.theme.ExtraType.Companion.external
import com.satriaadhipradana.shared.theme.ExtraType.Companion.hasAccount
import com.satriaadhipradana.shared.theme.LightBlue
import com.satriaadhipradana.shared.theme.LightGray

@Composable
fun LoginFields(
    state: LoginState,
    callback: LoginCallback? = null,
    modifier: Modifier,
) {
    Column(modifier) {
        OSTextField(
            state.firstName,
            stringResource(R.string.first_name_placeholder),
            Modifier.padding(bottom = 35.dp)
        ) { callback?.onFirstNameChange(it) }
        when(state.type) {
            LOGIN -> OSTextField(
                state.password,
                stringResource(R.string.password_placeholder),
                Modifier, state.eyeState, (true),
                { callback?.onEyeStateChange() }
            ) { callback?.onPasswordChange(it) }
            
            SIGN_IN -> OSTextField(
                state.lastName,
                stringResource(R.string.last_name_placeholder)
            ) { callback?.onLastNameChange(it) }
        }
        if(state.type == SIGN_IN) OSTextField(
            state.email,
            stringResource(R.string.email_placeholder),
            Modifier.padding(top = 35.dp)
        ) { callback?.onEmailChange(it) }
    }
}

@Composable
fun LoginButtons(
    modifier: Modifier,
    type: LoginScreenType,
    onLoginClick: () -> Unit,
    onSubClick: () -> Unit,
) {
    Column(modifier) {
        OSButton(
            stringResource(
                when(type) {
                    LOGIN -> R.string.login_button
                    SIGN_IN -> R.string.sign_in_title
                }
            )
        ) { onLoginClick() }
        SubText(
            Modifier.padding(top = 15.dp),
            (type != SIGN_IN)
        ) { onSubClick() }
    }
}

@Composable
private fun SubText(
    modifier: Modifier = Modifier,
    hide: Boolean,
    onClick: () -> Unit,
) {
    val style = hasAccount
    val text = buildAnnotatedString {
        if(!hide) {
            append("${stringResource(R.string.sign_in_has_account)}  ")
            pushStringAnnotation(("login"), (""))
            withStyle(style.copy(LightBlue).toSpanStyle()) {
                append(stringResource(R.string.sign_in_has_account_but))
            }; pop()
        }
    }
    
    ClickableText(text, modifier, style.copy(LightGray)) {
        text.getStringAnnotations(("login"), it, it)
            .firstOrNull()?.let { onClick() }
    }
}


@Composable
fun LoginExternals(
    modifier: Modifier = Modifier,
    onExternalClick: (ExternalType) -> Unit,
) {
    Column(modifier, Top, Start) {
        LoginExtItem(
            R.drawable.ic_google_logo,
            R.string.sign_in_google_enter,
            Modifier
                .padding(bottom = 40.dp)
                .clickable(
                    MutableInteractionSource(), (null)
                ) { onExternalClick(GOOGLE) }
        )
        LoginExtItem(
            R.drawable.ic_apple_logo,
            R.string.sign_in_apple_enter,
            Modifier.clickable(
                MutableInteractionSource(), (null)
            ) { onExternalClick(APPLE) }
        )
    }
}

@Composable
private fun LoginExtItem(
    icon: Int, text: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier, Arrangement.Start,
        verticalAlignment = CenterVertically
    ) {
        Image(
            painterResource(icon),
            (null), Modifier.size(24.dp)
        )
        Text(
            stringResource(text),
            Modifier.padding(start = 14.dp),
            style = external
        )
    }
}