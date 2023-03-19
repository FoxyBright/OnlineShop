package com.satriaadhipradana.feature.presentation.ui.profile

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.satriaadhipradana.domain.viewmodel.ProfileViewModel
import com.satriaadhipradana.feature.presentation.ui.Presentation.logout
import com.satriaadhipradana.shared.components.OSLoading
import com.satriaadhipradana.shared.extensions.notImpl
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    vm: ProfileViewModel,
    nav: NavHostController,
) {
    
    val profile by vm.profile.collectAsState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    
    val launcher =
        rememberLauncherForActivityResult(GetContent())
        {
            scope.launch {
                vm.updatePhoto(it)
                vm.getProfile()
            }
        }
    
    LaunchedEffect(Unit) { vm.getProfile() }
    
    profile?.let {
        ProfileContent(
            ProfileState(it), Modifier,
            object: ProfileCallback {
                
                override fun onLogout() {
                    scope.launch {
                        vm.logout()
                        nav.logout()
                    }
                }
                
                override fun onNavigate(point: Int) {
                    nav.navigate(
                        if(point == 0) "pageOne"
                        else "notResolved/$point"
                    )
                }
                
                override fun onElementsClick() {
                    notImpl(context)
                }
                
                override fun onPhotoChange() {
                    launcher.launch("image/*")
                }
                
                override fun onUploadClick() {
                    notImpl(context)
                }
                
                override fun onBack() {
                    nav.popBackStack()
                }
            }
        )
    } ?: OSLoading()
}