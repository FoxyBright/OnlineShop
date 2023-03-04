package com.satriaadhipradana.onlineshop.dependences.modules

import com.satriaadhipradana.domain.viewmodel.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val viewModelModule = module {
    
    single { PageOneViewModel(get()) }
    
    single { ProfileViewModel(get()) }
    
    singleOf(::PageTwoViewModel)
    
    singleOf(::SignInViewModel)
    
    singleOf(::LoginViewModel)
    
}