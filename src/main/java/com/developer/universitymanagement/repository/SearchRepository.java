package com.developer.universitymanagement.repository;

import com.developer.universitymanagement.entity.dto.SearchDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<SearchDto,  Integer> {
    @Query("select distinct p.name as professorName ,c.name as courseName from ProfessorEntity p, CourseEntity c, ScheduleEntity s where s.courseEntity.id = c.id and s.professorEntity.id = p.id")
    List<SearchDto> search();
}

