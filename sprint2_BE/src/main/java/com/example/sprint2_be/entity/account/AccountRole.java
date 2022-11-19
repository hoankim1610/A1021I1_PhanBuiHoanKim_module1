package com.example.sprint2_be.entity.account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "account_role")
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_role_id")
    private Long accountRoleId;
    @NotNull
    @Column(name = "account_id")
    @NotNull
    private Long accountId;
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "account_role_flag")
    private Boolean accountRoleFlag = false;

    public AccountRole() {
    }

    public Long getAccountRoleId() {
        return accountRoleId;
    }

    public void setAccountRoleId(Long accountRoleId) {
        this.accountRoleId = accountRoleId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Boolean getAccountRoleFlag() {
        return accountRoleFlag;
    }

    public void setAccountRoleFlag(Boolean accountRoleFlag) {
        this.accountRoleFlag = accountRoleFlag;
    }
}