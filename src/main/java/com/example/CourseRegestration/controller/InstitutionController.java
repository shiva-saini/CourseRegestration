package com.example.CourseRegestration.controller;

import com.example.CourseRegestration.entity.Institution;
import com.example.CourseRegestration.service.InstitutionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/institutions") //
public class InstitutionController {

    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService){
        this.institutionService = institutionService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addInstitution(@RequestBody Institution institution){
        String res = institutionService.addInstitute(institution);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
