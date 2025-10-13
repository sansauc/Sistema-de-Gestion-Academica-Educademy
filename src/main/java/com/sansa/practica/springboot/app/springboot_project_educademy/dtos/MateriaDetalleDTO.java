package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Curso;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Profesor;

public class MateriaDetalleDTO {
    
    private Long idMateria;
    private String nombre;
    private List<Curso> cursos;
    private List<ProfesorSimpleInfoDTO> profesores;

    public MateriaDetalleDTO(Long idMateria, String nombre, List<Curso> cursos, Set<Profesor> profesores) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.cursos = cursos;
        //this.profesores = new ArrayList<>(profesores); //Asi se convierte de un set a un arrayList
        this.profesores = profesores.stream()
        .map(p -> new ProfesorSimpleInfoDTO(
            p.getId(), 
            p.getName(),
            p.getLastname(),
            p.getEmail(),
            p.getProfesorId()))
        .collect(Collectors.toList()); //Convertimos el profesor a un dto para que no muestre las materias que dicta cuando recuperamos la materia
    }

    
    public Long getIdMateria() {
        return idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<ProfesorSimpleInfoDTO> getProfesores() {
        return profesores;
    }
}
