package com.satriaadhipradana.onlineshop.dependences.modules

class Modules {
    
    companion object{
    
        fun getKoinModules() = listOf(
            dataModule, viewModelModule
        )
        
    }
}