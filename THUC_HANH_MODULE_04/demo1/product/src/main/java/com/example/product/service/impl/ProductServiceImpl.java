package com.example.product.service.impl;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.image.ImageProducer;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
