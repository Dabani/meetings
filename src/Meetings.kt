package com.rsk


class Meeting(val meetingName: String, val location: Location = Location("")) {

    private val logger = Logger()

    fun addParticipant(participant: Participant) {
        if (verifyParticipant(participant))
            println("Added: \n name: ${participant.participantName}, email: ${participant.canonicalEmail}")
    }

    private fun verifyParticipant(participant: Participant) : Boolean {
        println("Try to verify")
        return  true
    }

    protected fun verifyMeeting() {

    }
}

class Location(val address: String){

}
