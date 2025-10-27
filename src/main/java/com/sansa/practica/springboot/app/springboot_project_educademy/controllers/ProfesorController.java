package com.sansa.practica.springboot.app.springboot_project_educademy.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.MateriaInfoDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.ProfesorRequestDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.ProfesorResponseDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.ProfesorSimpleInfoDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Profesor;
import com.sansa.practica.springboot.app.springboot_project_educademy.services.ProfesorService;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService service;

    // --------------- LISTAR ----------------------

    @GetMapping
    public List<ProfesorResponseDTO> list() {
        return service.findAll()
                .stream()
                .map(this::convertToResponsDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Profesor> profOptional = service.findById(id);
        if (profOptional.isPresent()) {
            Profesor p = profOptional.get();
            ProfesorSimpleInfoDTO dto = this.convertToDetailDTO(p);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProfesorRequestDTO profesorDTO) {
        Profesor profesor = converToEntity(profesorDTO);
        Optional<Profesor> saved = service.saveIfNotExists(profesor);
        if (saved.isPresent()) {
            ProfesorResponseDTO response = convertToResponsDTO(saved.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe un profesor con esos datos");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProfesorRequestDTO profesorDTO, @PathVariable Long id) {
        Profesor profesor = converToEntity(profesorDTO);
        Optional<Profesor> updated = service.update(id, profesor);
        if (updated.isPresent()) {
            ProfesorResponseDTO response = convertToResponsDTO(updated.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Profesor> deleted = service.delete(id);
        if (deleted.isPresent()) {
            ProfesorResponseDTO response = convertToResponsDTO(deleted.get());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    // ----------- MÉTODOS DE CONVERSIÓN --------------

    private Profesor converToEntity(ProfesorRequestDTO dto) {
        Profesor p = new Profesor();
        p.setDni(dto.getDni());
        p.setName(dto.getName());
        p.setLastname(dto.getLastname());
        p.setEmail(dto.getEmail());
        p.setBirthdate(dto.getBirthdate());
        p.setProfesorId(dto.getProfesorID());
        p.setFechaIngreso(dto.getFechaIngreso());
        return p;
    }

    private ProfesorSimpleInfoDTO convertToDetailDTO(Profesor p) {
        ProfesorSimpleInfoDTO dto = new ProfesorSimpleInfoDTO(
                p.getId(),
                p.getDni(),
                p.getName(),
                p.getLastname(),
                p.getEmail(),
                p.getBirthdate(),
                p.getProfesorId(),
                p.getFechaIngreso(),
                p.getMateriasDictadas());
        return dto;
    }

    private ProfesorResponseDTO convertToResponsDTO(Profesor p) {
        return new ProfesorResponseDTO(
                p.getId(),
                p.getDni(),
                p.getName(),
                p.getLastname(),
                p.getEmail(),
                p.getBirthdate(),
                p.getProfesorId(),
                p.getFechaIngreso());
    }

}
