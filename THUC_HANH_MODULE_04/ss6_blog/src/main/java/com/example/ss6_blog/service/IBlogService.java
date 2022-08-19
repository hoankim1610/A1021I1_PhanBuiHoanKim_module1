package com.example.ss6_blog.service;

import com.example.ss6_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);
//
    Page<Blog> findAll(Pageable pageable, String nameSearch, String categorySearch);

    void save(Blog blog);

    Optional<Blog> findById(int id);

    void delete(int id);
}
