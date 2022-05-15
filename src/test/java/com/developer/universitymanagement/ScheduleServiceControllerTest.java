package com.developer.universitymanagement;

import com.developer.universitymanagement.entity.ScheduleEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScheduleServiceControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    //Get ScheduleEntity where is id equal 1
    @Test
    public void getScheduleEntity() throws Exception {
        String uri = "http://localhost:8080/schedule/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        ScheduleEntity scheduleEntity = super.mapFromJson(content, ScheduleEntity.class);
        assertTrue(scheduleEntity.getId().equals(1));
    }

    //Create ScheduleEntity Test
    @Test
    public void createScheduleEntity() throws Exception {
        String uri = "http://localhost:8080/schedule";
        ScheduleEntity schedule = new ScheduleEntity();
        schedule.setId(20);
        schedule.setYear(1999);
        schedule.setSemester(1);
        String inputJson = super.mapToJson(schedule);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    //Updated ScheduleEntity Year update to 1999
    @Test
    public void updateScheduleEntity() throws Exception {
        String uri = "http://localhost:8080/schedule/10";
        ScheduleEntity scheduleEntity = getScheduleWithId(10);
        scheduleEntity.setYear(1999);
        String inputJson = super.mapToJson(scheduleEntity);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


    //Delete ScheduleEntity where is id equal 10
    @Test
    public void deleteScheduleEntity() throws Exception {
        String uri = "http://localhost:8080/schedule/10";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    public ScheduleEntity getScheduleWithId(Integer scheduleId) throws Exception {
        String uri = "http://localhost:8080/schedule/" + scheduleId;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ScheduleEntity scheduleEntity = super.mapFromJson(content, ScheduleEntity.class);
        return scheduleEntity;
    }

}
