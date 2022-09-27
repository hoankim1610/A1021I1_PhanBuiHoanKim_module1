package com.example.productas.repository;

import com.example.productas.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM product where `name` like :nameSearch and category_id like :category",
            countQuery = "SELECT * FROM product where `name` like :nameSearch and category_id like :category",
            nativeQuery = true)
    Page<Product> findBySearch(@Param("nameSearch") String nameSearch, @Param("category") String categorySearch, Pageable pageable);
}
