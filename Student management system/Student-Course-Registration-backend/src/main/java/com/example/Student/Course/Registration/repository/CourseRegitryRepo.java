package com.example.Student.Course.Registration.repository;

import com.example.Student.Course.Registration.model.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegitryRepo extends JpaRepository<CourseRegistration,Integer> {

}

