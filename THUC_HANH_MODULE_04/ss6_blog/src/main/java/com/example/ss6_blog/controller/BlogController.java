package com.example.ss6_blog.controller;

import com.example.ss6_blog.dto.BlogDTO;
import com.example.ss6_blog.model.Blog;
import com.example.ss6_blog.model.Category;
import com.example.ss6_blog.service.IBlogService;
import com.example.ss6_blog.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute
    public List<Category> getList() {
        return iCategoryService.findAll();
    }

//    @GetMapping(value = "")
//    public ModelAndView goBlogList(@PageableDefault(size = 2) Pageable pageable) {
//
//        ModelAndView modelAndView = new ModelAndView("/blog/list");
//        modelAndView.addObject("blogList", this.iBlogService.findAll(pageable));
//
//        return modelAndView;
//    }

    @GetMapping("")
    public String showList(Model model, @PageableDefault(size = 2) Pageable pageable,
                               Optional<String> nameSearch, Optional<String> categorySearch) {
        String nameSearchValue ="";
        String categorySearchValue ="";
        if (nameSearch.isPresent()){
            nameSearchValue =nameSearch.get();
        }
        if (categorySearch.isPresent()){
            categorySearchValue =categorySearch.get();
        }
        model.addAttribute("nameSearch",nameSearchValue);
        model.addAttribute("categorySearchValue",categorySearchValue);
        Page<Blog> blogs = iBlogService.findAll(pageable,nameSearchValue,categorySearchValue);
        model.addAttribute("blogList", blogs );
        return "/blog/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {

        model.addAttribute("blogDTO", new BlogDTO());

        return "/blog/createEdit";
    }

    @PostMapping(value = "/save")
    public String save(@Validated @ModelAttribute BlogDTO blogDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        Blog blog = new Blog();
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Something is wrong. Try again!");
            return "/blog/createEdit";
        } else {
            BeanUtils.copyProperties(blogDTO, blog);
            iBlogService.save(blog);
            model.addAttribute("blogDTO", blogDTO);
//            model.addAttribute("message", "Congratulation! Success!");
            redirectAttributes.addFlashAttribute("message", "Congratulation! Success!");
        }
        return "redirect:/blog";
    }

//        iBlogService.save(blog);
//        redirectAttributes.addFlashAttribute("message",
//                "Congratulation!");
//
//        return "redirect:/blog";

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        Blog blog = iBlogService.findById(id).orElse(null);
        model.addAttribute("blogDTO", blog);
        return "/blog/createEdit";
    }

    @GetMapping("/deletePage")
    public String showDelete(@RequestParam int id, Model model) {
        Blog blog = iBlogService.findById(id).orElse(null);
        model.addAttribute("blogDTO", blog);
        return "/blog/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        iBlogService.delete(idDelete);
        redirectAttributes.addFlashAttribute("message", "Delete successfully!");
        return "redirect:/blog";
    }

    @GetMapping(value = "/detail")
    public String goDetail(@RequestParam Integer id, Model model) {
        Blog blog = this.iBlogService.findById(id).orElse(null);
        model.addAttribute("blogObj", blog);

        return "/blog/detail";
    }

//    @GetMapping(value = "/detail/{id}")
//    public String detail(@PathVariable Integer id, Model model) {
//        Blog blog = iBlogService.findById(id).orElse(null);
//        model.addAttribute("blogDTO", blog);
//
//        return "redirect:/blog";
//    }
}

