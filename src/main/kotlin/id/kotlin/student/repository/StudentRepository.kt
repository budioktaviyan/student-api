package id.kotlin.student.repository

import id.kotlin.student.model.Student
import org.springframework.data.repository.CrudRepository

interface StudentRepository : CrudRepository<Student, Long> {

    fun findStudentById(id: Long): Student

    fun findStudentByEmail(email: String): Student
}