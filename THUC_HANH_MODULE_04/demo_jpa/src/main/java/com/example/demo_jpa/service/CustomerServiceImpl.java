package com.example.demo_jpa.service;

import com.example.demo_jpa.model.Customer;
import com.example.demo_jpa.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
         this.iCustomerRepository.save(customer);
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }
}
