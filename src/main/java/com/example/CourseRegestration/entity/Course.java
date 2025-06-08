package com.example.CourseRegestration.entity;

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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private Long price;

    private LocalDateTime startDate = LocalDateTime.now();

    // The instructor/seller who created this course
    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private User instructor;

    // Users who have purchased this course
    @ManyToMany(mappedBy = "coursesBought")
    private List<User> enrolledUsers = new ArrayList<>();

}
