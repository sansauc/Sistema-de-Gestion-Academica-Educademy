package com.sansa.practica.springboot.app.springboot_project_educademy.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Profesor;
import com.sansa.practica.springboot.app.springboot_project_educademy.services.MateriaService;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private MateriaService service;

    @GetMapping
    public List<Materia> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Materia> materiaOptional = service.findById(id);
        if (materiaOptional.isPresent()) {
            return ResponseEntity.ok(materiaOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Materia> create(@RequestBody Materia materia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(materia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Materia> materOptional = service.delete(id);
        if (materOptional.isPresent()) {
            return ResponseEntity.ok(materOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/agregar-profesor")
    public ResponseEntity<?> agregarProfesor(@RequestBody Profesor profesor, @PathVariable Long id) {
        Optional<Materia> materOptional = service.agregarProfesor(id, profesor);
        if (materOptional.isPresent()) {
            return ResponseEntity.ok(materOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/quitar-profesor")
    public ResponseEntity<?> quitarProfesor(@RequestBody Profesor profesor, @PathVariable Long id) {
        Optional<Materia> materOptional = service.quitarProfesor(id, profesor);
        if (materOptional.isPresent()) {
            return ResponseEntity.ok(materOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
