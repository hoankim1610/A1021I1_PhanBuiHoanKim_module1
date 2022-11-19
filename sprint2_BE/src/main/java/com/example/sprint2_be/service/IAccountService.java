package com.example.sprint2_be.service;

import com.example.sprint2_be.dto.CustomerAccount;
import com.example.sprint2_be.entity.account.Account;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    Account findAccountByUsername(String username);
    String getEncodedPassword(String password);
    void createCustomerAccount(CustomerAccount customerAccount);
}
