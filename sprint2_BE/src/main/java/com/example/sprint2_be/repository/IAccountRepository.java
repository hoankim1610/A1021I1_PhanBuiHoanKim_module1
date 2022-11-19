package com.example.sprint2_be.repository;

import com.example.sprint2_be.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "SELECT * FROM account WHERE username=?1", nativeQuery = true)
    Account findAccountByUsername(String username);
}