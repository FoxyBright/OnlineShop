package com.satriaadhipradana.shared.theme

import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
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
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_light, Light),
    Font(R.font.montserrat_medium, Medium),
    Font(R.font.montserrat_semi_bold, SemiBold),
    Font(R.font.montserrat_bold, Bold),
    Font(R.font.montserrat_italic, style = Italic),
)

private val poppinsTextStyle = TextStyle(fontFamily = poppinsFamily)
private val montserratTextStyle = TextStyle(fontFamily = montserratFamily)

class ExtraType {
    companion object {
        
        val button = montserratTextStyle.copy(
            fontSize = 14.sp,
            fontWeight = Bold,
        )
        
        val uploadButton = button.copy(
            fontWeight = SemiBold
        )
        
        val appName = montserratTextStyle.copy(
            color = Black,
            fontSize = 20.sp,
            fontWeight = Bold,
            textAlign = Center
        )
        
        val changePhoto = montserratTextStyle.copy(
            fontSize = 8.sp,
            fontWeight = Medium,
            color = LightGray
        )
        
        val location = poppinsTextStyle.copy(
            color = EggGray,
            fontSize = 10.sp,
            fontWeight = Medium
        )
        
        val external = montserratTextStyle.copy(
            fontSize = 12.sp,
            fontWeight = Medium,
        )
        
        val profileName = montserratTextStyle.copy(
            fontSize = 15.sp,
            fontWeight = Bold,
            color = DarkGray,
            textAlign = Center
        )
        
        val profileTitle = profileName.copy(
            color = Black
        )
        
        val profileMenu = montserratTextStyle.copy(
            fontSize = 14.sp,
            fontWeight = Medium,
            color = DoubleDark
        )
        
        val hasAccount = montserratTextStyle.copy(
            fontSize = 10.sp,
            fontWeight = Medium,
        )
        
        val loginTitle = montserratTextStyle.copy(
            fontSize = 26.sp,
            fontWeight = SemiBold,
        )
        
        val category = poppinsTextStyle.copy(
            color = Gray49,
            fontSize = 8.sp,
            fontWeight = Medium
        )
        
        val groupName = poppinsTextStyle.copy(
            color = DoubleDark,
            fontSize = 15.sp,
            fontWeight = Medium
        )
        
        val catName = poppinsTextStyle.copy(
            color = CatName,
            fontSize = 6.sp,
            fontWeight = SemiBold
        )
        
        val productName = poppinsTextStyle.copy(
            color = White,
            fontSize = 9.sp,
            fontWeight = SemiBold
        )
    
        val productPrice = productName.copy(
            fontSize = 7.sp
        )
    
        val saleCat = catName.copy(
            fontSize = 9.sp
        )
    
        val salePrice = productPrice.copy(
            fontSize = 10.sp
        )
        
        val saleName = productName.copy(
            fontSize = 13.sp
        )
        
        val viewAll = poppinsTextStyle.copy(
            color = LightGray,
            fontSize = 9.sp,
            fontWeight = Medium
        )
        
        val search = poppinsTextStyle.copy(
            fontSize = 9.sp,
            fontWeight = Medium,
            textAlign = Center,
            color = Black
        )
        
        val textField = montserratTextStyle.copy(
            fontSize = 11.sp,
            fontWeight = Medium,
            textAlign = Center,
            color = Black
        )
    }
}