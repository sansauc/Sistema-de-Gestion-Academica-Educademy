package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

import java.util.Date;

import com.sansa.practica.springboot.app.springboot_project_educademy.validation.Alumno.isExistDniDb;
import com.sansa.practica.springboot.app.springboot_project_educademy.validation.Alumno.isExistEmailDB;
import com.sansa.practica.springboot.app.springboot_project_educademy.validation.Alumno.isExistStudentIdDB;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//Esta clase se usa para crear y actualizar alumnos
public class AlumnoRequestDTO {

    //Atributos de la persona
    @Min(500)
    @NotNull
    @isExistDniDb
    private Long dni;
    
    @NotEmpty(message = "{NotEmpty.AlumnoRequestDTO.name}") //Este se usa para validar String vacios
    @Size(min = 3, max = 20)
    private String name;
    
    @NotEmpty
    @Size(min = 3, max = 20)
    private String lastname;
    
    @NotEmpty
    @Email(message = "Formato de email inválido") //Tambien se podria utilizar: @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+$") Esto te permite utilizar emails internos del tipo: usuario@local
    @isExistEmailDB
    private String email;
    
    @NotNull //Para fechas
    private Date birthdate;

    //Atributos propios del alumno
    @NotBlank(message = "{NotBlank.AlumnoRequestDTO.studentId}")
    @isExistStudentIdDB
    private String studentId;

    @NotNull
    private Date fechaInscripcion;

    
    public AlumnoRequestDTO() {}

    public AlumnoRequestDTO(Long dni, String name, String lastname, String email, Date birthdate, String studentId,
            Date fechaInscripcion) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.studentId = studentId;
        this.fechaInscripcion = fechaInscripcion;
    }

    //Getters && Setters

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

}
