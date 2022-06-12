package com.example.demo_jpa.service;

import com.example.demo_jpa.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);

    void update(int id, Customer customer);
}
