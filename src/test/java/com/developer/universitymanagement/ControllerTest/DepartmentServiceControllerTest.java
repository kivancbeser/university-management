package com.developer.universitymanagement.ControllerTest;

import com.developer.universitymanagement.AbstractTest;
import com.developer.universitymanagement.entity.DepartmentEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DepartmentServiceControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    /**
     * Get DepartmentEntity where is id equal 1
     * @throws Exception
     */
    @Test
    public void getDepartmentEntity() throws Exception {
        String uri = "http://localhost:8080/department/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        DepartmentEntity departmentEntity = super.mapFromJson(content, DepartmentEntity.class);
        assertTrue(departmentEntity.getName().equals("Pure Mathematics and Mathematical Statistics") && departmentEntity.getId().equals(1));
    }

    /**
     * Create DepartmentEntity Test
     * @throws Exception
     */
    @Test
    public void createDepartmentEntity() throws Exception {
        String uri = "http://localhost:8080/department";
        DepartmentEntity department = new DepartmentEntity();
        department.setName("Humanities & Social Sciences");
        String inputJson = super.mapToJson(department);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    /**
     * Updated DepartmentEntity First Name where is id equal 10
     * @throws Exception
     */
    @Test
    public void updateDepartmentEntity() throws Exception {
        String uri = "http://localhost:8080/department/6";
        DepartmentEntity departmentEntity = getDepartmentWithId(6);
        departmentEntity.setName("Updated Department Name");
        String inputJson = super.mapToJson(departmentEntity);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


    /**
     * Delete DepartmentEntity where is id equal 6
     * @throws Exception
     */
    @Test
    public void deleteDepartmentEntity() throws Exception {
        String uri = "http://localhost:8080/department/6";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    /**
     * Get Department object with Id
     * @param departmentId
     * @return
     * @throws Exception
     */
    public DepartmentEntity getDepartmentWithId(Integer departmentId) throws Exception {
        String uri = "http://localhost:8080/department/" + departmentId;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        DepartmentEntity departmentEntity = super.mapFromJson(content, DepartmentEntity.class);
        return departmentEntity;
    }

}
