package com.satriaadhipradana.feature.presentation.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController

@Composable
fun CartScreen(nav: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .clickable(
                MutableInteractionSource(),
                (null)
            ) {
                nav.navigate("pageOne")
            }, Center
    ) {
        Text(
            "YOUR CART SCREEN " +
                    "\n\n HAS NOT BEEN IMPLEMENTED" +
                    "\n\n (CLICK THIS TO RETURN)",
            textAlign = TextAlign.Center
        )
    }
}