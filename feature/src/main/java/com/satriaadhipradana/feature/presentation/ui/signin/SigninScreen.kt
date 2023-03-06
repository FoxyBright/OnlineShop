package com.satriaadhipradana.feature.presentation.ui.signin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.satriaadhipradana.domain.viewmodel.SignInViewModel

@Composable
fun SignInScreen(
    vm: SignInViewModel,
    nav: NavHostController,
) {
    
    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Text("ТУТ ТОЧКА ВХОДА")
    }
}