package com.satriaadhipradana.shared.extensions

fun emailControl(text: String): Boolean {
    var at = text.indexOf('@')
    var point = text.lastIndexOf('.')
    
    return at > 0 && point > 0
            && text.filter { it == '@' }.length == 1
            && text.substring(0 until at)
        .let { if(it.contains(" ")) 0 else it.length } >= 3
            && text.substring(++at until point)
        .let { if(it.contains(" ")) 0 else it.length } >= 3
            && text.substring(++point until text.length)
        .let { if(it.contains(" ")) 0 else it.length } >= 2
}