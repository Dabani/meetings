package com.rsk

import java.nio.file.Paths


open class Meeting(val meetingName: String, open val location: Location, val logger: Logger) {

//    private val logger : Logger = FileLogger(Paths.get("/some/file.log"))

    open val locationName = ""

    fun addParticipant(participant: Participant) {
        logger.info("Participant added")
        if (verifyParticipant(participant))
            println("Added: \n name: ${participant.participantName}, email: ${participant.canonicalEmail}")
    }

    private fun verifyParticipant(participant: Participant) : Boolean {
        println("Try to verify")
        return  true
    }

    protected open fun verifyMeeting() {
        println("Meeting: verify meeting")
    }
}
