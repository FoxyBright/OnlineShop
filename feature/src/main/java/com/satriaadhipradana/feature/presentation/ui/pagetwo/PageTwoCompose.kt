package com.satriaadhipradana.feature.presentation.ui.pagetwo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.components.OSLoading
import com.satriaadhipradana.shared.components.OSNavBar
import com.satriaadhipradana.shared.model.FullProductModel
import com.satriaadhipradana.shared.theme.FavCross
import com.satriaadhipradana.shared.theme.FavTrans

@OptIn(ExperimentalPagerApi::class)
data class PageTwoState(
    val product: FullProductModel?,
    val pagerState: PagerState,
    val sliderState: PagerState,
    val selectColor: Int,
    val sum: Float,
)

interface PageTwoCallback {
    
    fun onSliderSelect(point: Int)
    
    fun onSlide(point: Int)
    fun onSelectColor(color: Int)
    fun onBack()
    fun onNavigate(point: Int)
    fun onAddProduct()
    fun onRemoveProduct()
    fun onAddToCart()
    fun onFavourite()
    fun onShare()
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PageTwoContent(
    state: PageTwoState,
    modifier: Modifier = Modifier,
    callback: PageTwoCallback? = null,
) {
    Scaffold(
        modifier,
        bottomBar = {
            BottomBar(state, Modifier, callback)
        }, containerColor = colorScheme.background
    ) { padding ->
        state.product?.let {
            Content(
                state,
                Modifier.padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding() - 32.dp
                ),
                callback
            )
        } ?: OSLoading(
            Modifier.padding(padding)
        )
    }
    TopBar(Modifier.padding(top = 6.dp)) {
        callback?.onBack()
    }
}

@Composable
@OptIn(ExperimentalPagerApi::class)
private fun Content(
    state: PageTwoState,
    modifier: Modifier = Modifier,
    callback: PageTwoCallback?,
) {
    LazyColumn(modifier) {
        item {
            ProductImage(
                state.product?.images!!,
                state.pagerState,
                Modifier.padding(top = 30.dp)
            ) { callback?.onSlide(it) }
        }
        item {
            Slider(
                state.product?.images!!,
                state.sliderState,
                Modifier.padding(vertical = 20.dp)
            ) { callback?.onSliderSelect(it) }
        }
        item { ProductData(state.product!!) }
        item {
            ProductColors(
                state.product?.colors!!,
                state.selectColor,
                Modifier
                    .padding(vertical = 14.dp)
                    .padding(start = 24.dp)
            ) { callback?.onSelectColor(it) }
        }
    }
    Floating(
        Modifier.padding(end = 32.dp),
        { callback?.onShare() }
    ) { callback?.onFavourite() }
}

@Composable
private fun Floating(
    modifier: Modifier = Modifier,
    onShare: () -> Unit,
    onFavourite: () -> Unit,
) {
    Box(
        modifier
            .fillMaxWidth()
            .fillMaxHeight(0.35f),
        BottomEnd
    ) {
        Column(
            Modifier
                .background(
                    FavTrans,
                    RoundedCornerShape(14.dp)
                )
                .padding(bottom = 4.dp),
            Center, CenterHorizontally
        ) {
            FloatingIcon(
                R.drawable.ic_heart
            ) { onFavourite() }
            Divider(
                Modifier.width(12.dp),
                1.dp, FavCross
            )
            FloatingIcon(
                R.drawable.ic_share
            ) { onShare() }
        }
    }
}

@Composable
private fun FloatingIcon(
    icon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(onClick, modifier) {
        Icon(
            painterResource(icon),
            (null), Modifier.size(16.dp),
            FavCross
        )
    }
}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    IconButton(onBack, modifier) {
        Icon(
            painterResource(
                R.drawable.ic_left_arrow
            ), (null), Modifier.size(14.dp),
            Black
        )
    }
}

@Composable
private fun BottomBar(
    state: PageTwoState,
    modifier: Modifier = Modifier,
    callback: PageTwoCallback?,
) {
    Column(modifier) {
        SubBottomBar(
            state.sum,
            Modifier.offset(y = 32.dp),
            { callback?.onAddProduct() },
            { callback?.onRemoveProduct() }
        ) { callback?.onAddToCart() }
        OSNavBar(0)
        { callback?.onNavigate(it) }
    }
}