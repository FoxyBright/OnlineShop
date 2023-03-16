package com.satriaadhipradana.feature.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController

@Composable
fun NotResolved(nav: NavHostController) {
    Box(Modifier.fillMaxSize(), Center) {
        Text(
            ("404 NOT FOUND\n\nCLICK ON ME TO RETURN"),
            Modifier.clickable {
                nav.popBackStack()
            }, textAlign = TextAlign.Center
        )
    }
}