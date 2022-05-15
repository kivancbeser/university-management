package com.developer.universitymanagement.controller;

import com.developer.universitymanagement.entity.ScheduleEntity;
import com.developer.universitymanagement.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    //@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
    @Autowired
    private ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public ResponseEntity<List<ScheduleEntity>> findAllSchedule(){
        try {
            List<ScheduleEntity> schedules= scheduleService.findAllSchedule();
            return new ResponseEntity<>(schedules, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Optional<ScheduleEntity> findScheduleById(@PathVariable("id") Integer id){
        return scheduleService.findById(id);
    }

    @PostMapping
    public ScheduleEntity saveSchedule(@RequestBody ScheduleEntity scheduleEntity ) {
        return scheduleService.saveSchedule(scheduleEntity);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ScheduleEntity> updateSchedule(@PathVariable("id") Integer id, @RequestBody ScheduleEntity scheduleEntity ) {
        try {
            ScheduleEntity updateSchedule= scheduleService.updateSchedule(id,scheduleEntity);
            return new ResponseEntity<>(updateSchedule, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Map<String, Boolean>>  deleteSchedule(@PathVariable(value = "id") Integer id) {
        try {
            scheduleService.deleteSchedule(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
