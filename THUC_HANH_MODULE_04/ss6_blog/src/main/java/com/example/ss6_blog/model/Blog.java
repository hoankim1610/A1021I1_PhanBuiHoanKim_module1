package com.example.ss6_blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonBackReference
    private Category category;

    public Blog() {
    }

    public Blog(int id, String title, String content, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

