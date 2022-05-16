package com.developer.universitymanagement.ServiceTest;

import com.developer.universitymanagement.entity.CourseEntity;
import com.developer.universitymanagement.entity.DepartmentEntity;
import com.developer.universitymanagement.exception.ResourceNotFoundException;
import com.developer.universitymanagement.repository.CourseRepository;
import com.developer.universitymanagement.service.impl.CourseServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceTest {

    @InjectMocks
    private CourseRepository repository;

    @InjectMocks
    private CourseServiceImpl courseService;

    private CourseEntity course;

    private DepartmentEntity department;

    @Before
    public void setUp() {
        course = new CourseEntity();
        course.setName("New Course");
        course.setCredits(4);
        department = new DepartmentEntity();
        department.setId(1);
        course.setDepartmentEntity(department);
    }

    /*
    @Test
    public void whenSaveCourseEntity_shouldReturnCourseEntity() {
        when(repository.findById(course.getId())).thenReturn(null);
        when(repository.save(course)).thenReturn(repository.getById(1));
        courseService.saveCourse(course);
        verify(repository).save(course);
    }*/

    @Test(expected = ResourceNotFoundException.class)
    public void whenGetCourseEntity_shouldReturnResourceNotFound() {
        when(repository.findById(55)).thenReturn(null);
        courseService.findById(this.course.getId());
    }


    @After
    public void tearDown() {
    }
}
