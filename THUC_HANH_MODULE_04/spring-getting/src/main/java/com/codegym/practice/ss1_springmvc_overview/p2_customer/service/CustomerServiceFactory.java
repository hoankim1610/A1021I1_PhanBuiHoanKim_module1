package com.codegym.practice.ss1_springmvc_overview.p2_customer.service;

public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
//            singleton = new SimpleCustomerServiceImpl();
        }
        return singleton;
    }
}

