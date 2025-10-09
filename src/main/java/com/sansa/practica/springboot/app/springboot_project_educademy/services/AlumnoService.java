package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Alumno;

public interface AlumnoService {

    List<Alumno> findAll();
    Optional<Alumno> findById(Long id);
    Alumno save(Alumno alumno);
    Optional <Alumno> update(Long id, Alumno alumno);
    Optional<Alumno> delete(Long id);

    

}
