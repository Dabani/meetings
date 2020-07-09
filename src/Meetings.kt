package com.rsk


open class Meeting(val meetingName: String, open val location: Location = Location()) {

    private val logger = Logger()

    open val locationName = ""

    fun addParticipant(participant: Participant) {
        if (verifyParticipant(participant))
            println("Added: \n name: ${participant.participantName}, email: ${participant.canonicalEmail}")
    }

    private fun verifyParticipant(participant: Participant) : Boolean {
        println("Try to verify")
        return  true
    }

    protected open fun verifyMeeting() {
        println("Review: verify meeting")
    }
}
