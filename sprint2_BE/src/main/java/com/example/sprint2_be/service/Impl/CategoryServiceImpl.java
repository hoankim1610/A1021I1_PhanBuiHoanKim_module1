package com.example.sprint2_be.service.Impl;

import com.example.sprint2_be.entity.book.Category;
import com.example.sprint2_be.repository.ICategoryRepository;
import com.example.sprint2_be.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

}
