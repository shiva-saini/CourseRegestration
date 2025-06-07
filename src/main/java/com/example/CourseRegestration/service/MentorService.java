package com.example.CourseRegestration.service;

import com.example.CourseRegestration.entity.Mentor;
import com.example.CourseRegestration.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorService{

    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository){
        this.mentorRepository = mentorRepository;
    }

    public String addMentor(Mentor mentor){
        Mentor res = mentorRepository.save(mentor);
        return "Mentor " + mentor.getName() + " added successfully";
    }
}
