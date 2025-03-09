package com.example.jwtfilter2.auth.dto;

import lombok.Getter;

@Getter
public class SignupResponse {
    private final String bearerJwt;

    public SignupResponse(String bearerJwt) {
        this.bearerJwt = bearerJwt;
    }
}
