package com.developer.universitymanagement.service;

import com.developer.universitymanagement.entity.DepartmentEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    List<DepartmentEntity> findAllDepartment();
    Optional<DepartmentEntity> findById(Integer id);
    DepartmentEntity saveDepartment(DepartmentEntity professorEntity);
    DepartmentEntity updateDepartment(Integer id,DepartmentEntity professorEntity);
    Map<String, Boolean> deleteDepartment(Integer id);
}
