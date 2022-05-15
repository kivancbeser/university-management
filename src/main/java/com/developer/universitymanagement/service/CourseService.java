package com.developer.universitymanagement.service;

import com.developer.universitymanagement.entity.CourseEntity;
import com.developer.universitymanagement.entity.CourseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CourseService {
    Optional<CourseEntity> findById(Integer id);
    CourseEntity saveCourse(CourseEntity courseEntity);
    CourseEntity updateCourse(Integer id,CourseEntity courseEntity);
    Map<String, Boolean> deleteCourse(Integer id);
}
