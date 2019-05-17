package id.kotlin.student.service

import id.kotlin.student.model.Student
import id.kotlin.student.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(private val repository: StudentRepository) {

    fun student(): List<Student> = repository.findAll().map { it }

    fun studentById(id: Long): Student = repository.findStudentById(id)

    fun studentByEmail(email: String): Student = repository.findStudentByEmail(email)

    fun add(student: Student) {
        repository.save(student)
    }
}