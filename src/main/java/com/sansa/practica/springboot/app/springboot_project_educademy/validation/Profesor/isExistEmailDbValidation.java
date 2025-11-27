package com.sansa.practica.springboot.app.springboot_project_educademy.validation.Profesor;

import org.springframework.beans.factory.annotation.Autowired;

import com.sansa.practica.springboot.app.springboot_project_educademy.services.ProfesorService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class isExistEmailDbValidation implements ConstraintValidator<isExistEmailDb, String>  {

    @Autowired
    private ProfesorService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !service.existsByEmail(value);    
    }



}
