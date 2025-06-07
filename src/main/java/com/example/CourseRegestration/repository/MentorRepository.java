package com.example.CourseRegestration.repository;

import com.example.CourseRegestration.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor,Integer> {
}
