package com.example.sprint2_be.service;

import com.example.sprint2_be.entity.account.Role;

import java.util.List;

public interface IRoleService {
    Role findRoleByRoleName(String name);
    List<Role> findAllRole();
}
