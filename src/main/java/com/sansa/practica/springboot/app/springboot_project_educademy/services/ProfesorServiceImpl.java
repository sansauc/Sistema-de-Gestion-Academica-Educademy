package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Profesor;
import com.sansa.practica.springboot.app.springboot_project_educademy.repositories.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    private ProfesorRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Profesor> findAll() {
        return (List<Profesor>) repository.findAll();
    
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Profesor> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Profesor save(Profesor profesor) {
       return repository.save(profesor);
    }
    
    @Override
    @Transactional
    public Optional<Profesor> update(Long id, Profesor profesor) {
        Optional<Profesor> profOptional = repository.findById(id);
        if(profOptional.isPresent()){
            Profesor profDB = profOptional.get();
            profDB.setName(profesor.getName());
            profDB.setLastname(profesor.getLastname());
            profDB.setBirthdate(profesor.getBirthdate());
            profDB.setEmail(profesor.getEmail());
            profDB.setProfesorId(profesor.getProfesorId());
            profDB.setFechaIngreso(profesor.getFechaIngreso());
            return Optional.of(repository.save(profDB));
        }
        return profOptional;
    }

    @Override
    @Transactional
    public Optional<Profesor> delete(Long id) {
        Optional<Profesor> profOptional = repository.findById(id);
        profOptional.ifPresent(profDb -> {
            repository.delete(profDb);
        });
        return profOptional;
    }

    @Override
    public Optional<Profesor> saveIfNotExists(Profesor profesor) {
              // Validar duplicado por dni
        Optional<Profesor> existingByDni = repository.findByDni(profesor.getDni());
        if (existingByDni.isPresent()) {
            return Optional.empty(); // ya existe profesor con ese email
        }
        
        // Validar duplicado por email
        Optional<Profesor> existingByEmail = repository.findByEmail(profesor.getEmail());
        if (existingByEmail.isPresent()) {
            return Optional.empty(); // ya existe prfesor con ese email
        }

        // Validar duplicado por profesorID
        Optional<Profesor> existingByStudentId = repository.findByProfesorId(profesor.getProfesorId());
        if (existingByStudentId.isPresent()) {
            return Optional.empty(); // ya existe profesor con ese ID 
        }

        Profesor saved = repository.save(profesor);
        return Optional.of(saved);
    }

}
