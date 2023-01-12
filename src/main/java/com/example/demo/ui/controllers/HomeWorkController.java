package com.example.demo.ui.controllers;

import com.example.demo.models.HomeWork;
import com.example.demo.services.data.HomeWorkService;
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
public class HomeWorkController {

    @Autowired
    private HomeWorkService homeWorkService;

    @GetMapping("homework")
    public String load(@RequestParam ("id") Integer id, Model model) {
        HomeWork homeWork = homeWorkService.findById(id);
        model.addAttribute("homework",homeWork);
        return "homework";
    }

    @PostMapping("updateHomeworkForm")
    public ModelAndView updateHomeworkForm(@ModelAttribute HomeWork homeWork) {
        homeWorkService.save(homeWork);
        return new ModelAndView("redirect:homework",new ModelMap("id", homeWork.getId()));
    }
}
