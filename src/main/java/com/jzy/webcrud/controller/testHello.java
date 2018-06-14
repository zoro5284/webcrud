package com.jzy.webcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class testHello {
    @RequestMapping("/hello")
    public String hello(Model model){
        Map<String,Object> map = new HashMap();
        map.put("hello","你好world");
        model.addAttribute("hello",map);
        return "success";
    }
}
