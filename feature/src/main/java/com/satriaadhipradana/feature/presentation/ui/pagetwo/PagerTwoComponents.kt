package com.satriaadhipradana.feature.presentation.ui.pagetwo

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.layout.ContentScale.Companion.FillWidth
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.*
import com.satriaadhipradana.feature.presentation.ui.pagetwo.SumButtonType.MINUS
import com.satriaadhipradana.feature.presentation.ui.pagetwo.SumButtonType.PLUS
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.R.drawable.ic_minus
import com.satriaadhipradana.shared.R.drawable.ic_plus
import com.satriaadhipradana.shared.extensions.format
import com.satriaadhipradana.shared.model.DemoFullProductModel
import com.satriaadhipradana.shared.model.FullProductModel
import com.satriaadhipradana.shared.theme.BlueberryDark
import com.satriaadhipradana.shared.theme.ExtraType
import com.satriaadhipradana.shared.theme.ExtraType.Companion.addCart
import com.satriaadhipradana.shared.theme.ExtraType.Companion.color
import com.satriaadhipradana.shared.theme.ExtraType.Companion.descAndReview
import com.satriaadhipradana.shared.theme.ExtraType.Companion.fullProductName
import com.satriaadhipradana.shared.theme.ExtraType.Companion.fullProductPrice
import com.satriaadhipradana.shared.theme.ExtraType.Companion.quantity
import com.satriaadhipradana.shared.theme.ExtraType.Companion.sum
import com.satriaadhipradana.shared.theme.Gray22
import kotlin.math.absoluteValue


@Composable
@OptIn(ExperimentalPagerApi::class)
fun ProductImage(
    list: List<String>,
    state: PagerState,
    modifier: Modifier = Modifier,
    onSlide: (Int) -> Unit,
) {
    HorizontalPager(
        list.size, modifier
            .fillMaxHeight(0.4f)
            .fillMaxWidth(),
        state, contentPadding = PaddingValues(
            end = 52.dp
        ), itemSpacing = 16.dp
    ) { page ->
        Card(
            Modifier
                .height(280.dp)
                .fillMaxWidth(),
            RoundedCornerShape(8.dp),
            cardColors(Transparent)
        ) {
            Image(
                rememberAsyncImagePainter(
                    list[page]
                ), (null), Modifier.fillMaxSize(),
                contentScale = FillWidth
            )
        }
        if(!state.isScrollInProgress)
            onSlide(state.currentPage)
    }
}

@Composable
@OptIn(
    ExperimentalPagerApi::class,
    ExperimentalMaterial3Api::class
)
fun Slider(
    list: List<String>,
    state: PagerState,
    modifier: Modifier = Modifier,
    onItemSelect: (Int) -> Unit,
) {
    HorizontalPager(
        list.size, modifier
            .height(90.dp)
            .fillMaxWidth(),
        state, contentPadding = PaddingValues(
            start = 165.dp,
            end = 165.dp
        )
    ) { page ->
        Card(
            {
                if(!state.isScrollInProgress)
                    onItemSelect(page)
            }, Modifier
                .size(100.dp, 50.dp)
                .graphicsLayer {
                    animation(
                        (this@HorizontalPager),
                        page
                    )
                }, (true), RoundedCornerShape(8.dp),
            cardColors(Transparent)
        ) {
            Image(
                rememberAsyncImagePainter(
                    list[page]
                ), (null), Modifier.fillMaxSize(),
                contentScale = FillWidth
            )
        }
        if(!state.isScrollInProgress)
            onItemSelect(state.currentPage)
    }
}

@OptIn(ExperimentalPagerApi::class)
private fun GraphicsLayerScope.animation(
    pager: PagerScope, page: Int,
) {
    lerp(
        (0.7f), (1f),
        (1f - pager.calculateCurrentOffsetForPage(page)
            .absoluteValue.coerceIn(0f, 1f))
    ).also { scale -> scaleX = scale; scaleY = scale }
}

@Composable
fun ProductData(
    product: FullProductModel,
) {
    Column(Modifier.padding(horizontal = 24.dp)) {
        Row(
            Modifier.fillMaxWidth(),
            SpaceBetween, Top
        ) {
            Text(
                product.name,
                Modifier.fillMaxWidth(0.5f),
                style = fullProductName
            )
            Text(
                ("$ ${product.price format "%.2f"}"),
                Modifier.padding(top = 4.dp),
                style = fullProductPrice
            )
        }
        Text(
            product.description,
            Modifier
                .fillMaxWidth(0.7f)
                .padding(
                    bottom = 12.dp,
                    top = 16.dp
                ),
            style = descAndReview
        )
        Rating(
            product.rating,
            product.reviews,
        )
    }
}

@Composable
private fun Rating(
    rating: Float,
    reviews: Int,
) {
    Text(buildAnnotatedString {
        appendInlineContent("img")
        withStyle(ExtraType.rating.toSpanStyle()) {
            append(" $rating ")
        }
        withStyle(descAndReview.toSpanStyle()) {
            append("($reviews reviews)")
        }
    }, inlineContent = mapOf(
        "img" to InlineTextContent(
            Placeholder(
                9.sp, 9.sp,
                PlaceholderVerticalAlign.Center
            )
        ) {
            Image(
                painterResource(
                    R.drawable.ic_rating
                ),
                (null), Modifier.size(12.dp),
            )
        }
    ))
}

@Preview
@Composable
fun Pre() {
    ProductColors(
        DemoFullProductModel.colors,
        2
    ) {}
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProductColors(
    list: List<Color>,
    selected: Int,
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit,
) {
    Column(modifier) {
        Text(
            stringResource(R.string.page_two_color_label),
            Modifier.padding(bottom = 11.dp),
            style = color
        )
        LazyRow(Modifier) {
            itemsIndexed(list) { index, color ->
                Card(
                    { onClick(index) },
                    Modifier
                        .size(50.dp, 25.dp)
                        .padding(end = 14.dp),
                    (true), RoundedCornerShape(9.dp),
                    cardColors(color),
                    border = if(selected == index)
                        BorderStroke(2.dp, Gray22)
                    else null
                ) {}
            }
        }
    }
}

@Composable
fun SubBottomBar(
    price: Float,
    modifier: Modifier,
    plus: () -> Unit,
    minus: () -> Unit,
    addToCart: () -> Unit,
) {
    Box(
        modifier.background(
            BlueberryDark,
            RoundedCornerShape(
                topStart = 26.dp,
                topEnd = 26.dp
            )
        )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(horizontal = 24.dp),
            SpaceBetween, Top
        ) {
            Column(Modifier.padding(top = 13.dp)) {
                Text(
                    stringResource(R.string.page_two_items_quantity),
                    Modifier.padding(bottom = 12.dp),
                    style = quantity
                )
                Row(Modifier) {
                    SumButton(
                        MINUS,
                        Modifier.padding(end = 20.dp),
                        minus
                    )
                    SumButton(PLUS, Modifier, plus)
                }
            }
            AddCartButton(
                price,
                Modifier.padding(top = 18.dp)
            ) { addToCart() }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SumButton(
    type: SumButtonType,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        onClick, modifier.size(38.dp, 22.dp),
        (true), RoundedCornerShape(8.dp),
        cardColors(colorScheme.primary),
    ) {
        Box(Modifier.fillMaxSize(), Center) {
            Image(
                painterResource(
                    when(type) {
                        MINUS -> ic_minus
                        PLUS -> ic_plus
                    }
                ), (null),
                Modifier.size(7.dp),
                colorFilter = tint(White)
            )
        }
    }
}

private enum class SumButtonType { MINUS, PLUS }

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun AddCartButton(
    price: Float,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        onClick, modifier.width(180.dp),
        (true), RoundedCornerShape(16.dp),
        cardColors(colorScheme.primary)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(28.dp, 16.dp),
            SpaceBetween, CenterVertically
        ) {
            Text(
                ("#${price format "%.3f"}"),
                Modifier, style = sum
            )
            Text(
                stringResource(R.string.page_two_add_to_cart),
                Modifier, style = addCart
            )
        }
    }
}