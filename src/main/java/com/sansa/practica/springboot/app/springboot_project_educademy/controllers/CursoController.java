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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.CursoDetalleDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.CursoRequestDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.CursoResponseDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Curso;
import com.sansa.practica.springboot.app.springboot_project_educademy.services.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    // ----- Listar ------//

    @GetMapping
    public List<CursoResponseDTO> list() {
        return service.findAll()
                .stream()
                .map(this::convertToResponsDTO)
                .collect(Collectors.toList());
    }

    // ----- Ver en Detalle ------//

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Curso> cursoOptional = service.findById(id);
        if (cursoOptional.isPresent()) {
            Curso c = cursoOptional.get();
            CursoDetalleDTO dto = this.convertToDetailDTO(c);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    // ----- Crear ------//
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CursoRequestDTO cursoDTO) {
        Curso curso = convertToEntity(cursoDTO);
        CursoResponseDTO response = convertToResponsDTO(service.save(curso));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ----- Eliminar ------//
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Curso> deleted = service.delete(id);
        if (deleted.isPresent()) {
            CursoResponseDTO response = convertToResponsDTO(deleted.get());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    // --------------- Métodos de Conversión ---------------------//

    private Curso convertToEntity(CursoRequestDTO c) {
        Curso curso = new Curso();
        curso.setNroCurso(c.getNroCurso());
        curso.setDivisionCurso(c.getDivisionCurso());
        return curso;
    }

    private CursoDetalleDTO convertToDetailDTO(Curso c) {
        return new CursoDetalleDTO(
                c.getIdCurso(),
                c.getNroCurso(),
                c.getDivisionCurso(),
                c.getMaterias());
    }

    private CursoResponseDTO convertToResponsDTO(Curso c) {
        return new CursoResponseDTO(
                c.getIdCurso(),
                c.getNroCurso(),
                c.getDivisionCurso());
    }

}
