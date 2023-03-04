package com.satriaadhipradana.feature

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.satriaadhipradana.domain.PageOneViewModel

@Composable
fun MainScreen(
    vm: PageOneViewModel,
    modifier: Modifier = Modifier,
) {
    
    val latest by vm.latest.collectAsState()
    
    LaunchedEffect(Unit) {
        vm.getLatest()
    }
    
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        items(latest) {
            Image(it.imageUrl)
            Item(it.category)
            Item(it.name)
            Item(it.price.toString())
            Item(it.discount.toString())
            Spacer(Modifier.height(10.dp))
        }
    }
}

@Composable
private fun Image(imageUrl: String) {
    AsyncImage(
        imageUrl, (null), Modifier
            .fillMaxWidth()
            .height(100.dp),
        contentScale = Crop
    )
}

@Composable
private fun Item(text: String) {
    Text(
        text, Modifier,
        color = colorScheme.tertiary
    )
}