package hu.babobeo.app.database.mappers

import hu.babobeo.app.database.dto.ExistingPersonDto
import hu.babobeo.app.database.dto.NewPersonDto
import hu.babobeo.app.database.entities.Person
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface PersonMapper {

    fun entityToDatamodel(person: Person): ExistingPersonDto

    @Mapping(target = "id", ignore = true)
    fun newDatamodelToEntity(existingPersonDto: NewPersonDto): Person

    fun datamodelToEntity(existingPersonDto: ExistingPersonDto): Person
}