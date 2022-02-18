package hu.babobeo.app.controllers

import hu.babobeo.app.database.dto.PersonDto
import hu.babobeo.app.database.entities.Person
import hu.babobeo.app.services.PersonService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class HtmlController(val personService: PersonService) {
    @GetMapping("/")
    @ResponseBody
    fun greeting(): String {
        return "Hello there, this is the babobeo api!"
    }

    @GetMapping("/person/{id}")
    @ResponseBody
    fun findById(@PathVariable id: Long): PersonDto {
        return personService.getPersonForId(id)
    }

    @GetMapping("/person")
    @ResponseBody
    fun findAll(): List<Person> {
        return personService.findAll()
    }
}