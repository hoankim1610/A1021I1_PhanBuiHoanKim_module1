package com.example.sprint2_be.repository;

import com.example.sprint2_be.entity.account.AccountRole;
import com.example.sprint2_be.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
