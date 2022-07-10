package com.example.ss6_blog.service.impl;

import com.example.ss6_blog.model.Category;
import com.example.ss6_blog.repository.CategoryRepository;
import com.example.ss6_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
