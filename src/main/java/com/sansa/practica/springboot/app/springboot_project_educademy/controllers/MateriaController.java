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

import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.MateriaDetalleDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.MateriaInfoDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.ProfesorSimpleInfoDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Profesor;
import com.sansa.practica.springboot.app.springboot_project_educademy.services.MateriaService;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private MateriaService service;

    @GetMapping
    public List<MateriaInfoDTO> list() {
        return service.findAll()
                .stream()
                .map(this::convertToMateriaInfoDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Materia> materiaOptional = service.findById(id);
        if (materiaOptional.isPresent()) {
            Materia m = materiaOptional.get();
            MateriaDetalleDTO dto = this.convertToMateriaDetalleDTO(m);
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MateriaInfoDTO dto) {
        Materia materia = this.convertToEntity(dto);
        Optional<Materia> saved = service.saveIfNotExists(materia);
        if (saved.isPresent()){
            MateriaInfoDTO response = convertToMateriaInfoDTO(saved.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else{
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Ya existe una materia con ese nombre");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Materia> deleted = service.delete(id);
        if (deleted.isPresent()) {
            MateriaDetalleDTO response = convertToMateriaDetalleDTO(deleted.get());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/agregar-profesor")
    public ResponseEntity<?> agregarProfesor(@RequestBody ProfesorSimpleInfoDTO profesorDto, @PathVariable Long id) {
        Profesor profesor = converToEntityProfesor(profesorDto);
        Optional<Materia> materOptional = service.agregarProfesor(id, profesor);
        if (materOptional.isPresent()) {
            return ResponseEntity.ok(materOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/quitar-profesor")
    public ResponseEntity<?> quitarProfesor(@RequestBody ProfesorSimpleInfoDTO profesorDto, @PathVariable Long id) {
        Profesor profesor = converToEntityProfesor(profesorDto);
        Optional<Materia> materOptional = service.quitarProfesor(id, profesor);
        if (materOptional.isPresent()) {
            return ResponseEntity.ok(materOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // ----------- MÉTODOS DE CONVERSIÓN --------------

    private Materia convertToEntity(MateriaInfoDTO m){
        Materia materia = new Materia();
        materia.setIdMateria(m.getIdMateria());
        materia.setNombre(m.getNombre());
        return materia;
    } 

    private MateriaDetalleDTO convertToMateriaDetalleDTO(Materia m) {
        return new MateriaDetalleDTO(
                m.getIdMateria(),
                m.getNombre(),
                m.getCursos(),
                m.getProfesores());
    }

    private MateriaInfoDTO convertToMateriaInfoDTO(Materia m){
        return new MateriaInfoDTO(
            m.getIdMateria(), 
            m.getNombre());
    }

    private Profesor converToEntityProfesor(ProfesorSimpleInfoDTO dto){
        Profesor profesor = new Profesor();
        profesor.setId(dto.getId());
        profesor.setDni(dto.getDni());
        profesor.setName(dto.getName());
        profesor.setLastname(dto.getLastname());
        profesor.setEmail(dto.getEmail());
        profesor.setBirthdate(dto.getBirthdate());
        profesor.setProfesorId(dto.getProfesorId());
        profesor.setFechaIngreso(dto.getFechaIngreso());
        return profesor;
    }

}
