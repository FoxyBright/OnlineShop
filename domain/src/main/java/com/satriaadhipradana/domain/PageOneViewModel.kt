package com.satriaadhipradana.domain

import com.satriaadhipradana.data.DataManager
import com.satriaadhipradana.data.WebSource
import com.satriaadhipradana.shared.model.ProductModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PageOneViewModel {
    
    private val dm = DataManager(WebSource())
    
    private val _latest =
        MutableStateFlow(emptyList<ProductModel>())
    val latest = _latest.asStateFlow()
    
    suspend fun getLatest() {
        _latest.emit(dm.getLatest().map { it.map() })
    }
}