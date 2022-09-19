package hu.babobeo.app.database.dto

import java.time.Instant

data class ExistingPersonDto(val id: Long, val firstName: String, val lastName: String, val dateOfBirth: Instant)
data class NewPersonDto(val firstName: String, val lastName: String, val dateOfBirth: Instant)
