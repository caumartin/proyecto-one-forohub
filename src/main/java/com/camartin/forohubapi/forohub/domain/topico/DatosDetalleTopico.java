package com.camartin.forohubapi.forohub.domain.topico;

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
        String respuestas
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
                topico.getRespuestas()
        );
    }
}
