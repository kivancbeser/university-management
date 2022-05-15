package com.developer.universitymanagement.service.impl;

import com.developer.universitymanagement.entity.CourseEntity;
import com.developer.universitymanagement.exception.ResourceNotFoundException;
import com.developer.universitymanagement.repository.CourseRepository;
import com.developer.universitymanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    @Override
    public Optional<CourseEntity> findById(Integer id) {
        return courseRepository.findById(id);
    }

    @Override
    public CourseEntity saveCourse(CourseEntity CourseEntity) {
        return courseRepository.save(CourseEntity);
    }

    @Override
    public CourseEntity updateCourse(Integer id, CourseEntity CourseEntity) {
        CourseEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :", "id", id));
        course.setName(CourseEntity.getName());
        course.setCredits(CourseEntity.getCredits());
        course.setDepartmentEntity(CourseEntity.getDepartmentEntity());
        return courseRepository.save(course);
    }

    @Override
    public Map<String, Boolean> deleteCourse(Integer id) {
        CourseEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :", "id", id));
        courseRepository.delete(course);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
