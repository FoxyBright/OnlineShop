package com.satriaadhipradana.shared.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.sp
import com.satriaadhipradana.shared.R

private val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, Bold),
    Font(R.font.poppins_italic, style = FontStyle.Italic),
)

private val montserratFamily = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, Bold),
    Font(R.font.poppins_italic, style = FontStyle.Italic),
)

private val poppinsTextStyle = TextStyle(fontFamily = poppinsFamily)
private val montserratTextStyle = TextStyle(fontFamily = poppinsFamily)

data class ExtraType(
    
    val button: TextStyle = montserratTextStyle.copy(
        fontSize = 14.sp,
        fontWeight = Bold,
    ),
    
    val title: TextStyle = poppinsTextStyle.copy(
        fontSize = 46.sp,
        fontWeight = Bold,
        lineHeight = 56.sp
    ),
)