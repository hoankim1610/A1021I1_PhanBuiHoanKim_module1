package com.example.demo.casestudy_md04.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Position {
    @Id
    private int position_id;
    private String position_name;
    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private List<Employee> employees;

    public Position() {
    }

    public Position(int position_id, String position_name) {
        this.position_id = position_id;
        this.position_name = position_name;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }
}
