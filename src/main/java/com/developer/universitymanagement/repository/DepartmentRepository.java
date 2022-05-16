package com.developer.universitymanagement.repository;

import com.developer.universitymanagement.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Interface for Department
 */
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
}
