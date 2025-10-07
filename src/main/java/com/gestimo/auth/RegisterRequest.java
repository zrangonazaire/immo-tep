package com.gestimo.auth;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RegisterRequest(

  Long idAgence,
  LocalDateTime dateDeNaissance,
  LocalDateTime dateDebutPiece,
  LocalDateTime dateFinPiece,
  String email,
  @NotBlank(message = "Le nom et prénom est obligatoire")
  @NotNull(message = "Le nom et prénom est obligatoire")
  String nomEtPrenomS,
  @NotBlank(message = "Le mot de passe est obligatoire")
  @NotNull(message = "Le mot de passe est obligatoire")
  String motDePasse,
  @NotBlank(message = "Le numéro de téléphone est obligatoire")
  @NotNull(message = "Le numéro de téléphone est obligatoire")
  String telephone,

  String pieceIdentite,
  Long roleId
) {

}

