package com.example.CourseRegestration.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCourseRequestDto {
    private String title;
    private String description;
    private Long price;
    private Integer instructorId;
}
