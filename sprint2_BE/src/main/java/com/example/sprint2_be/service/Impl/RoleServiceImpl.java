package com.example.sprint2_be.service.Impl;

import com.example.sprint2_be.entity.account.Role;
import com.example.sprint2_be.repository.IRoleRepository;
import com.example.sprint2_be.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findRoleByRoleName(String name) {
        return roleRepository.findRoleByRoleName(name);
    }

    @Override
    public List<Role> findAllRole() {
        return roleRepository.findAll();
    }
}
