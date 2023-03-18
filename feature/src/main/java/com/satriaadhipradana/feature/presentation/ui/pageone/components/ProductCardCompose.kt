package com.satriaadhipradana.feature.presentation.ui.pageone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Start
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale.Companion.FillHeight
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.satriaadhipradana.feature.presentation.ui.pageone.components.CardType.FULL
import com.satriaadhipradana.feature.presentation.ui.pageone.components.CardType.SHORT
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.model.DemoProductModel
import com.satriaadhipradana.shared.model.ProductModel
import com.satriaadhipradana.shared.theme.*
import com.satriaadhipradana.shared.theme.ExtraType.Companion.catName
import com.satriaadhipradana.shared.theme.ExtraType.Companion.productName
import com.satriaadhipradana.shared.theme.ExtraType.Companion.productPrice
import com.satriaadhipradana.shared.theme.ExtraType.Companion.saleCat
import com.satriaadhipradana.shared.theme.ExtraType.Companion.saleName
import com.satriaadhipradana.shared.theme.ExtraType.Companion.salePrice
import java.util.Locale

@Preview
@Composable
private fun FullProductCardPreview() {
    OSTheme {
        ProductCard(
            DemoProductModel,
            Modifier, FULL
        )
    }
}

@Preview
@Composable
private fun ShortProductCardPreview() {
    OSTheme {
        ProductCard(
            DemoProductModel,
            Modifier, SHORT
        )
    }
}

enum class CardType { SHORT, FULL }

private infix fun Float.format(filter: String) =
    filter.format(Locale("RU"), this)

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProductCard(
    product: ProductModel,
    modifier: Modifier = Modifier,
    type: CardType = SHORT,
    onAddToCart: ((ProductModel) -> Unit)? = null,
    onAddToFavourite: ((ProductModel) -> Unit)? = null,
    onClick: ((ProductModel) -> Unit)? = null,
) {
    Card(
        { onClick?.let { it(product) } },
        when(type) {
            SHORT -> modifier.size(114.dp, 149.dp)
            FULL -> modifier.size(174.dp, 221.dp)
        }, (true), RoundedCornerShape(10.dp),
        cardColors(Transparent)
    ) {
        Box(Modifier.fillMaxSize()) {
            ProdIcon(product.imageUrl)
            if(type == FULL) Avatar(
                Modifier
                    .align(TopStart)
                    .padding(7.dp)
            )
            product.discount?.let {
                if(type == FULL) Sale(
                    it, Modifier
                        .align(TopEnd)
                        .padding(7.dp)
                )
            }
            FullData(
                product, type,
                Modifier
                    .fillMaxHeight(
                        when(type) {
                            SHORT -> 0.4f
                            FULL -> 0.48f
                        }
                    )
                    .align(BottomStart)
            )
            Buttons(
                type, Modifier.align(BottomEnd),
                { onAddToFavourite?.let { it(product) } }
            ) { onAddToCart?.let { it(product) } }
        }
    }
}

@Composable
private fun ProdIcon(image: String) {
    Box {
        Image(
            if(LocalInspectionMode.current)
                painterResource(R.drawable.avatar)
            else rememberAsyncImagePainter(image),
            (null), Modifier.fillMaxSize(),
            contentScale = FillHeight,
        )
        Box(
            Modifier
                .align(BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Transparent,
                            Color(0x59000000)
                        ),
                    )
                )
        )
    }
}

@Composable
private fun FullData(
    product: ProductModel,
    type: CardType,
    modifier: Modifier,
) {
    Box(
        modifier.padding(
            start = when(type) {
                SHORT -> 7.dp
                FULL -> 10.dp
            }
        )
    ) {
        Column(Modifier.align(TopStart)) {
            Box(
                Modifier.background(
                    CatTrans,
                    RoundedCornerShape(
                        when(type) {
                            SHORT -> 8.dp
                            FULL -> 10.dp
                        }
                    )
                )
            ) {
                Text(
                    product.category,
                    Modifier.padding(8.dp, 2.dp),
                    style = when(type) {
                        SHORT -> catName
                        FULL -> saleCat
                    }
                )
            }
            Text(
                product.name,
                Modifier.width(100.dp),
                style = when(type) {
                    SHORT -> productName
                    FULL -> saleName
                }
            )
        }
        Text(
            ("$ ${
                product.price format when(type) {
                    SHORT -> "%.3f"
                    FULL -> "%.2f"
                }
            }"),
            Modifier
                .align(BottomStart)
                .width(100.dp)
                .padding(
                    bottom = when(type) {
                        SHORT -> 7.dp
                        FULL -> 12.dp
                    }
                ),
            style = when(type) {
                SHORT -> productPrice
                FULL -> salePrice
            }
        )
    }
}

@Composable
private fun Buttons(
    type: CardType,
    modifier: Modifier,
    onAddToFavourite: () -> Unit,
    onAddToCart: () -> Unit,
) {
    Row(
        when(type) {
            SHORT -> modifier.padding(5.dp)
            FULL -> modifier.padding(
                end = 4.dp,
                bottom = 7.dp
            )
        }, Start, CenterVertically
    ) {
        if(type == FULL) Box(
            Modifier
                .size(28.dp)
                .background(Platinum, CircleShape)
                .clickable { onAddToFavourite() },
            Center
        ) {
            Icon(
                painterResource(
                    R.drawable.ic_heart
                ), (null), Modifier.size(12.dp),
                FavCross
            )
        }
        Box(
            Modifier
                .padding(start = 5.dp)
                .size(
                    when(type) {
                        SHORT -> 20.dp
                        FULL -> 35.dp
                    }
                )
                .background(
                    FavTrans.copy(
                        alpha = when(type) {
                            SHORT -> 0.85f
                            FULL -> 1f
                        }
                    ), CircleShape
                )
                .clickable { onAddToCart() },
            Center
        ) {
            Icon(
                painterResource(
                    R.drawable.ic_plus
                ), (null), Modifier.size(
                    when(type) {
                        SHORT -> 7.dp
                        FULL -> 13.dp
                    }
                ), FavCross
            )
        }
    }
}

@Composable
private fun Avatar(
    modifier: Modifier = Modifier,
    avatar: String? = null,
) {
    Box(
        modifier
            .background(AlmostGray, CircleShape)
            .padding(1.dp)
    ) {
        Image(
            painter = avatar?.let {
                rememberAsyncImagePainter(avatar)
            } ?: painterResource(
                R.drawable.shop
            ), (null), Modifier
                .size(25.dp)
                .clip(CircleShape)
        )
    }
}

@Composable
private fun Sale(
    size: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier.background(
            Red, CircleShape
        )
    ) {
        Text(
            ("% $size off"), Modifier
                .padding(8.dp, 2.dp),
            style = salePrice.copy(
                color = White
            )
        )
    }
}