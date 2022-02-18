package hu.babobeo.app.services

import hu.babobeo.app.database.dto.PersonDto
import hu.babobeo.app.database.entities.Person
import hu.babobeo.app.database.mappers.PersonMapper
import hu.babobeo.app.database.repositories.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(val personRepository: PersonRepository, val personMapper: PersonMapper) {

    fun getPersonForId(id: Long): PersonDto {
        return personRepository.getById(id)
            .let { personMapper.entityToDatamodel(it) }
    }

    fun findAll(): List<Person> {
        return personRepository.findAll();
    }
}