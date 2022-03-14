package ss12_CollectionFrameWork.excercise.e1_usingArrayList_LinkedList.ProductManagement.controller;

import ProductManagement.Service.ProductService;
import ProductManagement.exeption.NotFoundProductException;
import ProductManagement.model.Product;

import java.util.List;

public class ProductController {
    private ProductService productService = new ProductService();

    public void add(Product product) {
        productService.add(product);
    }

    public void delete(int id) throws NotFoundProductException {
        productService.delete(id);
    }

    public List<Product> getAll() {
        return productService.getAll();
    }

    public List<Product> searchByName(String name) {
        return productService.searchByName(name);
    }
}
