package com.example.customer.service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;

import java.util.List;

public class CustomerService {
    private CustomerRepository customerRepository= new CustomerRepository();

    public int save (Customer customer) {
        return customerRepository.save(customer);
    }

    public List findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    public int delete (int id) {
        return customerRepository.delete(id);
    }

}
