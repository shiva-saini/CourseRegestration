package com.example.CourseRegestration.service;

import com.example.CourseRegestration.dtos.AddCourseRequestDto;
import com.example.CourseRegestration.entity.Course;
import com.example.CourseRegestration.entity.User;
import com.example.CourseRegestration.repository.CourseRepository;
import com.example.CourseRegestration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public String addCourse(AddCourseRequestDto addCourseRequestDto) throws Exception {
        User instructor = userRepository.findById(addCourseRequestDto.getInstructorId())
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        Course course = new Course();
        course.setDescription(addCourseRequestDto.getDescription());
        course.setPrice(addCourseRequestDto.getPrice());
        course.setInstructor(instructor);
        course.setTitle(addCourseRequestDto.getTitle());

       Course course1 =  courseRepository.save(course);
       instructor.getCoursesSold().add(course1);
        //add this course in the account of the instructor
        userRepository.save(instructor);
       return "Courser " + course.getTitle() + " added successfully";
    }
}
