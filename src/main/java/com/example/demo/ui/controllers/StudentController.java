package com.example.demo.ui.controllers;

import com.example.demo.models.User;
import com.example.demo.services.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    public UserService userService;

    @GetMapping("students")
    public String load(Model model) {
        List<User> list = userService.findAll().stream().filter(user -> user.getRole().equals(User.Role.STUDENT)).toList();
        model.addAttribute("users", list);
        return "students";
    }

    @PostMapping("openStudentForm")
    public ModelAndView openStudentForm(Integer id){
        return new ModelAndView("redirect:studentInfo", new ModelMap("id", id));
    }
}
