package com.example.demo.casestudy_md04.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Service_type {
    @Id
    private int service_type_id;
    private String service_type_name;
    @OneToMany(mappedBy = "service_type")
    @JsonBackReference
    private List<Service> services;

    public Service_type() {
    }

    public Service_type(int service_type_id, String service_type_name) {
        this.service_type_id = service_type_id;
        this.service_type_name = service_type_name;
    }

    public int getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(int service_type_id) {
        this.service_type_id = service_type_id;
    }

    public String getService_type_name() {
        return service_type_name;
    }

    public void setService_type_name(String service_type_name) {
        this.service_type_name = service_type_name;
    }
}
