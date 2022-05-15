package com.developer.universitymanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class CourseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="department_id")
    private DepartmentEntity departmentEntity;

    @Column(name = "credits")
    private Integer credits;

    @OneToMany(mappedBy = "courseEntity")
    private List<ScheduleEntity> scheduleEntities;

    public CourseEntity() {
    }

    public CourseEntity(Integer id, String name, DepartmentEntity departmentEntity, Integer credits, List<ScheduleEntity> scheduleEntities) {
        this.id = id;
        this.name = name;
        this.departmentEntity = departmentEntity;
        this.credits = credits;
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

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
