package com.camartin.forohubapi.forohub.domain.topico;

import com.camartin.forohubapi.forohub.domain.respuesta.DatosDetalleRespuesta;
import com.camartin.forohubapi.forohub.domain.respuesta.Respuesta;
import com.camartin.forohubapi.forohub.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status estado,
        String creador,
        Curso curso,
        List<DatosDetalleRespuesta> respuestas
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                topico.getCreador().getUsername(),
                topico.getCurso(),
                topico.getRespuestas().stream().map(res -> new DatosDetalleRespuesta(res)).toList()
        );
    }
}
