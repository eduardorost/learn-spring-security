package br.com.learnspringsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/actions")
public class ActionController {

    @GetMapping("/user")
    @Secured({"ROLE_USER"})
    public ResponseEntity<String> user() {
        return ResponseEntity.ok("You have access.");
    }

    @GetMapping("/admin")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<String> admin() {
        return ResponseEntity.ok("You have access.");
    }

}
