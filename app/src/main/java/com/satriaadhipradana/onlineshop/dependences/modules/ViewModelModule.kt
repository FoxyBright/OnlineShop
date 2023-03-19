package com.satriaadhipradana.onlineshop.dependences.modules

import com.satriaadhipradana.domain.viewmodel.*
import org.koin.dsl.module

val viewModelModule = module {
    
    single { PageOneViewModel(get(), get()) }
    
    single { ProfileViewModel(get()) }
    
    single { LoginViewModel(get()) }
    
    single { PageTwoViewModel(get()) }
}