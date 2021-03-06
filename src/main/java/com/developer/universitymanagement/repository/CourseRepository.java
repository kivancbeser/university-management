package com.developer.universitymanagement.repository;

import com.developer.universitymanagement.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Interface for Course
 */
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
}
