package com.satriaadhipradana.onlineshop.dependences.modules

import com.satriaadhipradana.data.manager.DataManager
import com.satriaadhipradana.data.repository.ProfileRepository
import com.satriaadhipradana.data.source.WebSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    
    single { ProfileRepository(get()) }
    
    single { DataManager(get()) }
    
    singleOf(::WebSource)
    
}