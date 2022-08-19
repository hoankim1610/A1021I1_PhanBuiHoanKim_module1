package com.example.ss6_exercise_blog.service;

import com.example.ss6_exercise_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
}
