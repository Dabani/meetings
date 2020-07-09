package com.rsk

class PersonalReview(meetingName: String, val employee: Participant, reviewers: List<Participant>, location: Location = Location("")) : Meeting(meetingName, location) {

    fun closeReview(){
        println("Review ended!")
        verifyMeeting()
    }

    override fun verifyMeeting() {
        println("PersonalReview: verify meeting")
        super.verifyMeeting()
    }
}