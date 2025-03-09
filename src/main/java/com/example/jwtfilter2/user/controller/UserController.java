package com.example.jwtfilter2.user.controller;

import com.example.jwtfilter2.auth.annotation.Auth;
import com.example.jwtfilter2.auth.dto.AuthUser;
import com.example.jwtfilter2.user.dto.UserResponse;
import com.example.jwtfilter2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 로그인한 유저만 전체 유저 조회 가능한 api
    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers(@Auth AuthUser authUser) {
        return ResponseEntity.ok(userService.findAll());
    }
}
