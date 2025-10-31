package com.sansa.practica.springboot.app.springboot_project_educademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sansa.practica.springboot.app.springboot_project_educademy.services.AlumnosXMateriasServices;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnosXMateriasController {

    @Autowired
    private AlumnosXMateriasServices service;

   // public List <AlumnoResponseDTO> 
}
