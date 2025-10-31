package com.sansa.practica.springboot.app.springboot_project_educademy.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.AlumnosXMateriasDetalleDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.dtos.AlumnosXMateriasResponseDTO;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.AlumnosXMaterias;
import com.sansa.practica.springboot.app.springboot_project_educademy.services.AlumnosXMateriasServices;

@RestController
@RequestMapping("/api/cursada")
public class AlumnosXMateriasController {

    @Autowired
    private AlumnosXMateriasServices service;

    @GetMapping
    public List<AlumnosXMateriasResponseDTO> list(){
        return service.findAll()
            .stream()
            .map(this::convertTAlumnosXMateriasResponseDTO)
            .collect(Collectors.toList());
    }


    //Métodos de Conversión

    private AlumnosXMaterias convertToEntity(AlumnosXMaterias axm){

        AlumnosXMaterias alumnoXMateria = new AlumnosXMaterias();

        alumnoXMateria.setId(axm.getId());
        alumnoXMateria.setAlumno(axm.getAlumno());
        alumnoXMateria.setMateria(axm.getMateria());
        alumnoXMateria.setAnioCursado(axm.getAnioCursado());
        alumnoXMateria.setProfesores(axm.getProfesores());
        alumnoXMateria.setEstado("Cursando");

        return alumnoXMateria;

    }

    private AlumnosXMateriasDetalleDTO convertToAlumnosXMateriasDetalleDTO(AlumnosXMaterias axm){
        return new AlumnosXMateriasDetalleDTO(
            axm.getId(),
            axm.getAlumno(),
            axm.getMateria(),
            axm.getAnioCursado(),
            axm.getEstado(),
            axm.getNotaFinal(),
            axm.getProfesores());
    }

    private AlumnosXMateriasResponseDTO convertTAlumnosXMateriasResponseDTO(AlumnosXMaterias axm){
        return new AlumnosXMateriasResponseDTO(
            axm.getId(),
            axm.getAlumno().getId(),
            axm.getAlumno().getName() + " " + axm.getAlumno().getLastname(),
            axm.getMateria().getIdMateria(),
            axm.getMateria().getNombre(),
            axm.getAnioCursado(),
            axm.getEstado(),
            axm.getNotaFinal());
    }
}
