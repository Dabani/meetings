package com.rsk

fun main() {
    val meeting = Meeting ("Review", UkAddress("Remera", "Rukiri I", "Kigali", "Gasabo","2020"))
    val review = PersonalReview("Review Meeting", Participant(Name("Alice"), ""), listOf(), Room("Room I"))

    println("Created: $review with name ${review.meetingName} at ${review.locationName}")

    review.closeReview()

    val name = Name("Joseph")
    val participant = Participant(name, "Joseph@You.com")

    meeting.addParticipant(participant)

}