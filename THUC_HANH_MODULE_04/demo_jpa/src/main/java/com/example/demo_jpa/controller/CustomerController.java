package com.example.demo_jpa.controller;

import com.example.demo_jpa.model.Customer;
import com.example.demo_jpa.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping(value = "/list")
    public ModelAndView goCustomerList() {

        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customerList", this.iCustomerService.findAll());

        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String goCreateCustomer(Model model) {

        model.addAttribute("customer", new Customer());

        return "/customer/create";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute Customer customer,
                                RedirectAttributes redirectAttributes) {

        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message",
                "Create successfully!");

        return "redirect:/customer/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        return "/customer/edit";
    }





    }
