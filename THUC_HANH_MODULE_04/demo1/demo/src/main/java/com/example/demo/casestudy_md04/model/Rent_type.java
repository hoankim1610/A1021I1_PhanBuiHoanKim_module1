package com.example.demo.casestudy_md04.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "rent_type")
public class Rent_type {
    @Id
    private int rent_type_id;
    private String rent_type_name;
    private double rent_type_cost;
    @OneToMany(mappedBy = "rent_type")
    @JsonBackReference
    private List<Service> services;

    public Rent_type() {
    }

    public Rent_type(int rent_type_id, String rent_type_name, double rent_type_cost) {
        this.rent_type_id = rent_type_id;
        this.rent_type_name = rent_type_name;
        this.rent_type_cost = rent_type_cost;
    }

    public int getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(int rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public String getRent_type_name() {
        return rent_type_name;
    }

    public void setRent_type_name(String rent_type_name) {
        this.rent_type_name = rent_type_name;
    }

    public double getRent_type_cost() {
        return rent_type_cost;
    }

    public void setRent_type_cost(double rent_type_cost) {
        this.rent_type_cost = rent_type_cost;
    }
}
