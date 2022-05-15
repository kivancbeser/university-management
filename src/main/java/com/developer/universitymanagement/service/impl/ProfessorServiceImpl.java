package com.developer.universitymanagement.service.impl;

import com.developer.universitymanagement.entity.ProfessorEntity;
import com.developer.universitymanagement.exception.ResourceNotFoundException;
import com.developer.universitymanagement.repository.ProfessorRepository;
import com.developer.universitymanagement.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<ProfessorEntity> findAllProfessor() {
        return professorRepository.findAll();
    }

    @Override
    public Optional<ProfessorEntity> findById(Integer id) {
        return professorRepository.findById(id);
    }

    @Override
    public ProfessorEntity saveProfessor(ProfessorEntity professorEntity) {
        return professorRepository.save(professorEntity);
    }

    @Override
    public ProfessorEntity updateProfessor(Integer id, ProfessorEntity professorEntity) {
        ProfessorEntity professor = professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor not found for this id :", "id", id));
        professor.setName(professorEntity.getName());
        professor.setDepartmentEntity(professorEntity.getDepartmentEntity());
        return professorRepository.save(professor);
    }

    @Override
    public Map<String, Boolean> deleteProfessor(Integer id) {
        ProfessorEntity professor = professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor not found for this id :", "id", id));
        professorRepository.delete(professor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
