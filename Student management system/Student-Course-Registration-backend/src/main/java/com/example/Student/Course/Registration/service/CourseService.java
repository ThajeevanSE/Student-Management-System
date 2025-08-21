package com.example.Student.Course.Registration.service;

import com.example.Student.Course.Registration.model.Course;
import com.example.Student.Course.Registration.model.CourseRegistration;
import com.example.Student.Course.Registration.repository.CourseRegitryRepo;
import com.example.Student.Course.Registration.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
 @Autowired
 CourseRepo courseRepo;
 @Autowired
 CourseRegitryRepo courseRegitryRepo;
  public  List<Course> availableCourses() {

            return courseRepo.findAll();
    }

    public List<CourseRegistration> getCourseRegistredList() {
      return courseRegitryRepo.findAll();
    }

    public void entrolStudent(String name, String emailId, String courseName) {
      CourseRegistration courseRegistration = new CourseRegistration(name,emailId,courseName);
      courseRegitryRepo.save(courseRegistration);
    }
}
