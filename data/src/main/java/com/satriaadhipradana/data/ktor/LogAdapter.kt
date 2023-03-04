package com.satriaadhipradana.data.ktor

import android.util.Log
import io.ktor.client.plugins.logging.Logger

object LogAdapter: Logger {
    override fun log(message: String) {
        Log.v(message, "KTOR")
    }
}