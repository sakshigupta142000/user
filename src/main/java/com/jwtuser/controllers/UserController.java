package com.jwtuser.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/welcome")
    public String welcome(){
        String text="this is private page";
        text+="this page is not allowed to unauthorized users";
        return text;
    }
    @RequestMapping("/getusers")
    public String getUser(){
        return "{\"name\":\"sakshi\"}";
    }
}
