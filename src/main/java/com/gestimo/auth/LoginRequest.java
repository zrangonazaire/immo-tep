package com.gestimo.auth;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
    @NotBlank(message = "Le numéro de téléphone est obligatoire")
    String tel,
    @NotBlank(message = "Le mot de passe est obligatoire")
    String password
) {

}
