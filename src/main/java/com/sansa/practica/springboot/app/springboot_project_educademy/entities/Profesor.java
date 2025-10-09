package com.sansa.practica.springboot.app.springboot_project_educademy.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor extends Persona {

    private String studentId;

    @ManyToMany(mappedBy = "profesores")
    private List<Materia> materiasDictadas;

    public Profesor(String name, String lastname, String email, Date birthdate, String studentId) {
        super(name, lastname, email, birthdate);
        this.studentId = studentId;
    }

    public Profesor(String studentId, List<Materia> materiasDictadas) {
        this.studentId = studentId;
        this.materiasDictadas = materiasDictadas;
    }

    // Getters && Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<Materia> getMateriasDictadas() {
        return materiasDictadas;
    }

    public void setMateriasDictadas(List<Materia> materiasDictadas) {
        this.materiasDictadas = materiasDictadas;
    }

    // Métodos de Clase
    public void agregarMateria(Materia materia) {
        materiasDictadas.add(materia);
        materia.getProfesores().add(this);
    }

}
