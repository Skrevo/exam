package com.example.demo.ui.controllers;

import com.example.demo.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String load() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority(User.Role.STUDENT.name())))
        return "redirect:myAccount";
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority(User.Role.TEACHER.name())))
            return "redirect:students";
        return "redirect:";
}
}
