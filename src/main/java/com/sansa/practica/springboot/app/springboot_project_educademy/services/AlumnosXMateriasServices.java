package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.AlumnosXMaterias;

public interface AlumnosXMateriasServices {

    List<AlumnosXMaterias> findAll();

    Optional<AlumnosXMaterias> findById();

    AlumnosXMaterias save(AlumnosXMaterias alumnosXMaterias);

    Optional<AlumnosXMaterias> update(Long id, AlumnosXMaterias alumnosXMaterias);
    
    Optional<AlumnosXMaterias>  delete(Long id);
    
    
}
