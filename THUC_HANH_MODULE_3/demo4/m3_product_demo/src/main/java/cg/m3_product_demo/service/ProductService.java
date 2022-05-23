package cg.m3_product_demo.service;

import cg.m3_product_demo.repository.ProductRepository;
import cg.m3_product_demo.model.Product;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository= new ProductRepository();

    public int save(Product product) {
        return productRepository.save(product);
    }

    public List findAll() {
        return productRepository.findAll();
    }

    public Product findById(int id){
        return productRepository.findById(id);
    }

    public int delete(int id) {
        return productRepository.delete(id);
    }

    public List searchByName(String name) {
        return null;
    }
}
