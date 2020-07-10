package com.rsk

import java.nio.file.Paths

fun main() {

    val postCode = USZipCode("12345")

    val logger: Logger = FileLogger(Paths.get("/some/file.log"))

    val meeting = Meeting ("Review", UkAddress("Remera", "Rukiri I", "Kigali", "Gasabo", UKPostCode("")), logger)
    val review = PersonalReview("Review Meeting", Participant(Name("Alice"), ""), listOf(), Room("Room I"), logger)

    println("Created: $review with name ${review.meetingName} at ${review.locationName}")

    review.closeReview()

    val name = Name("Joseph")
    val participant = Participant(name, "Joseph@You.com")

    meeting.addParticipant(participant)

}