package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;
import com.example.customer.util.CommonUtil;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            request.setAttribute("customer", customerService.findById(Integer.parseInt(id)) );
            request.getRequestDispatcher("form.jsp").forward(request,response);
        }
        else {
            request.setAttribute("result", customerService.findAll() );
            request.getRequestDispatcher("customer.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = CommonUtil.toInt(request.getParameter("id"));
        String name = request.getParameter("name");
        if(name != null){
            String action=  request.getParameter("action");
            if(action != null){
                List<Customer> customers = customerService.findAll();
                List<Customer> list = customers.stream().filter(e ->e.getName().contains(name)).collect(Collectors.toList());
                request.setAttribute("result", list);
                request.getRequestDispatcher("customer.jsp").forward(request, response);
            }
            else {
                int phone = Integer.parseInt(request.getParameter("phone"));
                String date = request.getParameter("date");
                int paymentId = Integer.parseInt(request.getParameter("payment"));
                Customer customer = new Customer(id,name, phone, date, date, paymentId, "");
                customerService.save(customer);
                response.sendRedirect("/customer");
            }

        }
        else{
            customerService.delete(id);
            response.sendRedirect("/customer");
        }

    }
}
