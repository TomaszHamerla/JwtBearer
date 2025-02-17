package com.example.jwtbearer.auth;

import com.example.jwtbearer.model.RegisterRequest;
import com.example.jwtbearer.model.UserCredential;
import com.example.jwtbearer.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/register")
    String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    String login(@RequestBody UserCredential credential) {
        return authService.login(credential);
    }
}
