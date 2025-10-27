package com.sansa.practica.springboot.app.springboot_project_educademy.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;

public interface MateriaRepository extends CrudRepository<Materia, Long>{

    Optional<Materia> findByNombre(String nombre);

}
