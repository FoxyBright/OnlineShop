package com.satriaadhipradana.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satriaadhipradana.shared.R.drawable.*
import com.satriaadhipradana.shared.theme.*

@Preview
@Composable
private fun NavBarPreview() {
    OSTheme { OSNavBar(4) {} }
}
@Composable
fun OSNavBar(
    selected: Int,
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit,
) {
    Box(
        modifier
            .fillMaxWidth()
            .background(
                White,
                RoundedCornerShape(26.dp, 26.dp)
            )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            SpaceBetween, CenterVertically
        ) {
            listOf(
                ic_home, ic_heart, ic_cart,
                ic_chat, ic_profile,
            ).forEachIndexed { i, it ->
                NavItem(
                    state = selected == i,
                    icon = it, Modifier.padding(
                        vertical = 12.dp
                    )
                ) { onItemClick(i) }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun NavItem(
    state: Boolean,
    icon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        { onClick() },
        modifier.size(40.dp), (true),
        CircleShape, cardColors(
            if(state) Platinum
            else Transparent
        )
    ) {
        Box(Modifier.fillMaxSize(), Center) {
            Icon(
                painterResource(icon),
                (null), Modifier.size(16.dp),
                tint = if(state) Gray51 else Gray50
            )
        }
    }
}