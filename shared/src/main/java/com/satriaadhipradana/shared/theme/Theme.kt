package com.satriaadhipradana.shared.theme

import android.app.Activity
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat.getInsetsController

private val darkColorScheme = darkColorScheme(
    primary = Blue,
    secondary = LightGray,
    tertiary = Black,
    background = White,
    onPrimary = Silver,
    primaryContainer = Pacific,
    onSecondary = Gray
)

private val lightColorScheme = lightColorScheme(
    primary = Blue,
    secondary = LightGray,
    tertiary = Black,
    background = White,
    onPrimary = Silver,
    primaryContainer = Pacific,
    onSecondary = Gray
)

@Composable
fun OSTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if(darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }
        
        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
    if(!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme
                .background
                .toArgb()
            
            getInsetsController(
                window, view
            ).isAppearanceLightStatusBars = darkTheme
        }
    }
    
    MaterialTheme(
        colorScheme = colorScheme,
        typography = MontserratTypo,
        content = content
    )
}