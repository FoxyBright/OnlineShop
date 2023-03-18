package com.satriaadhipradana.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.theme.EggGray
import com.satriaadhipradana.shared.theme.ExtraType.Companion.search
import com.satriaadhipradana.shared.theme.Ohra

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun OSSearch(
    text: String,
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit,
) {
    val focus = remember { FocusRequester() }
    Card(
        { focus.requestFocus() }, modifier
            .fillMaxWidth()
            .height(24.dp),
        (true), CircleShape,
        cardColors(Ohra)
    ) {
        Box(Modifier.fillMaxSize(), Center) {
            TextField(text, focus) { onTextChange(it) }
            Icon(
                painterResource(
                    R.drawable.ic_search
                ), (null),
                Modifier
                    .align(CenterEnd)
                    .padding(end = 16.dp),
                EggGray
            )
        }
    }
}

@Composable
private fun TextField(
    text: String,
    focus: FocusRequester,
    onTextChange: (String) -> Unit,
) {
    val style = search
    BasicTextField(
        text, {
            if(it.length <= 30) onTextChange(it)
        }, Modifier
            .fillMaxWidth()
            .background(Transparent)
            .focusRequester(focus)
            .padding(horizontal = 6.dp),
        textStyle = style, maxLines = 1,
        singleLine = true,
        decorationBox = {
            if(text.isEmpty()) Text(
                stringResource(R.string.page_one_search_placeholder),
                style = style.copy(EggGray)
            ); it()
        }
    )
}