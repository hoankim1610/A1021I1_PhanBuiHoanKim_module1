package com.example.demo_jpa.repository;

import com.example.demo_jpa.model.Customer;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
