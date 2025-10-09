package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Alumno;
import com.sansa.practica.springboot.app.springboot_project_educademy.repositories.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Alumno> findAll() {
        return (List<Alumno>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Alumno> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Alumno save(Alumno alumno) {
        return repository.save(alumno);
    }

    @Override
    @Transactional
    public Optional<Alumno> delete(Long id) {
        Optional<Alumno> alumOptional = repository.findById(id);
        alumOptional.ifPresent(alumDb -> {
            repository.delete(alumDb);
        });
        return alumOptional; // el metodo podria ser void, pero para saber si se borro devolvemos esto,
                             // status 404 (si se borro) o 201 (si salio bien)
    }
   
    @Override
    @Transactional
    public Optional<Alumno> update(Long id, Alumno alumno) {
        Optional<Alumno> alumOptional = repository.findById(id);
        if (alumOptional.isPresent()){
            Alumno alumDb = alumOptional.orElseThrow();
            alumDb.setName(alumno.getName());
            alumDb.setLastname(alumno.getLastname());
            alumDb.setBirthdate(alumno.getBirthdate());
            alumDb.setEmail(alumno.getEmail());
            alumDb.setStudentId(alumno.getStudentId());
            alumDb.setFechaInscripcion(alumno.getFechaInscripcion());
            return Optional.of(repository.save(alumDb));
        }
        return alumOptional;
    }

}
