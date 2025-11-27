package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

import java.util.Date;

import com.sansa.practica.springboot.app.springboot_project_educademy.validation.Profesor.isExistDniDB;
import com.sansa.practica.springboot.app.springboot_project_educademy.validation.Profesor.isExistEmailDb;
import com.sansa.practica.springboot.app.springboot_project_educademy.validation.Profesor.isExistProfesorIdDb;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProfesorRequestDTO {

    // Atributos heredados de Persona
    @Min(500)
    @NotNull
    @isExistDniDB
    private Long dni;

    @NotEmpty(message = "El nombre no debe estar vacio!") // Este se usa para validar String vacios
    @Size(min = 3, max = 20)
    private String name;

    @NotEmpty(message = "El apellido no debe estar vacio!") // Este se usa para validar String vacios
    @Size(min = 3, max = 20)
    private String lastname;

    @NotEmpty
    @Email(message = "Formato de email inválido") // Tambien se podria utilizar: @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+$") Esto te permite utilizar emails internos del tipo: usuario@local
    @isExistEmailDb
    private String email;

    @NotNull //Para fechas
    private Date birthdate;

    // Atributos específicos del profesor
    @NotBlank(message = "El profesorID no debe estar vacio")
    @isExistProfesorIdDb
    private String profesorID;

    @NotNull
    private Date fechaIngreso;

    public ProfesorRequestDTO() {
    }

    public ProfesorRequestDTO(Long dni, String name, String lastname, String email, Date birthdate,
            String profesorID, Date fechaIngreso) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.profesorID = profesorID;
        this.fechaIngreso = fechaIngreso;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(String profesorID) {
        this.profesorID = profesorID;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

}
