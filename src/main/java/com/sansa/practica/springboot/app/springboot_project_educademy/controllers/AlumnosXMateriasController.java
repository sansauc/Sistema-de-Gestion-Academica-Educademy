package com.sansa.practica.springboot.app.springboot_project_educademy.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.AlumnosXMateriasDetalleDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.AlumnosXMateriasRequestDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.AlumnosXMateriasResponseDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Alumno;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.AlumnosXMaterias;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Profesor;
import com.sansa.practica.springboot.app.springboot_project_educademy.services.AlumnosXMateriasServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/cursada")
public class AlumnosXMateriasController {

    @Autowired
    private AlumnosXMateriasServices service;

    // --------------- LISTAR ----------------------

    @GetMapping
    public List<AlumnosXMateriasResponseDTO> list() {
        return service.findAll()
                .stream()
                .map(this::convertTAlumnosXMateriasResponseDTO)
                .collect(Collectors.toList());
    }

    // --------------- VER EN DETALLE ----------------------

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<AlumnosXMaterias> alumnoXMateriaOptional = service.findById(id);
        if(alumnoXMateriaOptional.isPresent()){
            AlumnosXMaterias axm = alumnoXMateriaOptional.get();
            AlumnosXMateriasDetalleDTO dto = this.convertToAlumnosXMateriasDetalleDTO(axm);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    // --------------- CREAR ----------------------

    @PostMapping
    public ResponseEntity<?> create (@RequestBody AlumnosXMateriasRequestDTO dto) {

        AlumnosXMaterias alumnoXMateria = this.convertToEntity(dto);

        Optional<AlumnosXMaterias> saved = service.saveIfNotExists(alumnoXMateria);
        
        if(saved.isPresent()){
            AlumnosXMateriasResponseDTO response = this.convertTAlumnosXMateriasResponseDTO(saved.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ya existe la relación alumno - materia para el año: "+dto.getAnioCursado());
        }

    }
    

    // Métodos de Conversión

    private AlumnosXMaterias convertToEntity(AlumnosXMateriasRequestDTO axm) {

        AlumnosXMaterias alumnoXMateria = new AlumnosXMaterias();

        alumnoXMateria.setId(axm.getId());

        //JPA/Hibernate necesita objetos entidad completos (aunque sea solo con el ID) para manejar correctamente las relaciones, no solo los IDs primitivos.
        if(axm.getAlumnoId()!=null){
            Alumno alumno = new Alumno();
            alumno.setId(axm.getAlumnoId());
            alumnoXMateria.setAlumno(alumno);
        }

        if(axm.getMateriaId() != null){
            Materia materia = new Materia();
            materia.setIdMateria(axm.getMateriaId());
            alumnoXMateria.setMateria(materia);
        }

        alumnoXMateria.setAnioCursado(axm.getAnioCursado());
        
        //Convertir IDs a entidades Profesor 
        if(axm.getProfesoresId() != null){
            Set<Profesor> profesores = axm.getProfesoresId().stream()
                .map(id -> {
                    Profesor profesor = new Profesor();
                    profesor.setId(id);
                    return profesor;
                })
                .collect(Collectors.toSet());
            alumnoXMateria.setProfesores(profesores);
        }

        alumnoXMateria.setEstado("Cursando");

        return alumnoXMateria;

    }

    private AlumnosXMateriasDetalleDTO convertToAlumnosXMateriasDetalleDTO(AlumnosXMaterias axm) {
        return new AlumnosXMateriasDetalleDTO(
                axm.getId(),
                axm.getAlumno(),
                axm.getMateria(),
                axm.getAnioCursado(),
                axm.getEstado(),
                axm.getNotaFinal(),
                axm.getProfesores());
    }

    private AlumnosXMateriasResponseDTO convertTAlumnosXMateriasResponseDTO(AlumnosXMaterias axm) {
        return new AlumnosXMateriasResponseDTO(
                axm.getId(),
                axm.getAlumno().getId(),
                axm.getAlumno().getName() + " " + axm.getAlumno().getLastname(),
                axm.getMateria().getIdMateria(),
                axm.getMateria().getNombre(),
                axm.getAnioCursado(),
                axm.getEstado(),
                axm.getNotaFinal());
    }
}
