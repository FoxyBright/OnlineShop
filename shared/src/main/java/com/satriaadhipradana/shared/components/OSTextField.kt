package com.satriaadhipradana.shared.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.theme.ExtraType.Companion.textField

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun OSTextField(
    text: String,
    placeHolder: String,
    modifier: Modifier = Modifier,
    eyeState: Boolean = false,
    hide: Boolean = false,
    eyeClick: (() -> Unit)? = null,
    onTextChange: (String) -> Unit,
) {
    val focus = remember { FocusRequester() }
    Card(
        { focus.requestFocus() }, modifier
            .fillMaxWidth()
            .height(29.dp),
        (true), CircleShape,
        cardColors(colorScheme.primaryContainer)
    ) {
        Box(Modifier.fillMaxSize(), Center) {
            TextField(
                text, { onTextChange(it) }, hide,
                focus, eyeState, placeHolder
            )
            eyeClick?.let {
                EyeButton(
                    Modifier
                        .align(CenterEnd)
                        .padding(end = 15.dp),
                    eyeState, it
                )
            }
        }
    }
}

@Composable
private fun TextField(
    text: String,
    onTextChange: (String) -> Unit,
    hide: Boolean,
    focus: FocusRequester,
    eyeState: Boolean,
    placeHolder: String,
    modifier: Modifier = Modifier,
) {
    val style = textField
    BasicTextField(
        text, {
            if(it.length <= 30) onTextChange(it)
        }, modifier
            .fillMaxWidth()
            .background(Transparent)
            .focusRequester(focus)
            .padding(horizontal = 6.dp),
        textStyle = style, maxLines = 1,
        singleLine = true,
        visualTransformation = if(!hide || eyeState)
            VisualTransformation.None
        else PasswordVisualTransformation(),
        decorationBox = {
            if(text.isEmpty()) {
                Text(
                    placeHolder,
                    style = style.copy(Gray)
                )
            }; it()
        }
    )
}

@Composable
private fun EyeButton(
    modifier: Modifier = Modifier,
    state: Boolean,
    onClick: () -> Unit,
) {
    Image(
        painterResource(
            R.drawable.ic_eye_off
        ), (null), modifier
            .size(15.dp)
            .clickable { onClick() },
        colorFilter = if(state)
            tint(colorScheme.primary)
        else null
    )
}