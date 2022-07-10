package com.example.product.repository;

import com.example.product.model.Category;
import com.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
