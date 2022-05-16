package com.developer.universitymanagement.repository;

import com.developer.universitymanagement.entity.ProfessorEntity;
import com.developer.universitymanagement.service.ProfessorCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository Interface for Professor
 */

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {
}
