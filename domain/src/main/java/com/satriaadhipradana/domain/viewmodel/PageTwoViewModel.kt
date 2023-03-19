package com.satriaadhipradana.domain.viewmodel

import androidx.lifecycle.ViewModel
import com.satriaadhipradana.data.manager.DataManager
import com.satriaadhipradana.shared.model.FullProductModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PageTwoViewModel(
    private val dm: DataManager,
): ViewModel() {
    
    private val _product =
        MutableStateFlow<FullProductModel?>(null)
    val product = _product.asStateFlow()
    
    private val _selectedColor = MutableStateFlow(0)
    val selectedColor = _selectedColor.asStateFlow()
    
    private val _sum = MutableStateFlow(0f)
    val sum = _sum.asStateFlow()
    
    suspend fun addProduct() {
        product.value?.price?.let {
            _sum.emit((sum.value + it))
        }
    }
    
    suspend fun removeProduct() {
        product.value?.price?.let {
            if(sum.value > it) _sum.emit(
                (sum.value - it)
            )
        }
    }
    
    suspend fun selectColor(color: Int) {
        _selectedColor.emit(color)
    }
    
    suspend fun uploadImages() {
        _product.emit(dm.getProduct())
        _sum.emit(product.value?.price!!)
    }
}