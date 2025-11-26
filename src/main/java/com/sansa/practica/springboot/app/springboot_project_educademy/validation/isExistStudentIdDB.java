package com.sansa.practica.springboot.app.springboot_project_educademy.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = isExistStudentIdDBValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface isExistStudentIdDB {
    String message() default "Ya existe un alumno con este StudentId";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
