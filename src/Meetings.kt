package com.rsk


class Meeting(val meetingName: String) {
    /*
    constructor(meetingName: String){
        this.meetingName = meetingName
    }
*/
    private val logger = Logger()

//    val meetingName: String

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
