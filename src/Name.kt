package com.rsk

class Name {
    var name: String = ""
        set(value: String) {
            if(value.isNullOrBlank()) throw IllegalArgumentException()
            field = value
        }
}