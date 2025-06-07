package com.example.CourseRegestration.service;

import com.example.CourseRegestration.entity.User;
import com.example.CourseRegestration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User " + user.getName() + " added successfully!";
    }

    //created for testing purpose
    public User addUser1(User user){
       return  userRepository.save(user);
    }

    public boolean authenticateUser(String email, String password) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(email));
        if (optionalUser.isPresent()) {
            return passwordEncoder.matches(password, optionalUser.get().getPassword());
        }
        return false;
    }

    /*
    public boolean authenticateUser(String email, String password) {
        User optionalUser = userRepository.findByEmail(email);
        if (optionalUser != null) {
            return passwordEncoder.matches(password, optionalUser.getPassword());
        }
        return false;
    }

     */

}
