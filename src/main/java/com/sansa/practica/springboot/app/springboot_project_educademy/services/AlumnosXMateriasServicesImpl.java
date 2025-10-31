package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Alumno;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.AlumnosXMaterias;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;
import com.sansa.practica.springboot.app.springboot_project_educademy.repositories.AlumnoRepository;
import com.sansa.practica.springboot.app.springboot_project_educademy.repositories.AlumnosXMateriasRepository;
import com.sansa.practica.springboot.app.springboot_project_educademy.repositories.MateriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlumnosXMateriasServicesImpl implements AlumnosXMateriasServices {

    @Autowired
    private AlumnosXMateriasRepository repository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    MateriaRepository materiaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<AlumnosXMaterias> findAll() {
        return (List<AlumnosXMaterias>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<AlumnosXMaterias> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public AlumnosXMaterias save(AlumnosXMaterias alumnosXMaterias) {
        return repository.save(alumnosXMaterias);
    }

    @Override
    public Optional<AlumnosXMaterias> update(Long id, AlumnosXMaterias alumnosXMaterias) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<AlumnosXMaterias> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<AlumnosXMaterias> saveIfNotExists(AlumnosXMaterias alumnosXMaterias) {
        try {
            // Validaciones de existencia de entidades relacionadas

            if (alumnosXMaterias.getAlumno() == null || alumnosXMaterias.getAlumno().getId() == null) {
                throw new IllegalArgumentException("El alumno es requerido");
            }

            if (alumnosXMaterias.getMateria() == null || alumnosXMaterias.getMateria().getIdMateria() == null) {
                throw new IllegalArgumentException("La materia es requerida");
            }

            // Verificar que las entidades relacionadas existen en la base de datos
            Alumno alumno = alumnoRepository.findById(alumnosXMaterias.getAlumno().getId())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Alumno no encontrado con ID: " + alumnosXMaterias.getAlumno().getId()));

            Materia materia = materiaRepository.findById(alumnosXMaterias.getMateria().getIdMateria())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Materia no encontrada con ID: " + alumnosXMaterias.getMateria().getIdMateria()));

            // Validar duplicado
            Optional<AlumnosXMaterias> existingRelation = repository.findByAlumnoIdAndMateriaIdAndAnioCursado(
                    alumno.getId(),
                    materia.getIdMateria(),
                    alumnosXMaterias.getAnioCursado());

            if (existingRelation.isPresent()) {
                return Optional.empty(); // Relación duplicada
            }

            if (alumnosXMaterias.getEstado() == null) {
                alumnosXMaterias.setEstado("Cursando");
            }

            AlumnosXMaterias saved = repository.save(alumnosXMaterias);
            return Optional.of(saved);

        } catch (Exception e) {
            System.out.println("Error al guardar AlumnosXMaterias: " + e.getMessage());
            throw e;
        }
    }

}
