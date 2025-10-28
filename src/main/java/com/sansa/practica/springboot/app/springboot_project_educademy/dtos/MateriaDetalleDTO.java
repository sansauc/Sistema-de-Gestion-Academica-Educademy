package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Curso;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Profesor;

public class MateriaDetalleDTO {
    
    private Long idMateria;
    private String nombre;
    private List<CursoResponseDTO> cursos;
    private List<ProfesorResponseDTO> profesores;

    public MateriaDetalleDTO(Long idMateria, String nombre, Set<Curso> cursos, Set<Profesor> profesores) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.cursos = cursos.stream()
        .map(c -> new CursoResponseDTO(
            c.getIdCurso(),
            c.getNroCurso(),
            c.getDivisionCurso()))
        .collect(Collectors.toList());
        //this.profesores = new ArrayList<>(profesores); //Asi se convierte de un set a un arrayList
        this.profesores = profesores.stream()
        .map(p -> new ProfesorResponseDTO(
            p.getId(), 
            p.getDni(),
            p.getName(),
            p.getLastname(),
            p.getEmail(),
            p.getBirthdate(),
            p.getProfesorId(),
            p.getFechaIngreso()))
        .collect(Collectors.toList()); //Convertimos el profesor a un dto para que no muestre las materias que dicta cuando recuperamos la materia
    }
    
    public Long getIdMateria() {
        return idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public List<CursoResponseDTO> getCursos() {
        return cursos;
    }

    public List<ProfesorResponseDTO> getProfesores() {
        return profesores;
    }
}
