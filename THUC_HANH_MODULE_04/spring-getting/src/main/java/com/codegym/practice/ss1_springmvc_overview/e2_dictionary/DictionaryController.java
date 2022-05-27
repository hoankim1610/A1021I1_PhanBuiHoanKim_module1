package com.codegym.practice.ss1_springmvc_overview.e2_dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping
    public String homePage(){
        return "home";
    }

    @GetMapping("search")
    public ModelAndView result(@RequestParam String search){
        String result= dictionaryService.search(search);
        return new ModelAndView("result", "result", result == null? "Not found": result);
    }

}
