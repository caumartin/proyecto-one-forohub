package com.camartin.forohubapi.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCrearTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        //@NotBlank String autor,
        @NotNull Curso curso) {

}
