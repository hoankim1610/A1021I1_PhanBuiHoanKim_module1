package com.codegym.practice.ss1_springmvc_overview.e2_dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryController dictionaryService;

    @GetMapping("/home2")
    public String homePage(){
        return "ss1/e2/dictionaryHome";
    }

    @GetMapping("/search")
    public ModelAndView result(@RequestParam String search){
        String result= DictionaryService.search(search);
        return new ModelAndView("ss1/e2/dictionary", "result", result == null? "Not found": result);
    }


}
