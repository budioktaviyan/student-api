package id.kotlin.student.controller

import id.kotlin.student.model.Student
import id.kotlin.student.service.StudentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/*")
class StudentController(private val service: StudentService) {

    @GetMapping("v1/hello")
    fun hello(): Map<String, String> {
        val map: HashMap<String, String> = HashMap()
        map["message"] = "Hello!"

        return map
    }

    @GetMapping("/v1/student")
    fun student(): Map<String, List<Student>> {
        val student = service.student()
        val map: HashMap<String, List<Student>> = HashMap()
        map["data"] = student

        return map
    }

    @GetMapping("/v1/student/{id}")
    fun studentById(@PathVariable id: Long): Map<String, Student> {
        val student = service.studentById(id)
        val map: HashMap<String, Student> = HashMap()
        map["data"] = student

        return map
    }

    @GetMapping("/v1/student/search")
    fun studentByEmail(@RequestParam email: String): Map<String, Student> {
        val student = service.studentByEmail(email)
        val map: HashMap<String, Student> = HashMap()
        map["data"] = student

        return map
    }

    @PostMapping("v1/student")
    fun add(@RequestBody student: Student): Map<String, String> {
        service.add(student)

        val map: HashMap<String, String> = HashMap()
        map["message"] = "Success"

        return map
    }
}