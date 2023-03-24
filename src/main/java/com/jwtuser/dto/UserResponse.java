package com.jwtuser.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {
    private Long id;

    private String username;

    private boolean status;

    private String email;

    private String Profile;

}
