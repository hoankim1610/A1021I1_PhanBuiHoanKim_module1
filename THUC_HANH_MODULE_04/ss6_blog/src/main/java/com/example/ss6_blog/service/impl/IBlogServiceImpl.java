package com.example.ss6_blog.service.impl;

import com.example.ss6_blog.model.Blog;
import com.example.ss6_blog.repository.BlogRepository;
import com.example.ss6_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IBlogServiceImpl implements IBlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String nameSearch, String categorySearch) {
        return blogRepository.findBySearch("%" + nameSearch + "%", "%" + categorySearch + "%", pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Optional<Blog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

}
