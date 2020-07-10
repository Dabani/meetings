package com.rsk

class Participant(val name: Name, val email: String) {

    val participantName: String
        get() = name.name

    val canonicalEmail: String
        get() = email.toUpperCase()
}
