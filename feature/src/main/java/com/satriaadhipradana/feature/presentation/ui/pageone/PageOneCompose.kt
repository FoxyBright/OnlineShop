package com.satriaadhipradana.feature.presentation.ui.pageone

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.satriaadhipradana.feature.presentation.ui.pageone.components.*
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.components.OSNavBar
import com.satriaadhipradana.shared.components.OSSearch
import com.satriaadhipradana.shared.model.*
import com.satriaadhipradana.shared.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
private fun PageOnePreview() {
    OSTheme {
        PageOneContent(
            PageOneState(
                DemoProfileModel, (""),
                DemoProductModelList,
                DemoProductModelList,
                DemoProductModelList,
            )
        )
    }
}

data class PageOneState(
    val profile: ProfileModel,
    val search: String,
    val latest: List<ProductModel>,
    val flashSale: List<ProductModel>,
    val brands: List<ProductModel>,
)

interface PageOneCallback {
    
    fun onSearchChange(text: String)
    fun onCategoryClick(category: CategoryModel)
    fun onMenuClick()
    fun onProfileClick()
    fun onLocationClick()
    fun onLatestViewAllClick()
    fun onFlashSaleViewAllClick()
    fun onBrandsViewAllClick()
    fun onProductClick()
    fun onAddToCartClick()
    fun onAddToFavourite()
    fun onNavigate(point: Int)
    fun onUpdate()
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PageOneContent(
    state: PageOneState,
    modifier: Modifier = Modifier,
    callback: PageOneCallback? = null,
) {
    Scaffold(
        modifier.fillMaxSize(),
        topBar = { TopBar(state, Modifier, callback) },
        bottomBar = {
            OSNavBar(0)
            { callback?.onNavigate(it) }
        }, containerColor = colorScheme.background
    ) {
        val scope = rememberCoroutineScope()
        var swipeState by remember { mutableStateOf(false) }
        SwipeRefresh(
            rememberSwipeRefreshState(swipeState), {
                scope.launch {
                    swipeState = true
                    delay(3000)
                    callback?.onUpdate()
                    swipeState = false
                }
            }, Modifier.padding(
                top = it.calculateTopPadding()
            ), indicator = { s, t ->
                SwipeRefreshIndicator(
                    s, t, contentColor = colorScheme.primary
                )
            }
        ) {
            Content(
                state,
                modifier.padding(bottom = it.calculateBottomPadding()),
                callback
            )
        }
    }
}

@Composable
private fun Content(
    state: PageOneState,
    modifier: Modifier = Modifier,
    callback: PageOneCallback?,
) {
    LazyColumn(
        modifier.fillMaxSize(),
        horizontalAlignment = CenterHorizontally
    ) {
        item {
            Categories(Modifier.padding(16.dp))
            { callback?.onCategoryClick(it) }
        }
        item {
            Group(
                stringResource(R.string.page_one_latest_group_title),
                Modifier.padding(top = 13.dp)
            ) { callback?.onLatestViewAllClick() }
        }
        item {
            ProductList(state.latest, Modifier, {
                callback?.onAddToCartClick()
            }) { callback?.onProductClick() }
        }
        item {
            Group(
                stringResource(R.string.page_one_flash_sale_group_title),
                Modifier.padding(top = 17.dp)
            ) { callback?.onFlashSaleViewAllClick() }
        }
        item {
            ProductList(state.flashSale, Modifier,
                { callback?.onAddToCartClick() },
                { callback?.onAddToFavourite() }
            ) { callback?.onProductClick() }
        }
        item {
            Group(
                stringResource(R.string.page_one_brands_group_title),
                Modifier.padding(top = 17.dp)
            ) { callback?.onBrandsViewAllClick() }
        }
        item {
            ProductList(state.brands, Modifier, {
                callback?.onAddToCartClick()
            }) { callback?.onProductClick() }
        }
        item { Spacer(Modifier.height(20.dp)) }
    }
}

@Composable
private fun TopBar(
    state: PageOneState,
    modifier: Modifier = Modifier,
    callback: PageOneCallback?,
) {
    Column(modifier) {
        PageOneTopBarData(state, Modifier, callback)
        OSSearch(
            state.search,
            Modifier
                .padding(horizontal = 56.dp)
                .padding(top = 10.dp)
        ) { callback?.onSearchChange(it) }
    }
}