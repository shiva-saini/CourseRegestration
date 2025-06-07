package com.example.CourseRegestration.controller;

import com.example.CourseRegestration.entity.Enrollment;
import com.example.CourseRegestration.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments") //
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService){
        this.enrollmentService = enrollmentService;
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollUserInToCourse(@RequestBody Enrollment enrollment) throws Exception {
        String res = enrollmentService.enrollUserInToCourse(enrollment);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
