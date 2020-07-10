package com.rsk

import java.lang.IllegalArgumentException
import java.util.regex.Matcher
import java.util.regex.Pattern

abstract class PostalCode(val postCode: String) {
    abstract fun verify()

    init {
        verify()
    }
}

class USZipCode(zipCode: String) : PostalCode(zipCode) {

    override fun verify() {
        val pattern : Pattern = Pattern.compile("^[0-9]{5}(?:-[0-9]{4})?$")
        val matcher : Matcher = pattern.matcher(postCode)
        if(!matcher.matches()) throw IllegalArgumentException()
    }

}

class UKPostCode(postCode: String) : PostalCode(postCode) {

    override fun verify() {

    }
}