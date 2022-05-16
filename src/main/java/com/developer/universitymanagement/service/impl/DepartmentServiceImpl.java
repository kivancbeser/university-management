package com.developer.universitymanagement.service.impl;

import com.developer.universitymanagement.entity.DepartmentEntity;
import com.developer.universitymanagement.exception.ResourceNotFoundException;
import com.developer.universitymanagement.repository.DepartmentRepository;
import com.developer.universitymanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service Implementation Class for Department Service
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentEntity> findAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<DepartmentEntity> findById(Integer id) {
        return departmentRepository.findById(id);
    }

    @Override
    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public DepartmentEntity updateDepartment(Integer id, DepartmentEntity departmentEntity) {
        DepartmentEntity department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :", "id", id));
        department.setName(departmentEntity.getName());
        return departmentRepository.save(department);
    }

    @Override
    public Map<String, Boolean> deleteDepartment(Integer id) {
        DepartmentEntity department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :", "id", id));
        departmentRepository.delete(department);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
