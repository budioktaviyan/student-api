package id.kotlin.student.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.AUTO
import javax.persistence.Id

@Entity
data class Student(
        @Id
        @GeneratedValue(strategy = AUTO)
        val id: Long,
        val name: String,
        val email: String
)