package com.jwtuser.controllers;


import com.jwtuser.dto.UserRequest;
import com.jwtuser.dto.UserResponse;
import com.jwtuser.model.User;
import com.jwtuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("/welcome")
    public String welcome(){
        String text="this is private page";
        text+="this page is not allowed to unauthorized users";
        return text;
    }
    @PostMapping("/signup")
    public UserResponse signup(@Valid @RequestBody UserRequest userRequest) {
        User user= userService.createUser(userRequest);
        UserResponse userResponse=new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setStatus(user.getStatus());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        userResponse.setProfile(user.getProfile());
        return userResponse;
    }

    @RequestMapping("/getusers")
    public String getUser(){
        return "{\"name\":\"sakshi\"}";
    }
}
