package com.satriaadhipradana.feature.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.satriaadhipradana.shared.components.OSNavBar

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun UnResolved(nav: NavHostController, screen: Int) {
    Scaffold(bottomBar = {
        OSNavBar(screen) {
            nav.navigate(
                when(it) {
                    0 -> "pageOne"
                    4 -> "profile"
                    else -> "notResolved/$it"
                }
            )
        }
    }) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(it), Center
        ) {
            Text("404 NOT FOUND")
        }
    }
}