package com.example.demo.casestudy_md04.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Division {
    @Id
    private int division_id;
    private String division_name;
    @OneToMany(mappedBy = "division")
    @JsonBackReference
    private List<Employee> employees;

    public Division() {
    }

    public Division(int division_id, String division_name) {
        this.division_id = division_id;
        this.division_name = division_name;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public String getDivision_name() {
        return division_name;
    }

    public void setDivision_name(String division_name) {
        this.division_name = division_name;
    }
}
