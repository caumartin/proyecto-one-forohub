package com.camartin.forohubapi.forohub.domain.topico;

import java.util.List;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        String fechaCreacion,
        Status estado,
        String autor,
        Curso curso,
        List<String> respuestas
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getEstado(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getRespuestas()
        );
    }
}
