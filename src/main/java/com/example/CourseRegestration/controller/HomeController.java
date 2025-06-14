package com.example.CourseRegestration.controller;

import com.example.CourseRegestration.config.CustomUserDetailsService;
import com.example.CourseRegestration.entity.User;
import com.example.CourseRegestration.model.AuthenticationRequest;
import com.example.CourseRegestration.model.AuthenticationResponse;
import com.example.CourseRegestration.service.UserService;
import com.example.CourseRegestration.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;
    // your service to save users

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

    /*
    @GetMapping("/login")
    public String showLogin() {
        return "login"; // login.html
    }
    */
    //shiva
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> handleLogin(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        String username = authenticationRequest.getUserName();
        String password = authenticationRequest.getPassword();

        // Dummy check — replace with actual DB validation
        System.out.println("Login called");
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),authenticationRequest.getPassword()));

            UserDetails userDetails = customUserDetailsService.loadUserByUsername(authenticationRequest.getUserName());
            String jwt = jwtUtil.generateToken(userDetails.getUsername());
            AuthenticationResponse response = new AuthenticationResponse(jwt);
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        }catch (Exception e){
            throw new Exception("Invalid credentials");
        }

        //return "success"; // Return same view with result
    }
}
