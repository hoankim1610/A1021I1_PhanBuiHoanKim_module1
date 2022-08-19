package com.example.beforeexam.controller;

import com.example.beforeexam.model.Instructor;
import com.example.beforeexam.model.Student;
import com.example.beforeexam.dto.StudentDTO;
import com.example.beforeexam.service.IInstructorService;
import com.example.beforeexam.service.IStudentService;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IInstructorService iInstructorService;

    @ModelAttribute("students")
    public String getList(Model model) {
        model.addAttribute("instructorList",iInstructorService.findAll());
        return "list";
    }

//    @GetMapping(value = "")
//    public ModelAndView goList(@PageableDefault(size = 2) Pageable pageable) {
//
//        ModelAndView modelAndView = new ModelAndView("/student/list");
//        modelAndView.addObject("studentList", this.iStudentService.findAll(pageable));
//
//        return modelAndView;
//    }

    @GetMapping("")
    public String showList(Model model, @PageableDefault(size = 2) Pageable pageable,
                           Optional<String> nameSearch) {
        String nameSearchValue ="";
        if (nameSearch.isPresent()){
            nameSearchValue = nameSearch.get();
        }
        model.addAttribute("nameSearch",nameSearchValue);
        Page<Student> students = iStudentService.findAll(pageable,nameSearchValue);
        model.addAttribute("studentList", students);
        return "/student/list";
    }

//    @GetMapping("")
//    public String showList(Model model, @PageableDefault(size = 2) Pageable pageable) {
//        Page<Student> students = iStudentService.findAll(pageable);
//        model.addAttribute("studentList", students );
//        return "/student/list";
//    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {

        model.addAttribute("studentDTO", new StudentDTO());

        return "/student/form";
    }

    @PostMapping(value = "/save")
    public String save(@Validated @ModelAttribute StudentDTO studentDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        Student student = new Student();
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", "Something is wrong. Try again!");
            return "/student/form";
        } else {
            BeanUtils.copyProperties(studentDTO, student);
            iStudentService.save(student);
            model.addAttribute("blogDTO", studentDTO);
//            model.addAttribute("message", "Congratulation! Success!");
            redirectAttributes.addFlashAttribute("message", "Congratulation! Success!");
        }
        return "redirect:/student";
    }

//        iBlogService.save(blog);
//        redirectAttributes.addFlashAttribute("message",
//                "Congratulation!");
//
//        return "redirect:/blog";

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        Student student = iStudentService.findById(id).orElse(null);
        model.addAttribute("studentDTO", student);
        return "/student/form";
    }

    @GetMapping("/deletePage")
    public String showDelete(@RequestParam int id, Model model) {
        Student student = iStudentService.findById(id).orElse(null);
        model.addAttribute("studentDTO", student);
        return "/student/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {
        iStudentService.delete(idDelete);
        redirectAttributes.addFlashAttribute("message", "Delete successfully!");
        return "redirect:/student";
    }

    @GetMapping(value = "/detail")
    public String goDetail(@RequestParam Integer id, Model model) {
        Student student = this.iStudentService.findById(id).orElse(null);
        model.addAttribute("studentObj", student);

        return "/student/detail";
    }
}

