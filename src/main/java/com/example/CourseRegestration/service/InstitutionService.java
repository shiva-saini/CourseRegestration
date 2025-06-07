package com.example.CourseRegestration.service;

import com.example.CourseRegestration.entity.Institution;
import com.example.CourseRegestration.repository.InstitutionRepository;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository){
        this.institutionRepository = institutionRepository;
    }

    public String addInstitute(Institution institution){
        Institution res = institutionRepository.save(institution);
        return "Institution " + institution.getName() + " added successfully";
    }
}
