package com.sansa.practica.springboot.app.springboot_project_educademy.validation.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sansa.practica.springboot.app.springboot_project_educademy.services.AlumnoService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class isExistStudentIdDBValidation implements ConstraintValidator<isExistStudentIdDB, String>{

    @Autowired
    private AlumnoService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !service.existsByStudentId(value);
    }



}
