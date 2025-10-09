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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Curso;
import com.sansa.practica.springboot.app.springboot_project_educademy.services.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping
    public List<Curso> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) { 
        Optional<Curso> cursoOptional = service.findById(id);
        if (cursoOptional.isPresent()) {
            return ResponseEntity.ok(cursoOptional.orElseThrow()); 
        }
        return ResponseEntity.notFound().build(); 
    }

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Curso> cursoOptional = service.delete(id);
        if (cursoOptional.isPresent()) {
            return ResponseEntity.ok(cursoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
