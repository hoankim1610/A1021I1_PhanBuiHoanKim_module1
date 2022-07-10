package com.example.ss6_blog.dto;

import com.example.ss6_blog.model.Category;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

public class BlogDTO {
    private int id;
    @NotEmpty(message = "This is not empty!")
    private String title;
    @NotEmpty(message = "This is not empty!")
    private  String content;
    private Category category;

    public BlogDTO() {
    }

    public BlogDTO(int id, String title, String content, Category category) {
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

