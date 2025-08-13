package com.camartin.forohubapi.forohub.domain.topico;

import com.camartin.forohubapi.forohub.domain.respuesta.Respuesta;
import com.camartin.forohubapi.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private Status estado;
    @ManyToOne
    @JoinColumn (name = "creador", nullable = false)
    private Usuario creador;
    @Enumerated(EnumType.STRING)
    private Curso curso;
    @OneToMany (mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Respuesta> respuestas;

    public Topico(DatosCrearTopico topico, Usuario usuario) {

        this.id = null;
        this.titulo = topico.titulo();
        this.mensaje = topico.mensaje();
        //this.fechaCreacion = LocalDateTime.now();
        this.estado = Status.ACTIVO;
        this.creador = usuario;
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
        if (datos.curso() != null) {
            this.curso = datos.curso();
        }
    }
}
