package com.satriaadhipradana.shared.theme

import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.unit.sp
import com.satriaadhipradana.shared.R

private val poppinsFamily = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_light, Light),
    Font(R.font.poppins_medium, Medium),
    Font(R.font.poppins_semi_bold, SemiBold),
    Font(R.font.poppins_bold, Bold),
    Font(R.font.poppins_italic, style = Italic),
)

private val montserratFamily = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_light, Light),
    Font(R.font.poppins_medium, Medium),
    Font(R.font.poppins_semi_bold, SemiBold),
    Font(R.font.poppins_bold, Bold),
    Font(R.font.poppins_italic, style = Italic),
)

private val poppinsTextStyle = TextStyle(fontFamily = poppinsFamily)
private val montserratTextStyle = TextStyle(fontFamily = poppinsFamily)

class ExtraType {
    companion object {
        
        val button = montserratTextStyle.copy(
            fontSize = 14.sp,
            fontWeight = Bold,
        )
        
        val external = montserratTextStyle.copy(
            fontSize = 12.sp,
            fontWeight = Medium,
        )
        
        val hasAccount = montserratTextStyle.copy(
            fontSize = 10.sp,
            fontWeight = Medium,
        )
        
        val loginTitle = montserratTextStyle.copy(
            fontSize = 26.sp,
            fontWeight = SemiBold,
        )
        
        val textField = montserratTextStyle.copy(
            fontSize = 11.sp,
            fontWeight = Medium,
            textAlign = Center,
            color = Black
        )
    }
}