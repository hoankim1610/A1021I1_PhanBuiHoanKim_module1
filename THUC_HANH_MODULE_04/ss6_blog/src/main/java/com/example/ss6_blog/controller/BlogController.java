package com.example.ss6_blog.controller;

import com.example.ss6_blog.model.Blog;
import com.example.ss6_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping(value = "")
    public ModelAndView goBlogList() {

        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogList", this.iBlogService.findAll());

        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String goCreateBlog(Model model) {

        model.addAttribute("blog", new Blog());

        return "/blog/create";
    }

    @PostMapping(value = "/save")
    public String createBlog(@ModelAttribute Blog blog,
                                RedirectAttributes redirectAttributes) {

        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message",
                "Congratulation!");

        return "redirect:";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") int id) {
        iBlogService.delete(id);
        return "redirect:";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showUpdatePage(@PathVariable (name = "id") int id) {
        ModelAndView updateBlog = new ModelAndView("/blog/edit");
        Optional<Blog> blog = iBlogService.findById(id);
        updateBlog.addObject("blog",blog);

        return updateBlog;
    }
}
