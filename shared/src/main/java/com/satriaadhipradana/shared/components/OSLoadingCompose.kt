package com.satriaadhipradana.shared.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OSLoading(modifier: Modifier = Modifier) {
    Box(
        modifier.fillMaxSize(),
        Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(60.dp),
            color = colorScheme.primary,
            strokeWidth = 4.dp
        )
    }
}