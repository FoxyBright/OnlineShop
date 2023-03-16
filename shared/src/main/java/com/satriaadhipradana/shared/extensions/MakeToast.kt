package com.satriaadhipradana.shared.extensions

import android.content.Context
import android.widget.Toast

fun makeToast(
    context: Context,
    text: String,
) {
    Toast.makeText(
        context, text,
        Toast.LENGTH_SHORT
    ).show()
}

fun notImpl(context: Context) {
    makeToast(context, "Functionality not implemented")
}