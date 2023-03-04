package com.satriaadhipradana.onlineshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.satriaadhipradana.domain.PageOneViewModel
import com.satriaadhipradana.feature.MainScreen
import com.satriaadhipradana.shared.theme.OnlineShopTheme

class MainActivity: ComponentActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnlineShopTheme {
                val vm = PageOneViewModel()
                MainScreen(vm)
            }
        }
    }
}