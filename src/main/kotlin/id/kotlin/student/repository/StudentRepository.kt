package id.kotlin.student.repository

import id.kotlin.student.model.Student
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

@Transactional
interface StudentRepository : CrudRepository<Student, Long> {

    fun findStudentById(id: Long): Student

    fun findStudentByEmail(email: String): Student

    @Modifying
    @Query("UPDATE Student student SET student.name=:name, student.email=:email WHERE student.id=:id")
    fun update(
            @Param("id") id: Long,
            @Param("name") name: String,
            @Param("email") email: String
    )
}