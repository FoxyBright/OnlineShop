package com.satriaadhipradana.feature.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.satriaadhipradana.domain.viewmodel.*
import com.satriaadhipradana.feature.presentation.ui.login.LoginScreen
import com.satriaadhipradana.feature.presentation.ui.pageone.PageOneScreen
import com.satriaadhipradana.feature.presentation.ui.pagetwo.PageTwoScreen
import com.satriaadhipradana.feature.presentation.ui.profile.ProfileScreen
import com.satriaadhipradana.feature.presentation.ui.screens.CartScreen
import com.satriaadhipradana.feature.presentation.ui.screens.UnResolved
import org.koin.java.KoinJavaComponent.get

object Presentation {
    
    private fun <T> getVm(clazz: Class<T>): T = get(clazz)
    
    private val pageTwoVM = getVm(PageTwoViewModel::class.java)
    private val pageOneVM = getVm(PageOneViewModel::class.java)
    private val profileVM = getVm(ProfileViewModel::class.java)
    private val loginVM = getVm(LoginViewModel::class.java)
    
    fun NavHostController.toApp() {
        this.navigate("pageOne") { popUpTo(0) }
    }
    
    fun NavHostController.logout() {
        this.navigate("login") { popUpTo(0) }
    }
    
    @Composable
    fun MainScreen(isAuthorized: Boolean) {
        
        val nav = rememberNavController()
        val start = if(isAuthorized) "pageOne" else "login"
        
        Box(
            Modifier
                .fillMaxSize()
                .background(colorScheme.background)
        ) {
            NavHost(nav, start) {
                composable(
                    route = "notResolved/{screen}",
                    arguments = listOf(
                        navArgument("screen") {
                            type = IntType
                            defaultValue = 0
                        }
                    )
                ) {
                    it.arguments?.getInt("screen")
                        ?.let { s -> UnResolved(nav, s) }
                }
                
                composable("login")
                { LoginScreen(loginVM, nav) }
                
                composable("profile")
                { ProfileScreen(profileVM, nav) }
                
                composable("pageOne")
                { PageOneScreen(pageOneVM, nav) }
                
                composable("pageTwo")
                { PageTwoScreen(pageTwoVM, nav) }
                
                composable("cart") {
                    CartScreen(nav)
                }
            }
        }
    }
}