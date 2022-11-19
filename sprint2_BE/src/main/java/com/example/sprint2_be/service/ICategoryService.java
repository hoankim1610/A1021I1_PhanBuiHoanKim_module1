package com.example.sprint2_be.service;

import com.example.sprint2_be.entity.book.Book;
import com.example.sprint2_be.entity.book.Category;

import java.util.List;

public interface ICategoryService {
    Category findById(Long id);
    List<Category> findAllCategory();

}
