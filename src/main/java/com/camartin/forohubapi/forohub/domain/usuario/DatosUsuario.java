package com.camartin.forohubapi.forohub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(
        @NotBlank @Email String login,
        @NotBlank String password) {
}
