package com.example.ss8_form_validation.controller;

import com.example.ss8_form_validation.model.Form;
import com.example.ss8_form_validation.model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/form")
public class FormController {
    @GetMapping(value = "")
    public ModelAndView getIndex(){
        return new ModelAndView("index","user", new Form());
    }

    @PostMapping(value = "/add")
    public String addUser(Model model, @Validated Form form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "index";
        }
        model.addAttribute("firstName",form.getFirstName());
        model.addAttribute("lastName",form.getLastName());
        return "result";
    }
}
