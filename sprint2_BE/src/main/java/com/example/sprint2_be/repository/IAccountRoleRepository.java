package com.example.sprint2_be.repository;

import com.example.sprint2_be.entity.account.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRoleRepository extends JpaRepository<AccountRole, Long> {
}
