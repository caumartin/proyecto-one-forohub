package com.camartin.forohubapi.forohub.controller;

import com.camartin.forohubapi.forohub.topico.DatosActualizacionTopico;
import com.camartin.forohubapi.forohub.topico.DatosCrearTopico;
import com.camartin.forohubapi.forohub.topico.TopicoRepository;
import com.camartin.forohubapi.forohub.topico.Topico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public void crear(@RequestBody @Valid DatosCrearTopico topico) {
        repository.save(new Topico(topico));
    }

    @GetMapping
    public List<Topico> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Topico> listarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @Transactional
    @PutMapping("/{id}")
    public void actualizar(@RequestBody @Valid DatosActualizacionTopico datos, @PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.actualizarDatos(datos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Long id){
        repository.deleteById(id);
    }

}
