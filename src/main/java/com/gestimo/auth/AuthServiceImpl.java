package com.gestimo.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.gestimo.agence_immobiliere.AgenceImmobiliereRepository;
import com.gestimo.security.JwtUtils;
import com.gestimo.utilisateur.Utilisateur;
import com.gestimo.utilisateur.UtilisateurRepository;

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
    final AgenceImmobiliereRepository aiRepository;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtUtils jwtUtils,
            UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder,
            AgenceImmobiliereRepository aiRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = passwordEncoder;
        this.aiRepository = aiRepository;
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        if (request.tel() == null || request.password() == null) {
            throw new IllegalArgumentException("Username and password must be provided");
        }
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        request.tel(), request.password()));
        Utilisateur user = utilisateurRepository.findByTelephone(request.tel())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        String token = jwtUtils.generateToken(user);
        return new AuthResponse(token);
    }

    @Override
    public String register(RegisterRequest request) {
        Utilisateur utilisateur = Utilisateur.builder()
                .dateDeNaissance(request.dateDeNaissance())
                .dateDebutPiece(request.dateDebutPiece())
                .dateFinPiece(request.dateFinPiece())
                .email(request.email())
                .enabled(true)
                .idAgence(aiRepository.findById(request.idAgence()).orElse(null))
                .motDePasse(passwordEncoder.encode(request.motDePasse()))
                .nomEtPrenomS(request.nomEtPrenomS())
                .pieceIdentite(request.pieceIdentite())
                .telephone(request.telephone())
                
                .accountlocked(false)
                .build();

        utilisateurRepository.save(utilisateur);
        return "Opération réussie !";
    }

}
