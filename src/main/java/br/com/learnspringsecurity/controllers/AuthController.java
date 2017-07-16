package br.com.learnspringsecurity.controllers;

import br.com.learnspringsecurity.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/login")
public class AuthController {

    @GetMapping
    ResponseEntity<User> login(@AuthenticationPrincipal UsernamePasswordAuthenticationToken user) {
        return ResponseEntity.ok((User) user.getPrincipal());
    }
}

