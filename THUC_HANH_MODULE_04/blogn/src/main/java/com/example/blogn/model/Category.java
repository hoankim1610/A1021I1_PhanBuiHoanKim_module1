package com.example.blogn.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Blogn> blogn;

    public Category() {
    }

    public Category(int id, String name, List<Blogn> blogn) {
        this.id = id;
        this.name = name;
        this.blogn = blogn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blogn> getBlog() {
        return blogn;
    }

    public void setBlog(List<Blogn> blogn) {
        this.blogn = blogn;
    }
}
