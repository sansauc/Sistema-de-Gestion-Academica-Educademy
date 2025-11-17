package com.sansa.practica.springboot.app.springboot_project_educademy.entities;

import java.util.Date;

public class EmpleadoAdministrativo extends Persona{

    private String role;
    private Date fechaAlta;
    
    public EmpleadoAdministrativo(){}

    public EmpleadoAdministrativo(String role, Date fechaAlta) {
        this.role = role;
        this.fechaAlta = fechaAlta;
    }

    public EmpleadoAdministrativo(Long dni, String name, String lastname, String email, Date birthdate, String role,
            Date fechaAlta) {
        super(dni, name, lastname, email, birthdate);
        this.role = role;
        this.fechaAlta = fechaAlta;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

}
