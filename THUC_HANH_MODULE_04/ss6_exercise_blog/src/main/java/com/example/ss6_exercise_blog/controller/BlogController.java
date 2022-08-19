package com.example.ss6_exercise_blog.controller;

import com.example.ss6_exercise_blog.model.Blog;
import com.example.ss6_exercise_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping(value = "/list")
    public ModelAndView BlogList() {
        ModelAndView modelAndView = new ModelAndView("/blog");
        modelAndView.addObject("blogList", this.iBlogService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping(value = "/create")
    public String createNewBlog(@ModelAttribute Blog blog,
                                RedirectAttributes redirectAttributes) {

        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message",
                "Congratulation! Your Blog is cool!");

        return "redirect:/blog/list";
    }
}
