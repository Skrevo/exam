package com.example.demo.ui.controllers;

import com.example.demo.models.HomeWork;
import com.example.demo.models.User;
import com.example.demo.services.data.HomeWorkService;
import com.example.demo.services.data.UserService;
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
    private UserService userService;

    @Autowired
    private HomeWorkService homeWorkService;

    @GetMapping("studentInfo")
    public String load(@RequestParam("id") Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("homeworks", user.getHomeworks());
        model.addAttribute("grades", HomeWork.Grade.values());
        return "studentInfo";
    }

    @GetMapping("backToStudents")
    public String backToStudents() {
        return "redirect:students";
    }

    @PostMapping("updateStudentForm")
    public ModelAndView updateContactForm(
            @ModelAttribute User user,
            @ModelAttribute HomeWork homeWork
    ){
        homeWork.setId(homeWork.getId());
        homeWork.setUser(user);
        homeWork.setHomework(homeWork.getHomework());
        homeWorkService.save(homeWork);
        userService.save(user);
        return new ModelAndView("redirect:studentInfo",
                new ModelMap("id", user.getId()));
    }
}
