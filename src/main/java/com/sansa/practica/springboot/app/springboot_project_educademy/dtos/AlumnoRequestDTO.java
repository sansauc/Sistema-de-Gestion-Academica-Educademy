package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

import java.util.Date;

//Esta clase se usa para crear y actualizar alumnos
public class AlumnoRequestDTO {

    //Atributos de la persona
    private String name;
    private String lastname;
    private String email;
    private Date birthdate;

    //Atributos propios del alumno
    private String studentId;
    private Date fechaInscripcion;

    
    public AlumnoRequestDTO() {}

    public AlumnoRequestDTO(String name, String lastname, String email, Date birthdate, String studentId,
            Date fechaInscripcion) {
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

}
