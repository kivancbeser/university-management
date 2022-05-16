package com.developer.universitymanagement.service.impl;

import com.developer.universitymanagement.entity.ScheduleEntity;
import com.developer.universitymanagement.exception.ResourceNotFoundException;
import com.developer.universitymanagement.repository.ScheduleRepository;
import com.developer.universitymanagement.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Implementation Class for Schedule Service
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<ScheduleEntity> findAllSchedule() {
        return scheduleRepository.findAll();
    }

    @Override
    public Optional<ScheduleEntity> findById(Integer id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public ScheduleEntity saveSchedule(ScheduleEntity scheduleEntity) {
        return scheduleRepository.save(scheduleEntity);
    }

    @Override
    public ScheduleEntity updateSchedule(Integer id, ScheduleEntity scheduleEntity) {
        ScheduleEntity schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found for this id :", "id", id));
        schedule.setCourseEntity(scheduleEntity.getCourseEntity());
        schedule.setProfessorEntity(scheduleEntity.getProfessorEntity());
        schedule.setSemester(scheduleEntity.getSemester());
        schedule.setYear(scheduleEntity.getYear());
        return scheduleRepository.save(schedule);
    }

    @Override
    public Map<String, Boolean> deleteSchedule(Integer id) {
        ScheduleEntity schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found for this id :", "id", id));
        scheduleRepository.delete(schedule);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
