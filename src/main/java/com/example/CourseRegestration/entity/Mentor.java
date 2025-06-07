package com.example.CourseRegestration.entity;

import com.example.CourseRegestration.convertors.StringListConvertor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    private String phone;

    private String experience;

    @Convert(converter = StringListConvertor.class)
    private List<String> courses;

    private String companies;
}
