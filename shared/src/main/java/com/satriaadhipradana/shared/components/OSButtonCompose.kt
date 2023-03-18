package com.satriaadhipradana.shared.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.theme.ExtraType.Companion.button
import com.satriaadhipradana.shared.theme.OSTheme

@Preview
@Composable
private fun OSButtonPreview() {
    OSTheme {
        OSButton(stringResource(R.string.login_button))
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun OSButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
) {
    Card(
        { onClick?.let { it() } },
        modifier, enabled,
        RoundedCornerShape(15.dp),
        cardColors(colorScheme.primary)
    ) {
        Box(Modifier.fillMaxWidth(), Center) {
            Text(
                text, Modifier.padding(vertical = 14.dp),
                color = colorScheme.onPrimary,
                style = button,
                fontWeight = Bold
            )
        }
    }
}