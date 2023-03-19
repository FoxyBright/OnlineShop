package com.satriaadhipradana.feature.presentation.ui.profile

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Arrangement.Start
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.layout.IntrinsicSize.Max
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.satriaadhipradana.shared.R
import com.satriaadhipradana.shared.theme.*
import com.satriaadhipradana.shared.theme.ExtraType.Companion.changePhoto
import com.satriaadhipradana.shared.theme.ExtraType.Companion.profileMenu
import com.satriaadhipradana.shared.theme.ExtraType.Companion.uploadButton

@Composable
fun ProfileMenuElement(
    text: Int,
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.ic_card,
    subItem: String? = null,
    onClick: () -> Unit,
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(
                start = 28.dp,
                end = 45.dp,
                bottom = 20.dp
            )
            .clickable(
                MutableInteractionSource(), (null)
            ) { onClick() }, SpaceBetween,
        CenterVertically
    ) {
        Row(Modifier, Start, CenterVertically) {
            Box(
                Modifier
                    .size(40.dp)
                    .background(Platinum, CircleShape),
                Center
            ) {
                Image(
                    painterResource(icon),
                    (null), Modifier.size(24.dp)
                )
            }
            Text(
                stringResource(text),
                Modifier.padding(start = 8.dp),
                style = profileMenu
            )
        }
        subItem?.let {
            if(it == "arrow") Icon(
                painterResource(
                    R.drawable.ic_arrow_right
                ), (null), Modifier.size(16.dp),
                DoubleDark
            ) else Text(
                ("$ $it"), Modifier,
                style = profileMenu
            )
        }
    }
}

@Composable
fun ProfileAvatar(
    avatar: String?,
    modifier: Modifier = Modifier,
    callback: ProfileCallback?,
) {
    Column(
        modifier.fillMaxWidth(),
        Top, CenterHorizontally
    ) {
        Box(
            Modifier
                .background(Asphalt, CircleShape)
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
                    .size(61.dp)
                    .clip(CircleShape),
                contentScale = Crop
            )
        }
        Text(
            stringResource(R.string.profile_change_photo),
            Modifier
                .padding(top = 6.dp, bottom = 17.dp)
                .clickable { callback?.onPhotoChange() },
            style = changePhoto
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ProfileUploadButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(
        onClick, modifier
            .fillMaxWidth()
            .height(Max)
            .padding(horizontal = 42.dp)
            .padding(bottom = 14.dp, top = 36.dp),
        shape = RoundedCornerShape(15.dp),
        colors = cardColors(colorScheme.primary)
    ) {
        Box(Modifier.fillMaxSize()) {
            Image(
                painterResource(R.drawable.ic_upload),
                (null), Modifier
                    .align(CenterStart)
                    .padding(start = 50.dp)
                    .size(15.dp)
            )
            Text(
                stringResource(R.string.profile_upload_button),
                Modifier.align(Center),
                style = uploadButton
            )
        }
    }
}