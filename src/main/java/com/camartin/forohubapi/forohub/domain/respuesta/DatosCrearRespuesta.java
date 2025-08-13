package com.camartin.forohubapi.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;

public record DatosCrearRespuesta(

        @NotBlank String mensaje
){

}
