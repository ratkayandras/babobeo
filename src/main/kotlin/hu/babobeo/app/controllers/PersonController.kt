package hu.babobeo.app.controllers

import hu.babobeo.app.database.dto.NewPersonDto
import hu.babobeo.app.database.dto.dtoalias.DisplayPerson
import hu.babobeo.app.services.PersonService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/person")
class PersonController(val personService: PersonService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): DisplayPerson {
        return personService.getPersonForId(id)
    }

    @GetMapping("/")
    fun findAll(): List<DisplayPerson> {
        return personService.findAll()
    }

    @PostMapping("/")
    @ResponseBody
    fun savePerson(@RequestBody person: NewPersonDto): DisplayPerson {
        return personService.save(person)
    }

    @PutMapping("/")
    @ResponseBody
    fun updatePerson(@RequestBody person: DisplayPerson): DisplayPerson {
        if (person.id <= 0) {
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Person with id 0/NULL can not be updated!")
        }
        return personService.update(person)
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    fun deletePerson(@PathVariable id: Long) {
        personService.delete(id)
    }
}