package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Profesor;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Curso;


public interface MateriaService {

    List<Materia> findAll();
    Optional<Materia> findById(Long id);
    Materia save(Materia materia);
    //Optional<Materia> update(Long id, Materia materia);
    Optional<Materia> delete(Long id);
    Optional<Materia> saveIfNotExists(Materia materia);
    Optional<Materia> agregarProfesor(Long idMateria, Profesor profesor);
    Optional<Materia> quitarProfesor(Long idMateria, Profesor profesor);
    Optional<Materia> agregarCurso(Long idMateria, Curso curso);
    Optional<Materia> quitarCurso(Long idMateria, Curso curso);

}
