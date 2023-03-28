package com.jwtuser.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class UserRequest {

    @NotNull(message="username is required")
    private String username;

    @NotNull(message="email is required")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    @NotNull(message="password is required")
    @Size(min=5,message="password is too short")
    @Size(max = 20, message = "password is too long")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

//    public UserRequest(String username, String email, String password) {
//        this.username = username;
//        this.email = email;
//        this.Password = password;
//    }



}
