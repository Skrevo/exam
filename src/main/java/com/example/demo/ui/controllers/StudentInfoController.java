package com.example.demo.ui.controllers;

import com.example.demo.models.HomeWork;
import com.example.demo.models.Student;
import com.example.demo.services.data.HomeWorkService;
import com.example.demo.services.data.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentInfoController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private HomeWorkService homeWorkService;

    @GetMapping("studentInfo")
    public String load(@RequestParam("id") Integer id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        model.addAttribute("homeworks", student.getHomeworks());
        model.addAttribute("grades", HomeWork.Grade.values());
        return "studentInfo";
    }

    @GetMapping("backToStudents")
    public String backToStudents() {
        return "redirect:students";
    }

    @PostMapping("updateStudentForm")
    public ModelAndView updateContactForm(
            @ModelAttribute Student student,
            @ModelAttribute HomeWork homeWork
    ){
        homeWork.setId(homeWork.getId());
        homeWork.setStudent(student);
        homeWork.setHomework(homeWork.getHomework());
        homeWorkService.save(homeWork);
        studentService.save(student);
        return new ModelAndView("redirect:studentInfo",
                new ModelMap("id", student.getId()));
    }
}
