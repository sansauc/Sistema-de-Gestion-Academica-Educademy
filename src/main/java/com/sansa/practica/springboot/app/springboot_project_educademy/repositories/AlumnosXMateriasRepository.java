package com.sansa.practica.springboot.app.springboot_project_educademy.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.AlumnosXMaterias;

public interface AlumnosXMateriasRepository extends CrudRepository<AlumnosXMaterias, Long> {

    // Método para validar duplicados
    Optional<AlumnosXMaterias> findByAlumnoIdAndMateriaIdAndAnioCursado(Long alumnoId, Long materiaId, int anioCursado);

    // Métodos adicionales útiles
    List<AlumnosXMaterias> findByAlumnoId(Long id);

    List<AlumnosXMaterias> findByMateriaId(Long idMateria);

    List<AlumnosXMaterias> findByAnioCursado(int anioCursado);

}
