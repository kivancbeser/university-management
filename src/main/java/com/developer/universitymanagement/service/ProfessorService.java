package com.developer.universitymanagement.service;

import com.developer.universitymanagement.entity.ProfessorEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProfessorService {
    List<ProfessorEntity> findAllProfessor();
    Optional<ProfessorEntity> findById(Integer id);
    ProfessorEntity saveProfessor(ProfessorEntity professorEntity);
    ProfessorEntity updateProfessor(Integer id,ProfessorEntity professorEntity);
    Map<String, Boolean> deleteProfessor(Integer id);
}
