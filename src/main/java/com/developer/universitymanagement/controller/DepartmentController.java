package com.developer.universitymanagement.controller;

import com.developer.universitymanagement.entity.DepartmentEntity;
import com.developer.universitymanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    //@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
    @Autowired
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentEntity>> findAllDepartment(){
        try {
            List<DepartmentEntity> departments= departmentService.findAllDepartment();
            return new ResponseEntity<>(departments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Optional<DepartmentEntity> findDepartmentById(@PathVariable("id") Integer id){
        return departmentService.findById(id);
    }

    @PostMapping
    public DepartmentEntity saveDepartment(@RequestBody DepartmentEntity departmentEntity ) {
        return departmentService.saveDepartment(departmentEntity);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<DepartmentEntity> updateDepartment(@PathVariable("id") Integer id, @RequestBody DepartmentEntity departmentEntity ) {
        try {
            DepartmentEntity updateDepartment= departmentService.updateDepartment(id,departmentEntity);
            return new ResponseEntity<>(updateDepartment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Map<String, Boolean>>  deleteDepartment(@PathVariable(value = "id") Integer id) {
        try {
            departmentService.deleteDepartment(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
