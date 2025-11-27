package com.sansa.practica.springboot.app.springboot_project_educademy.validation.Alumno;

import org.springframework.beans.factory.annotation.Autowired;

import com.sansa.practica.springboot.app.springboot_project_educademy.services.AlumnoService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class isExistEmailDBValidation implements ConstraintValidator<isExistEmailDB, String>{

    @Autowired
    private AlumnoService service;
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !service.existsByEmail(value);
    }

}
