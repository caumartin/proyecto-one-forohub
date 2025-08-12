package com.camartin.forohubapi.forohub.controller;

import com.camartin.forohubapi.forohub.domain.topico.*;
import com.camartin.forohubapi.forohub.domain.usuario.UsuarioRepository;
import com.camartin.forohubapi.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PostMapping
    public ResponseEntity crear(@RequestBody @Valid DatosCrearTopico datos, UriComponentsBuilder uriComponentsBuilder, @RequestHeader("Authorization") String autorizacion) {
        //System.out.println(autorizacion);

        var subject = tokenService.getSubject(autorizacion.replace("Bearer ",""));
        var usuario = usuarioRepository.findByLogin(subject);

        var topico = new Topico(datos, usuario.getUsername());
        repository.save(topico);
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico. getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity listar() {
        var respuesta = repository.findAll();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPorId(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopico datos, @PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.actualizarDatos(datos);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity borrar(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
