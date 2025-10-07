package com.gestimo.auth;

public interface AuthService {
    public AuthResponse login(LoginRequest request);
    public String register(RegisterRequest request);

}
