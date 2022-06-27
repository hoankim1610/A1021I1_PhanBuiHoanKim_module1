package com.example.blogn.service;

import com.example.blogn.model.Category;
import com.example.blogn.repository.CategoryRepository;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
