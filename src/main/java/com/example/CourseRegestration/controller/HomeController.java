package com.example.CourseRegestration.controller;

import com.example.CourseRegestration.entity.User;
import com.example.CourseRegestration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final UserService userService;  // your service to save users

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/home"})
    public String home() {
        return "home"; // home.html
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());  // empty user object for form binding
        return "register"; // register.html
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.addUser(user);  // save user to DB with password encoding
        return "redirect:/login";  // after registration redirect to login page
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login"; // login.html
    }
}
