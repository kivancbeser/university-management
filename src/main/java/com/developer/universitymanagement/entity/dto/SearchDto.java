package com.developer.universitymanagement.entity.dto;

import javax.persistence.Entity;

public class SearchDto {
    private String professorName;
    private String courseName;

    public SearchDto() {
    }

    public SearchDto(String professorName, String courseName) {
        this.professorName = professorName;
        this.courseName = courseName;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
