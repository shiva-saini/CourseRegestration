package com.example.CourseRegestration.entity;

import com.example.CourseRegestration.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer age;

    private String email;

    private String password;

    //added on 08/06/2025
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Role role = Role.BUYER;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Seller: courses they created (sold)
    // Courses created by this user (as a seller)
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Course> coursesSold = new ArrayList<>();

    // Courses bought by this user (as a buyer)
    @ManyToMany
    @JoinTable(
            name = "user_course_enrollments",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> coursesBought = new ArrayList<>();
    //added on 08/06/2025 end

}
