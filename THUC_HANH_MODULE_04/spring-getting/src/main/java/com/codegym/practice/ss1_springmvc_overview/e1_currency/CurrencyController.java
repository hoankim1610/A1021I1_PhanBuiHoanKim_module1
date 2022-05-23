package com.codegym.practice.ss1_springmvc_overview.e1_currency;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyController {
    @GetMapping("/home")
    public String home() {
        return "ss1/e1/home";
    }

    @PostMapping("/convert")
    public ModelAndView convert(Currency currency){
        ModelAndView modelAndView= new ModelAndView("ss1/e1/currency");
        double result= currency.getUsd() * currency.getRate();
        modelAndView.addObject("result", String.format("%.2f", result));
        return modelAndView;
    }
}
