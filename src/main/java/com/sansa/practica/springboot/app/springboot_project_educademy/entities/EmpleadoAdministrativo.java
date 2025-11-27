package com.sansa.practica.springboot.app.springboot_project_educademy.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table()
public class EmpleadoAdministrativo extends Persona{

    private Date fechaAlta;
    
    public EmpleadoAdministrativo(){}

    public EmpleadoAdministrativo(String role, Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public EmpleadoAdministrativo(Long dni, String name, String lastname, String email, Date birthdate,
            Date fechaAlta) {
        super(dni, name, lastname, email, birthdate);
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

}
