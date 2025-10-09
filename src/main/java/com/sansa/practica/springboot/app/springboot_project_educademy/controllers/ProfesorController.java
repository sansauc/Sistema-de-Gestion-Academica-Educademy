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
import com.sansa.practica.springboot.app.springboot_project_educademy.services.ProfesorService;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService service;

    @GetMapping
    public List<Profesor> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Profesor> profOptional = service.findById(id);
        if (profOptional.isPresent()) {
            return ResponseEntity.ok(profOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Profesor> create(@RequestBody Profesor profesor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(profesor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> update(@RequestBody Profesor profesor, @PathVariable Long id) {
        Optional<Profesor> profOptional = service.update(id, profesor);
        if (profOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(profOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Profesor> profOptional = service.delete(id);
        if (profOptional.isPresent()) {
            return ResponseEntity.ok(profOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/agregar-materia")
    public ResponseEntity<?> agregarMateria(@RequestBody Materia materia, @PathVariable Long id){
        Optional<Profesor> profOptional = service.agregarMateria(id, materia);
        if(profOptional.isPresent()){
            return ResponseEntity.ok(profOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/quitar-materia")
    public ResponseEntity<?> quitarMateria(@RequestBody Materia materia, @PathVariable Long id){
        Optional<Profesor> profOptional = service.quitarMateria(id, materia);
        if(profOptional.isPresent()){
            return ResponseEntity.ok(profOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
