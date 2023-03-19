package com.satriaadhipradana.feature.presentation.ui.pageone.components

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Arrangement.Start
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.satriaadhipradana.feature.presentation.ui.pageone.PageOneCallback
import com.satriaadhipradana.feature.presentation.ui.pageone.PageOneState
import com.satriaadhipradana.feature.presentation.ui.pageone.components.CardType.FULL
import com.satriaadhipradana.feature.presentation.ui.pageone.components.CardType.SHORT
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.model.CategoryModel
import com.satriaadhipradana.shared.model.CategoryModel.Companion.list
import com.satriaadhipradana.shared.model.ProductModel
import com.satriaadhipradana.shared.theme.ExtraType.Companion.appName
import com.satriaadhipradana.shared.theme.ExtraType.Companion.category
import com.satriaadhipradana.shared.theme.ExtraType.Companion.groupName
import com.satriaadhipradana.shared.theme.ExtraType.Companion.location
import com.satriaadhipradana.shared.theme.ExtraType.Companion.viewAll
import com.satriaadhipradana.shared.theme.Moused
import com.satriaadhipradana.shared.theme.OSBlack
import com.satriaadhipradana.shared.theme.Platinum

@Composable
fun PageOneTopBarData(
    state: PageOneState,
    modifier: Modifier = Modifier,
    callback: PageOneCallback?,
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(
                top = 24.dp,
                start = 15.dp,
                end = 37.dp
            ),
    ) {
        Icon(
            painterResource(
                R.drawable.ic_menu
            ), (null), Modifier
                .size(24.dp)
                .clickable { callback?.onMenuClick() },
            Color.Black
        )
        TopName(modifier.weight(1f))
        Avatar(
            state.profile?.avatar,
            Modifier, callback
        )
    }
}

@Composable
fun TopName(modifier: Modifier) {
    val style = appName
    val text = buildAnnotatedString {
        append(stringResource(R.string.page_one_title_prefix) + " ")
        withStyle(style.copy(colorScheme.primary).toSpanStyle()) {
            append(stringResource(R.string.page_one_title_suffix))
        }
    }
    Text(text, modifier.padding(top = 2.dp), style = style)
}

@Composable
private fun Avatar(
    avatar: String?,
    modifier: Modifier = Modifier,
    callback: PageOneCallback?,
) {
    Column(modifier, Top, CenterHorizontally) {
        Box(
            Modifier
                .background(Moused, CircleShape)
                .padding(1.dp)
        ) {
            Image(
                painter = avatar?.let {
                    rememberAsyncImagePainter(
                        Uri.parse(avatar)
                    )
                } ?: painterResource(
                    R.drawable.avatar
                ), (null), Modifier
                    .size(31.dp)
                    .clip(CircleShape)
                    .clickable { callback?.onProfileClick() },
                contentScale = Crop
            )
        }
        Row(Modifier.padding(top = 7.dp), Start, Alignment.Top) {
            Text(
                stringResource(R.string.page_one_location),
                Modifier.clickable {
                    callback?.onLocationClick()
                }, style = location
            )
            Icon(
                painterResource(
                    R.drawable.ic_down_arrow
                ), (null), Modifier
                    .padding(top = 5.dp, start = 2.dp)
                    .size(6.dp),
                Moused
            )
        }
    }
}

@Composable
fun Categories(
    modifier: Modifier = Modifier,
    onCategoryClick: (CategoryModel) -> Unit,
) {
    LazyRow(
        modifier.fillMaxWidth(),
        horizontalArrangement = SpaceBetween
    ) {
        items(list) {
            CategoryItem(
                it.name, it.icon
            ) { onCategoryClick(it) }
        }
    }
}

@Composable
private fun CategoryItem(
    name: Int, icon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Column(
        modifier.clickable(
            MutableInteractionSource(), (null),
        ) { onClick() }, Top, CenterHorizontally
    ) {
        Box(
            Modifier
                .size(42.dp, 38.dp)
                .background(Platinum, CircleShape),
            Center
        ) {
            Icon(
                painterResource(icon),
                (null), Modifier, OSBlack
            )
        }
        Text(
            stringResource(name),
            Modifier.padding(top = 11.dp),
            style = category
        )
    }
}

@Composable
fun Group(
    name: String,
    modifier: Modifier = Modifier,
    onViewAllClick: () -> Unit,
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 11.dp),
        SpaceBetween, CenterVertically
    ) {
        Text(
            name, Modifier,
            style = groupName
        )
        Text(
            stringResource(R.string.page_one_view_all_button),
            Modifier.clickable {
                onViewAllClick()
            }, style = viewAll
        )
    }
}

@Composable
fun ProductList(
    latest: List<ProductModel>,
    modifier: Modifier = Modifier,
    onAddToCart: (ProductModel) -> Unit,
    onAddToFavourite: ((ProductModel) -> Unit)? = null,
    onClick: (ProductModel) -> Unit,
) {
    LazyRow(modifier.fillMaxWidth()) {
        item { Spacer(Modifier.width(12.dp)) }
        items(latest) { product ->
            onAddToFavourite.let { add ->
                val type = add?.let { FULL } ?: SHORT
                ProductCard(
                    product, Modifier.padding(
                        end = if(type == FULL) 9.dp else 12.dp
                    ), type, { add?.let { p -> p(it) } },
                    { onAddToCart(it) })
                { onClick(it) }
            }
        }
    }
}