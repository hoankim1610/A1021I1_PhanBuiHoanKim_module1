package com.example.product.dto;

import com.example.product.model.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProductDTO {
    private int id;
    @NotEmpty(message = "This is not empty!")
    @Size(min = 5, max = 50)
    private String name;
    @Min(value = 100)
    private double price;
    private String status;

    private Category category;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, double price, String status, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String quantity) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
