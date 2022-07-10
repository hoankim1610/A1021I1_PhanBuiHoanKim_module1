package com.example.demo.casestudy_md04.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private int customer_id;
    private int customer_type_id;
    private String customer_name;
    private Date customer_birthday;
    private String customer_gender;
    private String customer_id_card;
    private String customer_phone;
    private String customer_email;
    private String customer_address;

    @ManyToOne(targetEntity = Customer_type.class)
    private Customer_type customer_type;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    public Customer() {
    }

    public Customer(int customer_id, int customer_type_id, String customer_name, Date customer_birthday, String customer_gender, String customer_id_card, String customer_phone, String customer_email, String customer_address) {
        this.customer_id = customer_id;
        this.customer_type_id = customer_type_id;
        this.customer_name = customer_name;
        this.customer_birthday = customer_birthday;
        this.customer_gender = customer_gender;
        this.customer_id_card = customer_id_card;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.customer_address = customer_address;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(int customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Date getCustomer_birthday() {
        return customer_birthday;
    }

    public void setCustomer_birthday(Date customer_birthday) {
        this.customer_birthday = customer_birthday;
    }

    public String getCustomer_gender() {
        return customer_gender;
    }

    public void setCustomer_gender(String customer_gender) {
        this.customer_gender = customer_gender;
    }

    public String getCustomer_id_card() {
        return customer_id_card;
    }

    public void setCustomer_id_card(String customer_id_card) {
        this.customer_id_card = customer_id_card;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }
}
