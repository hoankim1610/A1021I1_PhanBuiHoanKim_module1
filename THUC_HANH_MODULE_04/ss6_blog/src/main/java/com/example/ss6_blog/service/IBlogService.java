package com.example.ss6_blog.service;

import com.example.ss6_blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Optional<Blog> findById(int id);

//    void update(int id, Blog blog);

    void delete(int id);
}