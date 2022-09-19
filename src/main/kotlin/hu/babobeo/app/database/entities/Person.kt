package hu.babobeo.app.database.entities

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "public", name = "person")
class Person(
        @Column(name = "first_name", nullable = false)
        var firstName: String,

        @Column(name = "last_name", nullable = false)
        var lastName: String,

        @Column(name = "dob", nullable = false)
        var dateOfBirth: Instant,

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null
)
