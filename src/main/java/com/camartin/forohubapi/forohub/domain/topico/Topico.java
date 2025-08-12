package com.camartin.forohubapi.forohub.domain.topico;

import com.camartin.forohubapi.forohub.domain.usuario.Usuario;
import com.camartin.forohubapi.forohub.infra.security.TokenService;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Status estado;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    private List<String> respuestas;

    public Topico(DatosCrearTopico topico, String usuario) {

        this.id = null;
        this.titulo = topico.titulo();
        this.mensaje = topico.mensaje();
        this.fechaCreacion = LocalDateTime.now();//toInstant(ZoneOffset.of("-03:00"));
        this.estado = Status.ACTIVO;
        this.autor = usuario;
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
        //if (datos.autor() != null) {
        //    this.autor = datos.autor();
        //}
        if (datos.curso() != null) {
            this.curso = datos.curso();
        }
    }
}
