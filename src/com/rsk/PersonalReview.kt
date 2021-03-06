package com.rsk

class PersonalReview(meetingName: String, val employee: Participant, reviewers: List<Participant>, override  val location: Room, logger: Logger) : Meeting(meetingName, location, logger) {

    override val locationName: String
        get() = location.roomName

    fun closeReview(){
        println("Review ended!")
        verifyMeeting()
    }

    override fun verifyMeeting() {
        println("PersonalReview: verify meeting")
        super.verifyMeeting()
    }
}