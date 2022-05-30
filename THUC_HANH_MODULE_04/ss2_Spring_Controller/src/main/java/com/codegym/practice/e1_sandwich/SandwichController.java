package com.codegym.practice.e1_sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class SandwichController {
    @GetMapping
    public String home(Model model){
        Sandwich sandwich= new Sandwich();
        model.addAttribute("sandwich", sandwich);
        return "index";
    }

    @PostMapping("save")
    public ModelAndView save(String condiment){
        ModelAndView modelAndView= new ModelAndView("index", "condiment", condiment);
        return modelAndView;
    }

    @PostMapping("submit")
    public ModelAndView submit(String c){
        Sandwich sandwich= new Sandwich();
        ModelAndView modelAndView= new ModelAndView("index", "condiment", c);
        modelAndView.addObject("sandwich", sandwich);
        return modelAndView;
    }

    @ModelAttribute("condiments")
    public List<String> condiments()
    {
        List<String> condiments = Arrays.asList(
                "Apache Struts", "Spring", "Hibernate",
                "Grails", "Java Server Faces");
        return condiments;
    }

    @ModelAttribute("c")
    public String c(){
        return "con";
    }
}
