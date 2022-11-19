package com.example.sprint2_be.service.Impl;

import com.example.sprint2_be.dto.CustomerAccount;
import com.example.sprint2_be.entity.account.Account;
import com.example.sprint2_be.entity.account.Role;
import com.example.sprint2_be.repository.IAccountRepository;
import com.example.sprint2_be.repository.ICustomerRepository;
import com.example.sprint2_be.repository.IRoleRepository;
import com.example.sprint2_be.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public void createCustomerAccount(CustomerAccount customerAccount) {
//        if (accountRepository.findAccountByUsername(customerAccount.getAccount().getUsername()) != null){
//            System.out.println("Username existed");
//        }else {
        Set<Role> roles = new HashSet<>();
        customerRepository.save(customerAccount.getCustomer());
        Optional<Role> role = Optional.of(roleRepository.findById(Long.valueOf(2)).get());
        if (role.isPresent()) {
            Role role1 = role.get();
            roles.add(role1);
        }
        Account account = customerAccount.getAccount();
        account.setRoles(roles);
        account.setPassword(getEncodedPassword(customerAccount.getAccount().getPassword()));
        customerAccount.getCustomer().setCustomerAccountId(account);
        customerRepository.save(customerAccount.getCustomer());
//        }
    }
}

