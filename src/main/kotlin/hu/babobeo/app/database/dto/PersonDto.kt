package hu.babobeo.app.database.dto

import java.time.Instant

data class PersonDto(val firstName: String, val lastName: String, val dateOfBirth: Instant)
