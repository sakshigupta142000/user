package com.jwtuser.controllers;

import com.jwtuser.dto.UserResponse;
import com.jwtuser.model.User;
import com.jwtuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/internal")
@CrossOrigin
public class InternalApiController {

    @Autowired
    UserService userService;
    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        UserResponse userResponse = new UserResponse();
        User user = userService.getUser(id); //service giving id----entity
        userResponse.setId(user.getId() );
        userResponse.setUsername(user.getUsername());
        userResponse.setStatus(user.getStatus());
        userResponse.setEmail(user.getEmail());
        userResponse.setProfile(user.getProfile());
//        System.out.println("---------------------------------------------------------------------------");
        return userResponse ;

    }
}
