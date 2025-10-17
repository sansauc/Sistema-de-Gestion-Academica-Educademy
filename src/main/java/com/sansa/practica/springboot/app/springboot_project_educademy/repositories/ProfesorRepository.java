package com.sansa.practica.springboot.app.springboot_project_educademy.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Profesor;

public interface ProfesorRepository extends CrudRepository<Profesor, Long> {

    Optional<Profesor> findByProfesorId(String profesorId);// Para que busque por profesorID

    Optional<Profesor> findByEmail(String email);

    Optional<Profesor> findByDni(Long dni);
}
