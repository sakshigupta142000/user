package com.jwtuser.controllers;


import com.jwtuser.dto.UserResponse;
import com.jwtuser.helper.JwtUtil;
import com.jwtuser.model.JwtRequest;
import com.jwtuser.model.JwtResponse;
import com.jwtuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

//for methods who generate token for the first time.
@RestController
@CrossOrigin

public class JwtController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    @RequestMapping(value = "/token",method= RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
//        System.out.println("======================================================");
        System.out.println(jwtRequest);
        try
        {

            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
        }catch(UsernameNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }catch (BadCredentialsException e)
        {
            e.printStackTrace();
            throw new Exception("Bad Credentials");
        }

        UserDetails userDetails=this.userService.loadUserByUsername(jwtRequest.getUsername());
        String token =this.jwtUtil.generateToken(userDetails);
        System.out.println("JWT"+token);

        return ResponseEntity.ok(new JwtResponse(token));
    }


//    @GetMapping("/getcurrentuser")
//    public UserDetails getCurrentUser(Principal principal){
//        return this.userService.loadUserByUsername(principal.getName());
//
//    }
}
