package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Profesor;

public interface ProfesorService {

    List<Profesor> findAll();
    Optional<Profesor> findById(Long id);
    Profesor save(Profesor profesor);
    Optional<Profesor> update(Long id, Profesor profesor);
    Optional<Profesor> delete(Long id);
    Optional<Profesor> agregarMateria(Long id, Materia materia);
    Optional<Profesor> quitarMateria(Long id, Materia materia);

}
