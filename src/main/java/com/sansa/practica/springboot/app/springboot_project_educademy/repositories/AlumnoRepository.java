package com.sansa.practica.springboot.app.springboot_project_educademy.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Alumno;


public interface AlumnoRepository extends CrudRepository <Alumno, Long> {

    Optional<Alumno> findByEmail(String email);

    Optional<Alumno> findByDni(Long dni);
    
    Optional<Alumno> findByStudentId(String studentId);

}
