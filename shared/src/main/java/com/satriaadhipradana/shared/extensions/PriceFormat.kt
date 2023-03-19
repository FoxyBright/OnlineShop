package com.satriaadhipradana.shared.extensions

import java.util.Locale

infix fun Float.format(filter: String) =
    filter.format(Locale("RU"), this)