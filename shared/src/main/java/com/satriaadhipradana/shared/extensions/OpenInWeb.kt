package com.satriaadhipradana.shared.extensions

import android.content.Context
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import android.net.Uri
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat.startActivity

fun openInWeb(context: Context, uri: String) =
    openInWeb(context, Uri.parse(uri))

fun openInWeb(
    context: Context, uri: Uri,
) = CustomTabsIntent
    .Builder()
    .setUrlBarHidingEnabled(true)
    .setDefaultColorSchemeParams(
        CustomTabColorSchemeParams
            .Builder()
            .build()
    )
    .build()
    .let {
        it.intent.data = uri
        it.intent.addFlags(
            FLAG_ACTIVITY_NO_HISTORY
        )
        startActivity(
            context, it.intent,
            it.startAnimationBundle
        )
    }