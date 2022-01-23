package com.springboot.web.controller;

import com.springboot.web.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ResponseController {

    @Autowired
    private Person person;

    @RequestMapping("/test/json")
    @ResponseBody
    public Person json(){
        return new Person(1,"nihao");
    }
    @PostMapping("/test/json")
    @ResponseBody
    public Person json2(){
        return new Person(1,"nihao");
    }

}
