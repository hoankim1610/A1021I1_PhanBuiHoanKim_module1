package com.codegym.practice.ss1_springmvc_overview.p1_geeting_spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @GetMapping("/")
//    public String greeting(@RequestParam String name, Model model) {
//        model.addAttribute("name", name);
//        return "index";
//    }
    public ModelAndView greeting() {
        return new ModelAndView("ss1/p1/greeting", "name", "hello");
    }
}