package hu.babobeo.app.database.mappers

import hu.babobeo.app.database.dto.PersonDto
import hu.babobeo.app.database.entities.Person
import org.mapstruct.Mapper

@Mapper
interface PersonMapper {

    fun entityToDatamodel(person: Person): PersonDto
}