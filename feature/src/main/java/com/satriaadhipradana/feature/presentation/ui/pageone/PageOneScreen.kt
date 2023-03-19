package com.satriaadhipradana.feature.presentation.ui.pageone

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.satriaadhipradana.domain.viewmodel.PageOneViewModel
import com.satriaadhipradana.shared.extensions.notImpl
import com.satriaadhipradana.shared.model.CategoryModel
import kotlinx.coroutines.launch

@Composable
fun PageOneScreen(
    vm: PageOneViewModel,
    nav: NavHostController,
) {
    
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    
    val flashSale by vm.flashSale.collectAsState()
    val latest by vm.latest.collectAsState()
    val brands by vm.brands.collectAsState()
    val profile by vm.profile.collectAsState()
    val search by vm.search.collectAsState()
    
    LaunchedEffect(Unit) { vm.getData() }
    
    PageOneContent(
        PageOneState(
            profile, search, latest, flashSale, brands
        ), Modifier, object: PageOneCallback {
            override fun onSearchChange(text: String) {
                scope.launch { vm.searchTextChange(text) }
            }
            
            override fun onUpdate() {
                scope.launch { vm.getData() }
            }
            
            override fun onCategoryClick(category: CategoryModel) {
                notImpl(context)
            }
            
            override fun onMenuClick() {
                notImpl(context)
            }
            
            override fun onProfileClick() {
                nav.navigate("profile")
            }
            
            override fun onLocationClick() {
                notImpl(context)
            }
            
            override fun onLatestViewAllClick() {
                notImpl(context)
            }
            
            override fun onFlashSaleViewAllClick() {
                notImpl(context)
            }
            
            override fun onBrandsViewAllClick() {
                notImpl(context)
            }
            
            override fun onProductClick() {
                nav.navigate("pageTwo")
            }
            
            override fun onAddToCartClick() {
                notImpl(context)
            }
            
            override fun onAddToFavourite() {
                notImpl(context)
            }
            
            override fun onNavigate(point: Int) {
                nav.navigate(
                    if(point == 4) "profile"
                    else "notResolved/$point"
                )
            }
        }
    )
}

