package com.rsk

class Name(val name: String) {
    init {
            if(name.isBlank()) throw IllegalArgumentException()
        }
}