package com.developer.universitymanagement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.developer.universitymanagement.entity.DepartmentEntity;
import com.developer.universitymanagement.entity.ProfessorEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class ProfessorServiceControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    //Get ProfessorEntity where is id equal 1
    @Test
    public void getProfessorEntity() throws Exception {
        String uri = "http://localhost:8080/professor/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ProfessorEntity professorEntity = super.mapFromJson(content, ProfessorEntity.class);
        assertTrue(professorEntity.getName().equals("John Doe") && professorEntity.getId().equals(1));
    }

    //Get ProfessorEntitys List
    @Test
    public void getProfessorEntitiesList() throws Exception {
        String uri = "http://localhost:8080/professor";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ProfessorEntity[] professorEntities = super.mapFromJson(content, ProfessorEntity[].class);
        assertTrue(professorEntities.length > 0);

    }

    //Create ProfessorEntity Test
    @Test
    public void createProfessorEntity() throws Exception {
        String uri = "http://localhost:8080/professor";
        ProfessorEntity professor = new ProfessorEntity();
        professor.setId(20);
        professor.setName("New Professor Kivanc1");
        String inputJson = super.mapToJson(professor);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    //Updated ProfessorEntity First Name where is id equal 10
    @Test
    public void updateProfessorEntity() throws Exception {
        String uri = "http://localhost:8080/professor/10";
        ProfessorEntity professorEntity = getProfessorWithId(10);
        professorEntity.setName("Timothy Hickman");
        String inputJson = super.mapToJson(professorEntity);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


    //Delete ProfessorEntity where is id equal 10
    @Test
    public void deleteProfessorEntity() throws Exception {
        String uri = "http://localhost:8080/professor/10";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    public ProfessorEntity getProfessorWithId(Integer professorId) throws Exception {
        String uri = "http://localhost:8080/professor/" + professorId;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ProfessorEntity professorEntity = super.mapFromJson(content, ProfessorEntity.class);
        return professorEntity;
    }

}
