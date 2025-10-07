package com.gestimo.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.gestimo.role.Role;
import com.gestimo.security.JwtUtils;
import com.gestimo.utilisateur.Utilisateur;
import com.gestimo.utilisateur.UtilisateurRepository;

import java.util.Collection;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@Transactional

@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {
    final AuthenticationManager authenticationManager;
    final JwtUtils jwtUtils;
    final UtilisateurRepository utilisateurRepository;
    final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtUtils jwtUtils,
            UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        if (request.tel() == null || request.password() == null) {
            throw new IllegalArgumentException("Username and password must be provided");
        }
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        request.tel(), request.password()));
        Utilisateur user = utilisateurRepository.findByTelephone(request.tel())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        // Collection<String> roleNames = user.getRoles().stream()
        // .map(role -> ((Role) role).getNomRole())
        // .toList();
        // if (roleNames.isEmpty()) {
        // throw new IllegalArgumentException("User has no roles");
        // }
        String token = jwtUtils.generateToken(user.getUsername(), null);
        return new AuthResponse(token);
    }

    @Override
    public String register(RegisterRequest request) {
        return null;
    }

}
