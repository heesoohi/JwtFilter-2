package com.example.jwtfilter2.user.service;

import com.example.jwtfilter2.user.dto.UserResponse;
import com.example.jwtfilter2.user.entity.User;
import com.example.jwtfilter2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse saveUser(String email) {

        if (userRepository.existsByEmail(email)) {
            throw new IllegalStateException("이미 가입된 이메일 입니다.");
        }

        User savedUser = userRepository.save(new User(email));

        return new UserResponse(savedUser.getId(), savedUser.getEmail());
    }

    @Transactional(readOnly = true)
    public UserResponse findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalStateException("유저를 찾을 수 없습니다.")
        );

        return new UserResponse(user.getId(), user.getEmail());
    }

    @Transactional(readOnly = true)
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponse(user.getId(), user.getEmail()))
                .toList();
    }
}
