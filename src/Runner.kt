package com.rsk

fun main() {
    val meeting = Meeting ("Review")

    println("Created: $meeting with name ${meeting.meetingName}")
    val name = Name()
    name.name = "Joseph"
    val participant = Participant(name, "Joseph@You.com")
    /*
    participant.name = name
    participant.email = "Joseph@You.com" */

    meeting.addParticipant(participant)
    // meeting.meetingName = "Review"
    // meeting.verifyParticipant("Joseph") => not accessible
    // meeting.verifyMeeting() => not accessible
    // meeting.logger

}