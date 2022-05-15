package com.developer.universitymanagement.controller;

import com.developer.universitymanagement.entity.ScheduleEntity;
import com.developer.universitymanagement.entity.dto.SearchResponse;
import com.developer.universitymanagement.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/search")
public class SearchController {

    //@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<SearchResponse>> getProfessorWithCourses(){
        try {

            //List<SearchResponse> responses= scheduleService.findAllSchedule();
            //return new ResponseEntity<>(responses, HttpStatus.OK);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
