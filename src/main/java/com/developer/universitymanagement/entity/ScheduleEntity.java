package com.developer.universitymanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "schedule")
public class ScheduleEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="professor_id")
    private ProfessorEntity professorEntity;

    @ManyToOne
    @JoinColumn(name="course_id")
    private CourseEntity courseEntity;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "year")
    private Integer year;

    public ScheduleEntity() {
    }

    public ScheduleEntity(Integer id, ProfessorEntity professorEntity, CourseEntity courseEntity, Integer semester, Integer year) {
        this.id = id;
        this.professorEntity = professorEntity;
        this.courseEntity = courseEntity;
        this.semester = semester;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProfessorEntity getProfessorEntity() {
        return professorEntity;
    }

    public void setProfessorEntity(ProfessorEntity professorEntity) {
        this.professorEntity = professorEntity;
    }

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
