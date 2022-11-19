package com.example.sprint2_be.service;

import com.example.sprint2_be.entity.customer.Customer;

public interface ICustomerService {
    Customer findCustomerById(Long id);

}
