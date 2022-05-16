package com.developer.universitymanagement.repository;

import com.developer.universitymanagement.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Interface for Schedule
 */
@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer> {
}
