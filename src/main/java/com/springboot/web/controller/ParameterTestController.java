package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ParameterTestController {


    // /cars/sell;low=34;brand=byd,audi,yd /{path}
    @GetMapping("/cars/{path}")
    @ResponseBody
    public Map cars(
            @MatrixVariable(value = "low") Integer low,
            @MatrixVariable(value = "brand") List<String> brand,
            @PathVariable String path
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    // /boss/1;age=20/2;age=10
    @GetMapping("/boss/{path}/{path2}")
    @ResponseBody
    public Map boss(
            @PathVariable(value = "path") String path,
            @PathVariable(value = "path2") String path2,
            @MatrixVariable(value = "age",pathVar = "path") int age,
            @MatrixVariable(value = "age",pathVar = "path2") int age2,
            Model model
    ){
        Map<String,Object> map = new HashMap<>();
        map.put("sss", "dwad");
        map.put("paht2",path2);
        map.put("age", age);
        map.put("age2", age2);
        return map;

    }
}
