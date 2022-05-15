package com.developer.universitymanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professor")
public class ProfessorEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="department_id")
    private DepartmentEntity departmentEntity;

    @OneToMany(mappedBy = "professorEntity")
    private List<ScheduleEntity> scheduleEntities;

    public ProfessorEntity() {
    }

    public ProfessorEntity(Integer id, String name, DepartmentEntity departmentEntity, List<ScheduleEntity> scheduleEntities) {
        this.id = id;
        this.name = name;
        this.departmentEntity = departmentEntity;
        this.scheduleEntities = scheduleEntities;
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

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }
}
