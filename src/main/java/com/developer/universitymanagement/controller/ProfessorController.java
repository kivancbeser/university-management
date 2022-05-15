package com.developer.universitymanagement.controller;

import com.developer.universitymanagement.entity.ProfessorEntity;
import com.developer.universitymanagement.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    //@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
    @Autowired
    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorEntity>> findAllProfessor(){
        try {
            List<ProfessorEntity> professors= professorService.findAllProfessor();
            return new ResponseEntity<>(professors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Optional<ProfessorEntity> findProfessorById(@PathVariable("id") Integer id){
        return professorService.findById(id);
    }

    @PostMapping
    public ProfessorEntity saveProfessor(@RequestBody ProfessorEntity professorEntity ) {
        return professorService.saveProfessor(professorEntity);
    }


    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ProfessorEntity> updateProfessor(@PathVariable("id") Integer id, @RequestBody ProfessorEntity professorEntity ) {
        try {
            ProfessorEntity updateProfessor= professorService.updateProfessor(id,professorEntity);
            return new ResponseEntity<>(updateProfessor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Map<String, Boolean>>  deleteProfessor(@PathVariable(value = "id") Integer id) {
        try {
            professorService.deleteProfessor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
