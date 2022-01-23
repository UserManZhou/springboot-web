package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymleafController {


    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("msg", "Nihao");
        model.addAttribute("Link", "https://www.baidu.com");
        return "success";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
