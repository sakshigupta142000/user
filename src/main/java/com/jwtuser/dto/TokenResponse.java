package com.jwtuser.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenResponse {

    private String token;

    private UserResponse user;
}
