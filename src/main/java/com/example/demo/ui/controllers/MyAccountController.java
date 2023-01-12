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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyAccountController {

    @Autowired
    private HomeWorkService homeWorkService;

    @GetMapping("myAccount")
    public String load(Model model){
        List<HomeWork> list = homeWorkService.findAll();
        model.addAttribute("homeworks", list);
        return "myAccount";
    }

    @PostMapping("updateHomework")
    public ModelAndView updateHomework(Integer id){
        return new ModelAndView("redirect:homework", new ModelMap("id", id));
    }
}
