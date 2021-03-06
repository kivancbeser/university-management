package com.developer.universitymanagement.controller;

import com.developer.universitymanagement.entity.CourseEntity;
import com.developer.universitymanagement.entity.ProfessorEntity;
import com.developer.universitymanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Controller class for Courses
 */

@RestController
@RequestMapping("/course")
public class CourseController {

    //@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<CourseEntity> findCourseById(@PathVariable("id") Integer id){
        return courseService.findById(id);
    }

    /**
     *
     * @param courseEntity
     * @return
     */
    @PostMapping
    public CourseEntity saveCourse(@RequestBody CourseEntity courseEntity ) {
        return courseService.saveCourse(courseEntity);
    }

    /**
     *
     * @param id
     * @param courseEntity
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<CourseEntity> updateCourse(@PathVariable("id") Integer id, @RequestBody CourseEntity courseEntity ) {
        try {
            CourseEntity updateCourse= courseService.updateCourse(id,courseEntity);
            return new ResponseEntity<>(updateCourse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public  ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable(value = "id") Integer id) {
        try {
            courseService.deleteCourse(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
