package com.example.product.controller;

import com.example.product.dto.ProductDTO;
import com.example.product.model.Category;
import com.example.product.model.Product;
import com.example.product.service.ICategoryService;
import com.example.product.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("")
    public String showList(Model model, @PageableDefault(size = 3) Pageable pageable,
                           Optional<String> nameSearch, Optional<String> categorySearch) {
        String nameSearchValue = "";
        String categorySearchValue = "";
        if (nameSearch.isPresent()) {
            nameSearchValue = nameSearch.get();
        }
        if (categorySearch.isPresent()) {
            categorySearchValue = categorySearch.get();
        }
        model.addAttribute("nameSearch", nameSearchValue);
        model.addAttribute("categorySearchValue", categorySearchValue);
        Page<Product> products = iProductService.findAll(pageable, nameSearchValue, categorySearchValue);
        model.addAttribute("productList", products);
        return "/product/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {

        model.addAttribute("productDTO", new ProductDTO());

        return "/product/form";
    }

    @PostMapping(value = "/save")
    public String save(@Validated @ModelAttribute ProductDTO productDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        Product product = new Product();
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Something is wrong. Try again!");
            return "/product/form";
        } else {
            BeanUtils.copyProperties(productDTO, product);
            iProductService.save(product);
            model.addAttribute("productDTO", productDTO);
            redirectAttributes.addFlashAttribute("message", "Congratulation! Success!");
        }
        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        Product product = iProductService.findById(id).orElse(null);
        model.addAttribute("productDTO", product);
        return "/product/form";
    }

    @GetMapping("/deletePage")
    public String showDelete(@RequestParam int id, Model model) {
        Product product = iProductService.findById(id).orElse(null);
        model.addAttribute("productDTO", product);
        return "/product/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        iProductService.delete(idDelete);
        redirectAttributes.addFlashAttribute("message", "Delete successfully!");
        return "redirect:/product";
    }

    @GetMapping(value = "/detail")
    public String goDetail(@RequestParam Integer id, Model model) {
        Product product = this.iProductService.findById(id).orElse(null);
        model.addAttribute("productObj", product);

        return "/product/detail";
    }
}
