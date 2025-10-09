package com.sansa.practica.springboot.app.springboot_project_educademy.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor extends Persona {

    private String profesorId;

    private Date fechaIngreso;


    @ManyToMany(mappedBy = "profesores")
    private List<Materia> materiasDictadas;

    public Profesor(String name, String lastname, String email, Date birthdate, String profesorId, Date fechaIngreso) {
        super(name, lastname, email, birthdate);
        this.profesorId = profesorId;
        this.fechaIngreso = fechaIngreso;
    }

    public Profesor(String profesorId, List<Materia> materiasDictadas) {
        this.profesorId = profesorId;
        this.materiasDictadas = materiasDictadas;
    }

    // Getters && Setters
    public String getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(String profesorId) {
        this.profesorId = profesorId;
    }

    public List<Materia> getMateriasDictadas() {
        return materiasDictadas;
    }

    public void setMateriasDictadas(List<Materia> materiasDictadas) {
        this.materiasDictadas = materiasDictadas;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    // Métodos de Clase
    public void agregarMateria(Materia materia) {
        materiasDictadas.add(materia);
        materia.getProfesores().add(this);
    }

    public void quitarMateria(Materia materia) {
        materiasDictadas.remove(materia);
        materia.getProfesores().remove(this);
    }


}
