package com.codegym.practice.e2_calculation.controller;

import com.codegym.practice.e2_calculation.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculationController {

    @Autowired
    CalculationService calculationService;

    @GetMapping("/")
    public String show(){
        return "e2/calculation";
    }
    @PostMapping("/calculation")
    public String calculation(@RequestParam float number1, float number2, String cal, Model model){
        float result;
        try {
            result = calculationService.calculation(number1, number2, cal);
            model.addAttribute("result", result);
        }catch (Exception e){
            model.addAttribute("result", e.getMessage());
        }
        return "e2/calculation";
    }
}
