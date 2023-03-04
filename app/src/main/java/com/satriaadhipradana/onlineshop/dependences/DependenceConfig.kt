package com.satriaadhipradana.onlineshop.dependences

import android.app.Application
import com.satriaadhipradana.onlineshop.dependences.modules.Modules.Companion.getKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level.NONE

class DependenceConfig: Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        startKoin {
            androidLogger(NONE)
            androidContext(this@DependenceConfig)
            modules(getKoinModules())
        }
    }
}