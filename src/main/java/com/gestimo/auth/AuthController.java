package com.gestimo.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/auth")

@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthController {
   private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")

    
   public ResponseEntity<AuthResponse>login(@RequestBody LoginRequest loginRequest){
    return ResponseEntity.ok(authService.login(loginRequest));
   }

}
