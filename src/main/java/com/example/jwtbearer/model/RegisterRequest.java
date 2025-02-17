package com.example.jwtbearer.model;

public record RegisterRequest(
        String firstName, String lastName, String email, String password
        ) {
}
