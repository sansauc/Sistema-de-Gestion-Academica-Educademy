package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

import java.util.Date;

public class ProfesorResponseDTO {
    // Atributos heredados de Persona
    private Long id;
    private Long dni;
    private String name;
    private String lastname;
    private String email;
    private Date birthdate;

    // Atributos específicos del profesor
    private String profesorID;
    private Date fechaIngreso;
    
    public ProfesorResponseDTO() {
    }

    public ProfesorResponseDTO(Long id, Long dni, String name, String lastname, String email, Date birthdate,
            String profesorID, Date fechaIngreso) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.profesorID = profesorID;
        this.fechaIngreso = fechaIngreso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
