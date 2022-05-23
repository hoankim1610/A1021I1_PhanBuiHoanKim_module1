package com.codegym.practice.ss1_springmvc_overview.p2_customer.controller;

import com.codegym.practice.ss1_springmvc_overview.p2_customer.model.Customer;
import com.codegym.practice.ss1_springmvc_overview.p2_customer.service.CustomerService;
import com.codegym.practice.ss1_springmvc_overview.p2_customer.service.CustomerServiceFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        class CustomerServlet extends HttpServlet {
//            CustomerService customerService = CustomerServiceFactory.getInstance();
//
//            @Override
//            protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//                Customer customer = new Customer();
//                customer.setName(req.getParameter("name"));
//                customer.setEmail(req.getParameter("email"));
//                customer.setAddress(req.getParameter("address"));
//
//                int id = Integer.valueOf(req.getParameter("id"));
//                customer.setId(id);
//                customerService.save(customer);
//
//                resp.sendRedirect("ss1/p2/customerList.jsp");
//            }
//        }
    }
}
