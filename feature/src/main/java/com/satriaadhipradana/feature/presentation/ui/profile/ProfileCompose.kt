package com.satriaadhipradana.feature.presentation.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.components.OSNavBar
import com.satriaadhipradana.shared.model.DemoProfileModel
import com.satriaadhipradana.shared.model.ProfileModel
import com.satriaadhipradana.shared.theme.*
import com.satriaadhipradana.shared.theme.ExtraType.Companion.profileName
import com.satriaadhipradana.shared.theme.ExtraType.Companion.profileTitle

@Preview
@Composable
private fun ProfilePreview() {
    OSTheme {
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
    fun onBack()
    fun onPhotoChange()
    fun onUploadClick()
    fun onNavigate(point: Int)
    fun onElementsClick()
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProfileContent(
    state: ProfileState,
    modifier: Modifier = Modifier,
    callback: ProfileCallback? = null,
) {
    Scaffold(modifier,
        topBar = {
            TopBar(
                Modifier.padding(top = 20.dp)
            ) { callback?.onBack() }
        },
        bottomBar = {
            OSNavBar(4)
            { callback?.onNavigate(it) }
        }, containerColor = colorScheme.background,
        content = {
            Content(
                state, Modifier
                    .padding(bottom = it.calculateBottomPadding()),
                callback
            )
        }
    )
}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(onClick, modifier) {
        Icon(
            painterResource(
                R.drawable.ic_back_arrow
            ), (null), Modifier.size(18.dp),
            tint = OSBlack
        )
    }
}

@Composable
private fun Content(
    state: ProfileState,
    modifier: Modifier = Modifier,
    callback: ProfileCallback?,
) {
    LazyColumn(modifier.fillMaxSize()) {
        item {
            Text(
                stringResource(R.string.profile_title),
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 19.dp, top = 33.dp),
                style = profileTitle
            )
        }
        item {
            ProfileAvatar(
                state.profile.avatar,
                Modifier, callback
            )
        }
        item {
            Text(
                state.profile.name,
                Modifier.fillMaxWidth(),
                style = profileName
            )
        }
        item {
            ProfileUploadButton(Modifier)
            { callback?.onUploadClick() }
        }
        item {
            ProfileMenuElement(
                R.string.profile_trade_store_label,
                Modifier.padding(start = 4.dp),
                subItem = "arrow"
            ) { callback?.onElementsClick() }
        }
        item {
            ProfileMenuElement(
                R.string.profile_payment_method_label,
                Modifier.padding(start = 4.dp),
                subItem = "arrow"
            ) { callback?.onElementsClick() }
        }
        item {
            ProfileMenuElement(
                R.string.profile_balance_label,
                Modifier.padding(start = 4.dp),
                subItem = state.profile.balance.toString()
            ) { callback?.onElementsClick() }
        }
        item {
            ProfileMenuElement(
                R.string.profile_trade_history_label,
                subItem = "arrow"
            ) { callback?.onElementsClick() }
        }
        item {
            ProfileMenuElement(
                R.string.profile_restore_purchase_label,
                icon = R.drawable.ic_refresh,
                subItem = "arrow"
            ) { callback?.onElementsClick() }
        }
        item {
            ProfileMenuElement(
                R.string.profile_help_label,
                icon = R.drawable.ic_help
            ) { callback?.onElementsClick() }
        }
        item {
            ProfileMenuElement(
                R.string.profile_logout_label,
                icon = R.drawable.ic_logout
            ) { callback?.onLogout() }
        }
    }
}