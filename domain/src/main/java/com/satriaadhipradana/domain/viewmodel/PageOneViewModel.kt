package com.satriaadhipradana.domain.viewmodel

import androidx.lifecycle.ViewModel
import com.satriaadhipradana.data.DataManager
import com.satriaadhipradana.data.ProfileStore
import com.satriaadhipradana.shared.model.ProductModel
import com.satriaadhipradana.shared.model.ProfileModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PageOneViewModel(
    private val store: ProfileStore,
    private val dm: DataManager,
): ViewModel() {
    
    private val _profile =
        MutableStateFlow<ProfileModel?>(null)
    val profile = _profile.asStateFlow()
    
    private val _search = MutableStateFlow("")
    val search = _search.asStateFlow()
    
    private val _latest =
        MutableStateFlow(emptyList<ProductModel>())
    val latest = _latest.asStateFlow()
    
    private val _brands =
        MutableStateFlow(emptyList<ProductModel>())
    val brands = _brands.asStateFlow()
    
    private val _flashSale =
        MutableStateFlow(emptyList<ProductModel>())
    val flashSale = _flashSale.asStateFlow()
    
    suspend fun getData() {
        _profile.emit(store.getProfile())
        _latest.emit(dm.getLatest())
        _flashSale.emit(dm.getFlashSale())
        _brands.emit(latest.value)
    }
    
    suspend fun searchTextChange(text: String) {
        _search.emit(text)
    }
}