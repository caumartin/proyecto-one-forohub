package com.camartin.forohubapi.forohub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Table(name="topicos")
@Entity(name="Topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Status estado;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private List<String> respuestas;

    public Topico(DatosCrearTopico topico) {
        this.id = null;
        this.titulo = topico.titulo();
        this.mensaje = topico.mensaje();
        this.fechaCreacion = "10/08/2025";
        this.estado = Status.ACTIVO;
        this.autor = topico.autor();
        this.curso = topico.curso();
        this.respuestas = null;

    }

    public void actualizarDatos(@Valid DatosActualizacionTopico datos) {

        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.autor() != null) {
            this.autor = datos.autor();
        }
        if (datos.curso() != null) {
            this.curso = datos.curso();
        }
    }
}
