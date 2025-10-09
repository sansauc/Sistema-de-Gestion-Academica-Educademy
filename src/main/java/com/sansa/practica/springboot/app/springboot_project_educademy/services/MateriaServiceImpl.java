package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;
import com.sansa.practica.springboot.app.springboot_project_educademy.repositories.MateriaRepository;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Materia> findAll() {
        return (List<Materia>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Materia> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Materia save(Materia materia) {
        return repository.save(materia);
    }

    @Override
    @Transactional
    public Optional<Materia> delete(Long id) {
        Optional<Materia> materiaOptional = repository.findById(id);
        materiaOptional.ifPresent(materiaDb -> {
            repository.delete(materiaDb);
        });
        return materiaOptional;
    }

}
