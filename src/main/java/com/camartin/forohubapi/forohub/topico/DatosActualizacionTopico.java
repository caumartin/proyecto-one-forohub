package com.camartin.forohubapi.forohub.topico;

public record DatosActualizacionTopico(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        Curso curso) {

}
