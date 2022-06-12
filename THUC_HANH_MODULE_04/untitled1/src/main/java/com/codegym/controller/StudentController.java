package com.codegym.controller;

import com.codegym.model.Student;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView goStudentList() {

        ModelAndView modelAndView = new ModelAndView("list_student");
        modelAndView.addObject("studentList", this.iStudentService.findAll());

        return modelAndView;
    }

    @GetMapping(value = "/detail")
    public String goDetailStudent(@RequestParam Integer id, Model model) {
        Student studentObj = this.iStudentService.findById(id);
        model.addAttribute("studentObj", studentObj);

        return "detail_student";
    }

    @GetMapping(value = "/detail/{id}")
    public String goDetailStudentPV(@PathVariable Integer id, Model model) {
        Student studentObj = this.iStudentService.findById(id);
        model.addAttribute("studentObj", studentObj);

        return "detail_student";
    }

    @GetMapping(value = "/create")
    public String goCreateStudent(Model model) {

        model.addAttribute("student", new Student());

        return "create_student";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute Student student,
                                RedirectAttributes redirectAttributes) {

        this.iStudentService.save(student);
        redirectAttributes.addFlashAttribute("msg",
                "Register successfully!");

        return "redirect:/student/list";
    }
}
