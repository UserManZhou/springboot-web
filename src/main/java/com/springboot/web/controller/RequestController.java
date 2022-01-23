package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RequestController {

    @RequestMapping("/goto")
    public String go(HttpServletRequest request){
        request.setAttribute("name", "nhhwaiudhuadi");
        request.setAttribute("code","2313");
        return "forward:/success";
    }

    @RequestMapping("/success")
    @ResponseBody
    public Map<String,Object> success(@RequestAttribute("name") String name, @RequestAttribute("code") String code){
        System.out.println(name+"\t"+code);
        Map<String,Object> map = new HashMap<>();
        map.put("name", name);
        map.put("code", code);
        return map;
    }

}
