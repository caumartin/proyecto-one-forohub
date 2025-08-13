package com.camartin.forohubapi.forohub.domain.respuesta;

import com.camartin.forohubapi.forohub.domain.topico.Curso;
import com.camartin.forohubapi.forohub.domain.topico.Status;
import com.camartin.forohubapi.forohub.domain.topico.Topico;

import java.time.LocalDateTime;
import java.util.List;

public record DatosDetalleRespuesta(
        Long id,
        String mensaje,
        String creador,
        LocalDateTime fechaCreacion,
        Long topico
        ) {

    public DatosDetalleRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getCreador().getUsername(),
                respuesta.getFechaCreacion(),
                respuesta.getTopico().getId()
        );
    }
}
