package com.camartin.forohubapi.forohub.controller;

import com.camartin.forohubapi.forohub.domain.respuesta.DatosCrearRespuesta;
import com.camartin.forohubapi.forohub.domain.respuesta.DatosDetalleRespuesta;
import com.camartin.forohubapi.forohub.domain.respuesta.Respuesta;
import com.camartin.forohubapi.forohub.domain.topico.*;
import com.camartin.forohubapi.forohub.domain.usuario.Usuario;
import com.camartin.forohubapi.forohub.domain.usuario.UsuarioRepository;
import com.camartin.forohubapi.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos/{topicoId}/respuestas")
public class RespuestaController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PostMapping
    public ResponseEntity crear(@RequestBody @Valid DatosCrearRespuesta datos, UriComponentsBuilder uriComponentsBuilder, @RequestHeader("Authorization") String autorizacion, @PathVariable Long topicoId) {

        var subject = tokenService.getSubject(autorizacion.replace("Bearer ",""));
        //Saco usuario del JWT para usarlo como autor del tópico
        var usuario = (Usuario) usuarioRepository.findByLogin(subject);
        var topico = repository.getReferenceById(topicoId);
        var respuesta = new Respuesta(datos, usuario, topico);

        topico.getRespuestas().add(respuesta);
        repository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{topicoId}/respuestas/").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleRespuesta(respuesta));
    }

    @GetMapping
    public ResponseEntity listarRerspuestasPorTopico(@PathVariable Long topicoId) {
        var topico = repository.getReferenceById(topicoId);
        var respuestas = topico.getRespuestas();

        return ResponseEntity.ok(respuestas.stream().map(res -> new DatosDetalleRespuesta(res)));
    }

}
