package com.example.CourseRegestration.config;

import com.example.CourseRegestration.entity.User;
import com.example.CourseRegestration.exception.UserNotFoundException;
import com.example.CourseRegestration.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

            try {
                if(user == null)
                   throw new UserNotFoundException("User not found");
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }


        // Create UserDetails object with roles (adjust as needed)
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
