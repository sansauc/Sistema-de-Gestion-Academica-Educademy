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

import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.AlumnoInfoDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.AlumnoRequestDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.AlumnoResponseDTO;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Alumno;
import com.sansa.practica.springboot.app.springboot_project_educademy.services.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    // --------------- LISTAR ----------------------

    /*
     * @GetMapping
     * public List<AlumnoResponseDTO> list() {
     * return service.findAll()
     * .stream()
     * .map(a -> new AlumnoResponseDTO(
     * a.getId(),
     * a.getDni(),
     * a.getName(),
     * a.getLastname(),
     * a.getEmail(),
     * a.getBirthdate(),
     * a.getStudentId(),
     * a.getFechaInscripcion()))
     * .collect(Collectors.toList());
     * }
     */// Este codigo sirve

    @GetMapping
    public List<AlumnoResponseDTO> list() {
        return service.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }// otra forma de hacerlo, usando el metodo convertToResponseDTO

    // --------------- VER EN DETALLE ----------------------

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) { // devuelve un ResponseEntity (respuesta HTTP personalizada).
        Optional<Alumno> alumOptional = service.findById(id);
        if (alumOptional.isPresent()) {
            Alumno a = alumOptional.get();
            AlumnoInfoDTO dto = this.convertToDetailDTO(a);
            return ResponseEntity.ok(dto); // Si el alumno existe, lo devuelve con un estado HTTP
                                           // 200 OK. Devuelve un dto
        }
        return ResponseEntity.notFound().build(); // Si el alumno no fue encontrado, devuelve una respuesta HTTP 404 Not
                                                  // // Found.
    }

    // --------------- CREAR ----------------------

    /*
     * Crear sin dtos
     * 
     * @PostMapping
     * public ResponseEntity<Alumno> create(@RequestBody Alumno alumno) {
     * return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumno));
     * }
     */

    // Crear con Dto

    @PostMapping
    public ResponseEntity<?> create(@RequestBody AlumnoRequestDTO alumnoDTO) {
        Alumno alumno = convertToEntity(alumnoDTO);
        Optional<Alumno> saved = service.saveIfNotExists(alumno);
        if (saved.isPresent()) {
            AlumnoResponseDTO response = convertToResponseDTO(saved.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Ya existe un alumno con el mismo email o studentId");
        }
    }

    // --------------- ACTUALIZAR ----------------------

    /*
     * @PutMapping("/{id}")
     * public ResponseEntity<?> update(@RequestBody Alumno alumno, @PathVariable
     * Long id) {
     * Optional<Alumno> alumOptional = service.update(id, alumno);
     * if (alumOptional.isPresent()) {
     * return
     * ResponseEntity.status(HttpStatus.CREATED).body(alumOptional.orElseThrow());
     * }
     * return ResponseEntity.notFound().build();
     * }
     */// Esto sirve, metodo sin dto

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AlumnoRequestDTO alumnoDTO) {
        Alumno alumno = convertToEntity(alumnoDTO);
        Optional<Alumno> updated = service.update(id, alumno);
        if (updated.isPresent()) {
            AlumnoResponseDTO response = convertToResponseDTO(updated.get());
            System.out.println("Hasta aca llego, nuevo email alumno: " + response.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.notFound().build();
    }

    // --------------- BORRAR ----------------------

    /*
     * @DeleteMapping("/{id}")
     * public ResponseEntity<?> delete(@PathVariable Long id) {
     * Optional<Alumno> alumOptional = service.delete(id);
     * if (alumOptional.isPresent()) {
     * return ResponseEntity.ok(alumOptional.orElseThrow());
     * }
     * return ResponseEntity.notFound().build();
     * }
     */// Esto sirve, metodo sin dto
     
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Alumno> deleted = service.delete(id);
        if (deleted.isPresent()) {
            AlumnoResponseDTO response = convertToResponseDTO(deleted.get());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    // ----------- MÉTODOS DE CONVERSIÓN --------------

    private Alumno convertToEntity(AlumnoRequestDTO dto) {
        Alumno a = new Alumno();
        a.setDni(dto.getDni());
        a.setName(dto.getName());
        a.setLastname(dto.getLastname());
        a.setEmail(dto.getEmail());
        a.setBirthdate(dto.getBirthdate());
        a.setStudentId(dto.getStudentId());
        a.setFechaInscripcion(dto.getFechaInscripcion());
        // NOTA: no se asignan curso ni materias cursadas aquí.
        return a;
    }

    private AlumnoInfoDTO convertToDetailDTO(Alumno a) {
        AlumnoInfoDTO dto = new AlumnoInfoDTO(
                a.getId(),
                a.getDni(),
                a.getName(),
                a.getLastname(),
                a.getEmail(),
                a.getBirthdate(),
                a.getStudentId(),
                a.getFechaInscripcion(),
                a.getCursoActual(),
                a.getMateriasCursadas());
        return dto;
    }

    private AlumnoResponseDTO convertToResponseDTO(Alumno a) {
        return new AlumnoResponseDTO(
                a.getId(),
                a.getDni(),
                a.getName(),
                a.getLastname(),
                a.getEmail(),
                a.getBirthdate(),
                a.getStudentId(),
                a.getFechaInscripcion());
    }
}
