package com.sansa.practica.springboot.app.springboot_project_educademy.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Alumno;

public interface AlumnoRepository extends CrudRepository <Alumno, Long> {

}
