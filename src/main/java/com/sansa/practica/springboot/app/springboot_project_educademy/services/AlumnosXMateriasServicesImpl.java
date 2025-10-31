package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.AlumnosXMaterias;
import com.sansa.practica.springboot.app.springboot_project_educademy.repositories.AlumnosXMateriasRepository;

@Service
public class AlumnosXMateriasServicesImpl implements AlumnosXMateriasServices {

    @Autowired
    private AlumnosXMateriasRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<AlumnosXMaterias> findAll() {
        return (List<AlumnosXMaterias>) repository.findAll();
    }

    @Override
    public Optional<AlumnosXMaterias> findById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public AlumnosXMaterias save(AlumnosXMaterias alumnosXMaterias) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
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

}
