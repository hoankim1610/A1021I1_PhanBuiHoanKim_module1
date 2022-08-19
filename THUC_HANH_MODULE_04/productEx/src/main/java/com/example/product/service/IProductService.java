package com.example.product.service;

import com.example.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable, String nameSearch, String categorySearch);

    void save(Product product);

    Optional<Product> findById(int id);

    void delete(int id);
}
