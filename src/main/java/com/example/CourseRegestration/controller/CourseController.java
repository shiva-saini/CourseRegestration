package com.example.CourseRegestration.controller;

import com.example.CourseRegestration.entity.Course;
import com.example.CourseRegestration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses") //
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestBody Course course){
        String res = courseService.addCourse(course);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
