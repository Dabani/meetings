package com.rsk

class PersonalReview(meetingName: String, val employee: Participant, reviewers: List<Participant>, override  val location: Room) : Meeting(meetingName, location) {

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