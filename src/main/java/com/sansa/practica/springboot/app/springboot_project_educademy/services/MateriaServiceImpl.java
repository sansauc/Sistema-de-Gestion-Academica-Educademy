package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Profesor;
import com.sansa.practica.springboot.app.springboot_project_educademy.repositories.MateriaRepository;
import com.sansa.practica.springboot.app.springboot_project_educademy.repositories.ProfesorRepository;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaRepository repository;

    @Autowired
    private ProfesorRepository repository2;

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
    
    @Override
    public Optional<Materia> saveIfNotExists(Materia materia) {
        
        //Valida por el nombre
        Optional<Materia> existingByDni = repository.findByNombre(materia.getNombre());
        if (existingByDni.isPresent()){
            return Optional.empty(); //Ya existe una materia con ese nombre
        }

        Materia saved = repository.save(materia);
        return Optional.of(saved);
    }


    //Para usar estos ultimos 2 metodos el profesor debe existir
    @Override
    @Transactional
    public Optional<Materia> agregarProfesor(Long idMateria, Profesor profesor) {
        Optional<Materia> materOptional = repository.findById(idMateria);
        if(materOptional.isPresent()){
            Materia materiaBd = materOptional.get();

            //Recuperar al profesor
            Optional<Profesor> profOptional = repository2.findByProfesorId(profesor.getProfesorId());
            if(profOptional.isEmpty()){
                return Optional.empty();
            }

            materiaBd.agregarProfesor(profOptional.get());
            return Optional.of(repository.save(materiaBd));
        }
        return materOptional;
    }

    @Override
    public Optional<Materia> quitarProfesor(Long idMateria, Profesor profesor) {
        Optional<Materia> materOptional = repository.findById(idMateria);
        if(materOptional.isPresent()){
            Materia materiaBd = materOptional.get();

            //Recuperar al profesor
            Optional<Profesor> profOptional = repository2.findByProfesorId(profesor.getProfesorId());
            if(profOptional.isEmpty()){
                return Optional.empty();
            }

            materiaBd.quitarProfesor(profOptional.get());
            return Optional.of(repository.save(materiaBd));
        }
        return materOptional;
    }


}
