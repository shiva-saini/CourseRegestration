package com.example.CourseRegestration.service;

import com.example.CourseRegestration.entity.User;
import com.example.CourseRegestration.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;


    /*
    @Test
    void addUserShouldAddUserSuccessfully(){
        System.out.println("My first unit test");
        User user = new User();
        user.setAge(25);
        user.setId(1);
        user.setName("shiva");
        user.setEmail("shiva123@gmail.com");
        user.setPassword("1234");
        Mockito.when(userRepository.save(user)).thenReturn(user);
        User addedUser = userService.addUser1(user);
        Assertions.assertEquals(2,addedUser.getId());
    }

     */

}