package com.sansa.practica.springboot.app.springboot_project_educademy.validation.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sansa.practica.springboot.app.springboot_project_educademy.services.AlumnoService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class isExistDniDbValidation implements ConstraintValidator<isExistDniDb, Long> {

    @Autowired
    private AlumnoService service;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return !service.existsByDni(value);
        // Retorna true si la validación pasa (el alumno NO existe)
        // Retorna false si la validación falla (el alumno SÍ existe)
    }

}
