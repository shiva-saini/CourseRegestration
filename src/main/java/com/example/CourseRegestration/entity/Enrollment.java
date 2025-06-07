package com.example.CourseRegestration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer course_id;

    private Integer user_id;

    private Integer institution_id;

    private Integer mentorId;

    private Integer paymentId;

    private LocalDateTime enrollmentDate;

    private boolean paymentStatus;

}
