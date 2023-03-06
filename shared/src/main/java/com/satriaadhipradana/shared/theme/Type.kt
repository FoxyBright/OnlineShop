package com.satriaadhipradana.shared.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.sp
import com.satriaadhipradana.shared.R

private val montserratFamily = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_italic, style = FontStyle.Italic),
)

private val montserratTextStyle = TextStyle(fontFamily = montserratFamily)

val MontserratTypo = Typography(
    /*      SMALL TYPOGRAPHY      */
    bodySmall = montserratTextStyle.copy(),
    displaySmall = montserratTextStyle.copy(fontSize = 8.sp, fontWeight = FontWeight.Medium, lineHeight = 10.sp),
    titleSmall = montserratTextStyle.copy(fontSize = 10.sp, fontWeight = FontWeight.Medium, lineHeight = 12.sp),
    headlineSmall = montserratTextStyle.copy(fontSize = 12.sp, fontWeight = FontWeight.Medium, lineHeight = 16.sp),
    labelSmall = montserratTextStyle.copy(fontSize = 14.sp, fontWeight = FontWeight.Medium, lineHeight = 18.sp),
    
    /*      MEDIUM TYPOGRAPHY      */
    bodyMedium = montserratTextStyle.copy(fontSize = 16.sp, fontWeight = FontWeight.Medium, lineHeight = 20.sp),
    headlineMedium = montserratTextStyle.copy(),
    labelMedium = montserratTextStyle.copy(),
    titleMedium = montserratTextStyle.copy(),
    displayMedium = montserratTextStyle.copy(),
    
    /*      LARGE TYPOGRAPHY      */
    bodyLarge = montserratTextStyle.copy(fontSize = 18.sp, fontWeight = FontWeight.Bold, lineHeight = 22.sp),
    labelLarge = montserratTextStyle.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold, lineHeight = 20.sp),
    headlineLarge = montserratTextStyle.copy(fontSize = 22.sp, fontWeight = FontWeight.Bold, lineHeight = 22.sp),
    displayLarge = montserratTextStyle.copy(fontSize = 24.sp, fontWeight = FontWeight.Bold, lineHeight = 32.sp),
    titleLarge = montserratTextStyle.copy(fontSize = 28.sp, fontWeight = FontWeight.Bold, lineHeight = 32.sp)
)