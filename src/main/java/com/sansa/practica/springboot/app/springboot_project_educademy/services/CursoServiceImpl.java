package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Curso;
import com.sansa.practica.springboot.app.springboot_project_educademy.repositories.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Curso> findAll() {
        return (List<Curso>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Curso> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return repository.save(curso);    
    }

    @Override
    @Transactional
    public Optional<Curso> delete(Long id) {
        Optional<Curso> cursoOptional = repository.findById(id);
        cursoOptional.ifPresent(cursoDb -> {
            repository.delete(cursoDb);
        });
        return cursoOptional;
    }


}
