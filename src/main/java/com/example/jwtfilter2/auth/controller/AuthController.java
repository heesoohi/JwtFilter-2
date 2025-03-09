package com.example.jwtfilter2.auth.controller;

import com.example.jwtfilter2.auth.dto.SigninRequest;
import com.example.jwtfilter2.auth.dto.SigninResponse;
import com.example.jwtfilter2.auth.dto.SignupRequest;
import com.example.jwtfilter2.auth.dto.SignupResponse;
import com.example.jwtfilter2.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/auth/signin")
    public ResponseEntity<SigninResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authService.signin(request));
    }
}
