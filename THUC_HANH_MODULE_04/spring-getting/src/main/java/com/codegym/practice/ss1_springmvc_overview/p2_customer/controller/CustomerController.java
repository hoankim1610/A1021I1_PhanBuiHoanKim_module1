package com.codegym.practice.ss1_springmvc_overview.p2_customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @GetMapping("/customer")
    public ModelAndView customer() {
        return new ModelAndView("customerList", "customer", "hello");
    }

}
