package com.example.Student.Course.Registration.controller;

import com.example.Student.Course.Registration.model.Course;
import com.example.Student.Course.Registration.model.CourseRegistration;
import com.example.Student.Course.Registration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins="http://localhost:5500")
public class CourseController {
    @Autowired
    CourseService courseService;
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/courses")
    public List<Course> availableCourses(){
           return courseService.availableCourses();
       }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/students")
    public List<CourseRegistration> getCourseRegistredList(){
        return courseService.getCourseRegistredList();
    }
    @PostMapping("/courses/regiter")
    public ResponseEntity<String> regiterCourse(@RequestParam("name") String name,
                                                @RequestParam("emailId") String emailId,
                                                @RequestParam("courseName") String courseName){
        courseService.entrolStudent(name,emailId,courseName);
        String msg = "Congratulations " + name + " enrollment successfully done for " + courseName;
        return ResponseEntity.ok(msg); // ensures status 200
    }


}
