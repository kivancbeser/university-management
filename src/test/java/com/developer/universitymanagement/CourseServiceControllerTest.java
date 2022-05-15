package com.developer.universitymanagement;

import com.developer.universitymanagement.entity.CourseEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourseServiceControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    //Get CourseEntity where is id equal 1
    @Test
    public void getCourseEntity() throws Exception {
        String uri = "http://localhost:8080/course/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        CourseEntity courseEntity = super.mapFromJson(content, CourseEntity.class);
        assertTrue(courseEntity.getName().equals("Pure Mathematics and Mathematical Statistics") && courseEntity.getId().equals(1));
    }

    //Create CourseEntity Test
    @Test
    public void createCourseEntity() throws Exception {
        String uri = "http://localhost:8080/course";
        CourseEntity course = new CourseEntity();
        course.setId(20);
        course.setName("New Course Kivanc1");
        String inputJson = super.mapToJson(course);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    //Updated CourseEntity First Name where is id equal 10
    @Test
    public void updateCourseEntity() throws Exception {
        String uri = "http://localhost:8080/course/10";
        CourseEntity courseEntity = getCourseWithId(10);
        courseEntity.setName("Updated Course Name");
        String inputJson = super.mapToJson(courseEntity);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


    //Delete CourseEntity where is id equal 10
    @Test
    public void deleteCourseEntity() throws Exception {
        String uri = "http://localhost:8080/course/10";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    public CourseEntity getCourseWithId(Integer courseId) throws Exception {
        String uri = "http://localhost:8080/course/" + courseId;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        CourseEntity courseEntity = super.mapFromJson(content, CourseEntity.class);
        return courseEntity;
    }

}
