package com.example.productas.service;

import com.example.productas.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(int id);

    void delete(Integer id);
}
