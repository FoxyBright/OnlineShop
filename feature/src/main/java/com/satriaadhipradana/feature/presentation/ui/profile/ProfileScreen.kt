package com.satriaadhipradana.feature.presentation.ui.profile

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.satriaadhipradana.domain.viewmodel.ProfileViewModel
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    vm: ProfileViewModel,
    nav: NavHostController,
) {
    
    val scope = rememberCoroutineScope()
    val profile by vm.profile.collectAsState()
    
    LaunchedEffect(Unit) {
        vm.getProfile()
        Log.d("LOGI  ---> ", profile.toString())
    }
    
    profile?.let {
        ProfileContent(
            ProfileState(it), Modifier,
            object: ProfileCallback {
                override fun onLogout() {
                    scope.launch {
                        vm.logout()
                        nav.navigate("login")
                    }
                }
            }
        )
    }
}