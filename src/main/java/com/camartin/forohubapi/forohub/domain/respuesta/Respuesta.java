package com.camartin.forohubapi.forohub.domain.respuesta;

import com.camartin.forohubapi.forohub.domain.topico.Curso;
import com.camartin.forohubapi.forohub.domain.topico.Status;
import com.camartin.forohubapi.forohub.domain.topico.Topico;
import com.camartin.forohubapi.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Table(name="respuestas")
@Entity(name="Respuesta")

public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @ManyToOne
    @JoinColumn (name = "creador", nullable = false)
    private Usuario creador;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @ManyToOne
    @JoinColumn (name = "topico", nullable = false)
    private Topico topico;

    public Respuesta (DatosCrearRespuesta datos, Usuario usuario, Topico topico) {

        this.mensaje = datos.mensaje();
        this.creador = usuario;
        this.topico = topico;

    }
}
