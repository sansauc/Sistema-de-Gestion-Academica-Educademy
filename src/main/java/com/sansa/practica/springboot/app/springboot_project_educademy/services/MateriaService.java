package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;


public interface MateriaService {

    List<Materia> findAll();
    Optional<Materia> findById(Long id);
    Materia save(Materia materia);
    //Optional<Materia> update(Long id, Materia materia);
    Optional<Materia> delete(Long id);

}
