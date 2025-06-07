package com.example.CourseRegestration.controller;

import com.example.CourseRegestration.entity.Mentor;
import com.example.CourseRegestration.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mentors") //
public class MentorController {

    private final MentorService mentorService;

    @Autowired
    public MentorController(MentorService mentorService){
        this.mentorService = mentorService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addmentor(@RequestBody Mentor mentor){
        String res = mentorService.addMentor(mentor);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
