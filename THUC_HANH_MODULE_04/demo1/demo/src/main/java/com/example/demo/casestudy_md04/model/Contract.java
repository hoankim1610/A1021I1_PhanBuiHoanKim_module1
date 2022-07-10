package com.example.demo.casestudy_md04.model;

import javax.persistence.*;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_id;
    private Date contract_start_date;
    private Date contract_end_date;
    private double contract_deposit;
    private double contract_total_money;
    private int employee_id;
    private int customer_id;
    private int service_id;

    @OneToMany(mappedBy = "contract")
    private List<Contract_detail> contract_details;

    @ManyToOne(targetEntity = Employee.class)
    private Employee employee;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

    public Contract() {
    }

    public Contract(int contract_id, Date contract_start_date, Date contract_end_date, double contract_deposit, double contract_total_money, int employee_id, int customer_id, int service_id) {
        this.contract_id = contract_id;
        this.contract_start_date = contract_start_date;
        this.contract_end_date = contract_end_date;
        this.contract_deposit = contract_deposit;
        this.contract_total_money = contract_total_money;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.service_id = service_id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public Date getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(Date contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public Date getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(Date contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public double getContract_deposit() {
        return contract_deposit;
    }

    public void setContract_deposit(double contract_deposit) {
        this.contract_deposit = contract_deposit;
    }

    public double getContract_total_money() {
        return contract_total_money;
    }

    public void setContract_total_money(double contract_total_money) {
        this.contract_total_money = contract_total_money;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }
}
