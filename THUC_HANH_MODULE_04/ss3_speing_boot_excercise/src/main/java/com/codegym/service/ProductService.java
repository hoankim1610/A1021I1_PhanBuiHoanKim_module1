package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone", 20, "phone", "Iphone"));
        products.put(2, new Product(2, "Samsung", 30, "phone", "Samsung"));
        products.put(3, new Product(3, "Xiaomi", 10, "phone", "China"));
        products.put(4, new Product(4, "Nokia", 5, "phone", "Viet Nam"));
        products.put(5, new Product(5, "Oppo", 7, "phone", "China"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
