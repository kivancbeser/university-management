package com.developer.universitymanagement.service.impl;

import com.developer.universitymanagement.service.ProfessorCourse;
import com.developer.universitymanagement.service.SearchService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Service Implementation Class for Spesific Search Request
 * Used nativequery for filtrend and aggregation login.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ProfessorCourse> search() {
        /*
        When I used aggregation in Java usage example like that.
        select distinct p.name,c.name
        from professor p, course c,schedule s
        where s.course_id = c.id and s.professor_id = p.id

        Map<String, List<String>> collect = professorRepository.search()
                .stream()
                .collect(
                        Collectors.groupingBy(SearchDto::getProfessorName,
                                Collectors.mapping(SearchDto::getCourseName, Collectors.toList())));
        List<ProfessorCourse> professorCourses = new ArrayList<>();
        for (String professorName : collect.keySet()) {
            List<String> courses = collect.get(professorName);
            professorCourses.add( new ProfessorCourse(professorName,courses));
        }
        */

        //First of all when i start this project.
        final String sqlQuery = "select p.name, array_agg(c.name) from professor p join schedule s on s.professor_id = p.id join course c on s.course_id = c.id group by p.name";
        // add your entity manager here
        List<ProfessorCourse> results= entityManager.createNativeQuery(sqlQuery).getResultList();
        //List contains the mapped entity data.
        return results;
    }
}

