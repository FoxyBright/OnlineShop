package com.satriaadhipradana.onlineshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.satriaadhipradana.data.ProfileStore
import com.satriaadhipradana.feature.presentation.ui.Presentation.MainScreen
import com.satriaadhipradana.shared.theme.OSTheme
import org.koin.android.ext.android.inject

class MainActivity: ComponentActivity() {
    
    private val store by inject<ProfileStore>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { OSTheme { MainScreen(store.isAuthorized()) } }
    }
}