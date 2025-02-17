package com.example.jwtbearer.service;

import com.example.jwtbearer.model.RegisterRequest;
import com.example.jwtbearer.model.UserCredential;
import com.example.jwtbearer.user.User;
import com.example.jwtbearer.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     *
     * @param  request
     * @return JWT token
     */
    public String register(RegisterRequest request) {
        User user = new User();
        user.setFirstname(request.firstName());
        user.setLastname(request.lastName());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        // should be enum
        user.setRole("Admin");

        userRepository.save(user);

        return jwtService.generateToken(user);
    }

    /**
     *
     * @param credential
     * @return JWT token
     */
    public String login(UserCredential credential) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credential.email(),
                        credential.password()
                )
        );

        User user = userRepository.findByEmail(credential.email())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with given email"));

        return jwtService.generateToken(user);
    }
}
