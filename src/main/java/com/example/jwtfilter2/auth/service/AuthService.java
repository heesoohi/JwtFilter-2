package com.example.jwtfilter2.auth.service;

import com.example.jwtfilter2.auth.dto.SigninRequest;
import com.example.jwtfilter2.auth.dto.SigninResponse;
import com.example.jwtfilter2.auth.dto.SignupRequest;
import com.example.jwtfilter2.auth.dto.SignupResponse;
import com.example.jwtfilter2.config.JwtUtil;
import com.example.jwtfilter2.user.dto.UserResponse;
import com.example.jwtfilter2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final UserService userService;

    @Transactional
    public SignupResponse signup(SignupRequest request) {
        UserResponse saveResult = userService.saveUser(request.getEmail());

        String bearerJwt = jwtUtil.createToken(saveResult.getId(), saveResult.getEmail());
        return new SignupResponse(bearerJwt);
    }

    @Transactional
    public SigninResponse signin(SigninRequest request) {
        UserResponse userResult = userService.findByEmail(request.getEmail());

        String bearerJwt = jwtUtil.createToken(userResult.getId(), request.getEmail());
        return new SigninResponse(bearerJwt);
    }
}
