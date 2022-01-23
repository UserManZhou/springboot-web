package com.springboot.web.controller;


import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
public class ResourcesController {

    @RequestMapping("/resources")
    public String resources(){
        return "/haha/meta_1.jpg";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }

    @RequestMapping(value = "/data/{id}/owner/{username}",method = RequestMethod.GET)
    public Map<String,Object> data(
            @PathVariable(value = "id") int id,
            @PathVariable(value = "username") String username,
            @PathVariable Map<String,String> maps,
            @RequestHeader Map<String,String> headerMap,
            @RequestHeader(value = "host") String host,
            @RequestParam("age") int age,
            @RequestParam("inters") List<String> inters,
            @RequestParam Map<String,String> paramMap,
            HttpServletResponse response,
            @CookieValue(value = "_g") String _g
    ){
        Cookie cookie = new Cookie("_g", "dawdawda");
        response.addCookie(cookie);
        Set<Map.Entry<String, String>> entries = maps.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey()+next.getValue());
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pv", maps);
        map.put("zhangsan", "nihao");
        map.put("header", headerMap);
        map.put("host", host);
        map.put("inters", inters);
        map.put("age", age);
        map.put("paramMap", paramMap);
        map.put("cookie", cookie);
        return map;
    }

    @RequestMapping("/save")
    public Map<String,Object> save(@RequestBody String content){
        Map<String,Object> maps = new HashMap<>();
        maps.put("body", content);
        return maps;
    }
}
