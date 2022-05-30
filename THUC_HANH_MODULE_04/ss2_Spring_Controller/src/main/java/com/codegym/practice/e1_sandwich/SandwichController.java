package com.codegym.practice.e1_sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

    @Controller
    public class SandwichController {

        @GetMapping("")
        public String views() {
            return "e1/sandwich";
        }

        @GetMapping("/sandwich")
        public ModelAndView sandwich(@RequestParam String sandwich) {
            return new ModelAndView("e1/sandwich", "res", sandwich);
        }
    }
