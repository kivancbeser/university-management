package com.developer.universitymanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class DepartmentEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "departmentEntity")
    private List<ProfessorEntity> professorEntities;

    @OneToMany(mappedBy = "departmentEntity")
    private List<CourseEntity> courseEntities;

    public DepartmentEntity() {
    }


    public DepartmentEntity(Integer id, String name, List<ProfessorEntity> professorEntities, List<CourseEntity> courseEntities) {
        this.id = id;
        this.name = name;
        this.professorEntities = professorEntities;
        this.courseEntities = courseEntities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
