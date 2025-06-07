package com.example.CourseRegestration.repository;

import com.example.CourseRegestration.entity.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution,Integer> {
}
