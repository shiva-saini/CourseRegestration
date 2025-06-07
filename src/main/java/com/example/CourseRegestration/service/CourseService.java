package com.example.CourseRegestration.service;

import com.example.CourseRegestration.entity.Course;
import com.example.CourseRegestration.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public String addCourse(Course course){
       Course course1 =  courseRepository.save(course);
       return "Courser " + course.getTitle() + " added successfully";
    }
}
