package com.example.demo.casestudy_md04.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Degree {
    @Id
    private int education_degree_id;
    private int education_degree_name;
    @OneToMany(mappedBy = "degree")
    @JsonBackReference
    private List<Employee> employees;

    public Degree() {
    }

    public Degree(int education_degree_id, int education_degree_name) {
        this.education_degree_id = education_degree_id;
        this.education_degree_name = education_degree_name;
    }

    public int getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(int education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public int getEducation_degree_name() {
        return education_degree_name;
    }

    public void setEducation_degree_name(int education_degree_name) {
        this.education_degree_name = education_degree_name;
    }
}
