package com.jzy.webcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
@PostMapping(value = "/user/login")
    public String userLogin(String username, String password, Map<String,Object> map, HttpSession session){
    if(!StringUtils.isEmpty(username)&&password.equals("123")){
        session.setAttribute("username",username);
        return "redirect:/main.html";
    }else{
        map.put("msg","用户名或密码错误");
        return "index";
    }
}
}
