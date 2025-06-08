//package com.example.CourseRegestration.repository;
//
//import com.example.CourseRegestration.entity.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import com.example.CourseRegestration.repository.UserRepository;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@DataJpaTest
//public class UserRepositoryTests {
//    @Autowired
//    private TestEntityManager entityManager;
//
//   @Autowired
//   private UserRepository userRepository;
//
//    @Test
//    void findByEmail_shouldReturnUser() {
//        /*
//        User user = new User();
//        user.setId(1);
//        user.setEmail("shiva123@gmail.com");
//        user.setAge(25);
//        user.setName("Shiva");
//        entityManager.persist(user);
//*/
//        Optional<User> found = Optional.ofNullable(userRepository.findByEmail("shiva123@gmail.com"));
//        assertTrue(found.isPresent());
//        assertEquals("Test User", found.get().getName());
//        }
//}
