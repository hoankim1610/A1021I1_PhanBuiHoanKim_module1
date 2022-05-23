package com.codegym.practice.ss1_springmvc_overview.e2_dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @GetMapping("/diction")
    public ModelAndView () {
        ModelAndView modelAndView = new ModelAndView("ss1/")
    }

}
