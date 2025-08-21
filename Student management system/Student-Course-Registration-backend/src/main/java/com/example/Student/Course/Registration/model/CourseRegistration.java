package com.example.Student.Course.Registration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Name;
    private String emailId;
    private String courseName;

    public CourseRegistration(String name, String emailId, String courseName) {

        Name = name;
        this.emailId = emailId;
        this.courseName = courseName;
    }
    public CourseRegistration(){

    }
}
