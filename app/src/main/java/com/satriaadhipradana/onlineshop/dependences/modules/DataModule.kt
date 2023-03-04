package com.satriaadhipradana.onlineshop.dependences.modules

import com.satriaadhipradana.data.DataManager
import com.satriaadhipradana.data.ProfileStore
import com.satriaadhipradana.data.WebSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    
    single { ProfileStore(get()) }
    
    single { DataManager(get()) }
    
    singleOf(::WebSource)
    
}