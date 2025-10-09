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

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Alumno;
import com.sansa.practica.springboot.app.springboot_project_educademy.services.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping
    public List<Alumno> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){ //devuelve un ResponseEntity (respuesta HTTP personalizada).
        Optional<Alumno> alumOptional = service.findById(id);
        if (alumOptional.isPresent()){
            return ResponseEntity.ok(alumOptional.orElseThrow()); //Si el alumno existe, lo devuelve con un estado HTTP 200 OK.
        }
        return ResponseEntity.notFound().build(); //Si el alumno no fue encontrado, devuelve una respuesta HTTP 404 Not Found.
    }

    @PostMapping
    public ResponseEntity<Alumno> create(@RequestBody Alumno alumno){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Alumno alumno, @PathVariable Long id){
        Optional<Alumno> alumOptional = service.update(id, alumno);
        if(alumOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(alumOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){ 
        Optional<Alumno> alumOptional = service.delete(id);
        if (alumOptional.isPresent()){
            return ResponseEntity.ok(alumOptional.orElseThrow()); 
        }
        return ResponseEntity.notFound().build(); 
    }
    

}
