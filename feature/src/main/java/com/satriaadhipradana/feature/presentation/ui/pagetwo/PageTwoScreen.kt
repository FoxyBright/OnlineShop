package com.satriaadhipradana.feature.presentation.ui.pagetwo

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.satriaadhipradana.domain.viewmodel.PageTwoViewModel
import com.satriaadhipradana.shared.extensions.notImpl
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalPagerApi::class)
fun PageTwoScreen(
    vm: PageTwoViewModel,
    nav: NavHostController,
) {
    val selectedColor by vm.selectedColor.collectAsState()
    val product by vm.product.collectAsState()
    val sum by vm.sum.collectAsState()
    val scope = rememberCoroutineScope()
    val sliderState = rememberPagerState()
    val pagerState = rememberPagerState()
    val context = LocalContext.current
    
    LaunchedEffect(Unit) { vm.uploadImages() }
    
    PageTwoContent(
        PageTwoState(
            product, pagerState,
            sliderState, selectedColor, sum
        ), Modifier, object: PageTwoCallback {
            override fun onAddProduct() {
                scope.launch { vm.addProduct() }
            }
            
            override fun onRemoveProduct() {
                scope.launch { vm.removeProduct() }
            }
            
            override fun onAddToCart() {
                nav.navigate("cart")
            }
            
            override fun onNavigate(point: Int) {
                nav.navigate(
                    when(point) {
                        0 -> "pageOne"
                        4 -> "profile"
                        else -> "notResolved/$point"
                    }
                )
            }
            
            override fun onSlide(point: Int) {
                scope.launch {
                    sliderState.animateScrollToPage(point)
                }
            }
            
            override fun onSliderSelect(point: Int) {
                scope.launch {
                    pagerState.animateScrollToPage(point)
                }
            }
            
            override fun onSelectColor(color: Int) {
                scope.launch { vm.selectColor(color) }
            }
            
            override fun onFavourite() {
                notImpl(context)
            }
            
            override fun onShare() {
                notImpl(context)
            }
            
            override fun onBack() {
                nav.popBackStack()
            }
        }
    )
}