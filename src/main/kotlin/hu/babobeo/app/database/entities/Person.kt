package hu.babobeo.app.database.entities

import java.time.Instant
import javax.persistence.*

@Entity
@Table(schema = "public", name = "person")
class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(name = "first_name", nullable = false)
    var firstName: String,

    @Column(name = "last_name", nullable = false)
    var lastName: String,

    @Column(name = "dob", nullable = false)
    var dateOfBirth: Instant
)
