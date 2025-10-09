package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Curso;

public interface CursoService {

    List<Curso> findAll();
    Optional<Curso> findById(Long id);
    Curso save(Curso curso);
    Optional<Curso> delete(Long id);

}
