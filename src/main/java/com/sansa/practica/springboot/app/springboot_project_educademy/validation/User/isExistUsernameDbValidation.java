package com.sansa.practica.springboot.app.springboot_project_educademy.validation.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sansa.practica.springboot.app.springboot_project_educademy.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class isExistUsernameDbValidation implements ConstraintValidator<isExistUsernameDb, String>{

    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !service.existsByUsername(value);
    }

}
