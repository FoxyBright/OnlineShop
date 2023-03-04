package com.satriaadhipradana.domain.viewmodel

import androidx.lifecycle.ViewModel
import com.satriaadhipradana.data.DataManager
import com.satriaadhipradana.shared.model.ProductModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PageOneViewModel(
    private val dm: DataManager,
): ViewModel() {
    
    private val _latest =
        MutableStateFlow(emptyList<ProductModel>())
    val latest = _latest.asStateFlow()
    
    private val _flashSale =
        MutableStateFlow(emptyList<ProductModel>())
    val flashSale = _flashSale.asStateFlow()
    
    suspend fun getLatest() {
        _latest.emit(dm.getLatest())
    }
    
    suspend fun getFlashSale() {
        _flashSale.emit(dm.getFlashSale())
    }
}