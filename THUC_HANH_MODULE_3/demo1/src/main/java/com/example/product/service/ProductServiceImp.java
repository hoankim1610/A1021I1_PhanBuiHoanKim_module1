package com.example.product.service;

import com.example.product.model.Product;

import java.text.SimpleDateFormat;
import java.util.*;

public class ProductServiceImp implements ProductService {
    private static Map<String, Product> productMap;
    
    static {
        productMap = new HashMap<>();
            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            productMap 
        }
    @Override
    public void create(Product product) {
        if (!productMap.containsKey(pr.getId())) {
            productList.add(product.getId(), product);
        }
    }

    public void update(Product product) {
        if (productList.contains(product.getId())) {
            productList.add(product.getId(), product);
        }
    }

    public void delete(String id) {
        if (!productList.contains(id)) {
            productList.remove(id);
        }
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(String id) {
        if (productList.contains(id)) {
            return productList.get(Integer.parseInt(id));
        } else {
            return null;
        }
    }
}
