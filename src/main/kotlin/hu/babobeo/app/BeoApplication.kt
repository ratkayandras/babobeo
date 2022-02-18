package hu.babobeo.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BeoApplication

fun main(args: Array<String>) {
	runApplication<BeoApplication>(*args)
}
