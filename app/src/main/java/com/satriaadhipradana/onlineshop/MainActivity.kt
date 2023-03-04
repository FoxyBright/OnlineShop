package com.satriaadhipradana.onlineshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.satriaadhipradana.domain.viewmodel.PageOneViewModel
import com.satriaadhipradana.feature.MainScreen
import com.satriaadhipradana.shared.theme.OnlineShopTheme
import org.koin.android.ext.android.inject

class MainActivity: ComponentActivity() {
    
    private val vm by inject<PageOneViewModel>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { OnlineShopTheme { MainScreen(vm) } }
    }
}