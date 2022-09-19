package hu.babobeo.app.services

import hu.babobeo.app.database.dto.ExistingPersonDto
import hu.babobeo.app.database.dto.NewPersonDto
import hu.babobeo.app.database.dto.dtoalias.DisplayPerson
import hu.babobeo.app.database.mappers.PersonMapper
import hu.babobeo.app.database.repositories.PersonRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PersonService(val personRepository: PersonRepository, val personMapper: PersonMapper) {

    fun getPersonForId(id: Long): DisplayPerson {
        return personRepository.findById(id)
                .map { personMapper.entityToDatamodel(it) }
                .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "PersonEntity not found!") }
    }

    fun findAll(): List<ExistingPersonDto> {
        return personRepository.findAll()
                .map { personMapper.entityToDatamodel(it) }
    }

    fun save(newPersonDto: NewPersonDto): DisplayPerson {
        return personMapper.newDatamodelToEntity(newPersonDto)
                .run { personRepository.save(this) }
                .let { personMapper.entityToDatamodel(it) }
    }

    fun update(displayPerson: DisplayPerson): DisplayPerson {
        return personMapper.datamodelToEntity(displayPerson)
                .run { personRepository.save(this) }
                .let { personMapper.entityToDatamodel(it) }
    }

    fun delete(id: Long) {
        try {
            personRepository.deleteById(id)
        } catch (ex: EmptyResultDataAccessException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "PersonEntity not found so it can not be deleted!")
        }
    }
}