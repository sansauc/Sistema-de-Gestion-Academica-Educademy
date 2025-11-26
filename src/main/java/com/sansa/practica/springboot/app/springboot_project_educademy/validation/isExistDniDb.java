package com.sansa.practica.springboot.app.springboot_project_educademy.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = isExistDniDbValidation.class) //la clase validadora
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface isExistDniDb {
    String message() default "Ya existe un alumno con este DNI";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
