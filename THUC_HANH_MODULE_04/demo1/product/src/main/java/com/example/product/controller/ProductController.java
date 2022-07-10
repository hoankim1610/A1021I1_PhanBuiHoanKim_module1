package com.example.product.controller;

import com.example.product.model.Category;
import com.example.product.service.ICategoryService;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute
    public List<Category> getList() {
        return iCategoryService.findAll();
    }

    @GetMapping(value = "")
    public ModelAndView goList(@PageableDefault(size = 2) Pageable pageable) {

        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("productList", this.iProductService.findAll(pageable));

        return modelAndView;
    }

}
