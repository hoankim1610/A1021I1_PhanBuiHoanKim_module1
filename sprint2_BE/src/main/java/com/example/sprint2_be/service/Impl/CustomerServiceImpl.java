package com.example.sprint2_be.service.Impl;

import com.example.sprint2_be.entity.customer.Customer;
import com.example.sprint2_be.repository.ICustomerRepository;
import com.example.sprint2_be.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
