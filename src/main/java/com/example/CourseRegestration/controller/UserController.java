package com.example.CourseRegestration.controller;

import com.example.CourseRegestration.entity.Course;
import com.example.CourseRegestration.entity.User;
import com.example.CourseRegestration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") //
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user){
        String res = userService.addUser(user);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
