package com.example.customer.model;

public class Customer {
    private int id;
    private String name;
    private int phone;
    private String date ;
    private int paymentId;
    private String paymentName;

    public Customer(int id, String name, int phone, String s, String date, int paymentId, String paymentName) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.paymentId = paymentId;
        this.paymentName = paymentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}
