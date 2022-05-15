package com.developer.universitymanagement.service;

import com.developer.universitymanagement.entity.ScheduleEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ScheduleService {
    List<ScheduleEntity> findAllSchedule();
    Optional<ScheduleEntity> findById(Integer id);
    ScheduleEntity saveSchedule(ScheduleEntity scheduleEntity);
    ScheduleEntity updateSchedule(Integer id,ScheduleEntity scheduleEntity);
    Map<String, Boolean> deleteSchedule(Integer id);
}
