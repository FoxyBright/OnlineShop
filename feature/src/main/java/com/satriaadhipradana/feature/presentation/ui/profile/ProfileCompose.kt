package com.satriaadhipradana.feature.presentation.ui.profile

import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.components.OSButton
import com.satriaadhipradana.shared.model.DemoProfileModel
import com.satriaadhipradana.shared.model.ProfileModel
import com.satriaadhipradana.shared.theme.OnlineShopTheme

@Preview
@Composable
private fun ProfilePreview() {
    OnlineShopTheme {
        ProfileContent(
            ProfileState(
                DemoProfileModel
            )
        )
    }
}

data class ProfileState(
    val profile: ProfileModel,
)

interface ProfileCallback {
    
    fun onLogout()
}

@Composable
fun ProfileContent(
    state: ProfileState,
    modifier: Modifier = Modifier,
    callback: ProfileCallback? = null,
) {
    Column(
        modifier.fillMaxSize(),
        Top, CenterHorizontally
    ) {
        Text(state.profile.name)
        Text(state.profile.email)
        Text(state.profile.balance.toString())
        OSButton(stringResource(R.string.profile_logout_label)) {
            callback?.onLogout()
        }
    }
}