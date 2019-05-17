package id.kotlin.student.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/*")
class StudentController {

    @GetMapping("v1/hello")
    fun hello(): Map<String, String> {
        val map: HashMap<String, String> = HashMap()
        map["message"] = "Hello!"

        return map
    }
}