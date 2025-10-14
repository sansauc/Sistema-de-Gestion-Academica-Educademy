package com.sansa.practica.springboot.app.springboot_project_educademy.entities;

import java.util.Date;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno extends Persona {

    private String studentId;
    
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlumnosXMaterias> materiasCursadas;
    
    private Date fechaInscripcion;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso cursoActual;

    public Alumno() {
    }

    public Alumno(Long dni, String name, String lastname, String email, Date birthdate, String studentId, Date fechaInscripcion) {
        super(dni, name, lastname, email, birthdate);
        this.studentId = studentId;
        this.fechaInscripcion = fechaInscripcion;
    }

    // Getters && Setters

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

    public List<AlumnosXMaterias> getMateriasCursadas() {
        return materiasCursadas;
    }

    public void setMateriasCursadas(List<AlumnosXMaterias> materiasCursadas) {
        this.materiasCursadas = materiasCursadas;
    }

    public Curso getCursoActual() {
        return cursoActual;
    }

    public void setCursoActual(Curso cursoActual) {
        this.cursoActual = cursoActual;
    }
   

    // Métodos de clase

    public void agregarMateriaCursada(AlumnosXMaterias materia) {
        this.materiasCursadas.add(materia);
    }

    public void bajaMateriaCursada(AlumnosXMaterias materia) {
        this.materiasCursadas.remove(materia);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
        result = prime * result + ((fechaInscripcion == null) ? 0 : fechaInscripcion.hashCode());
        result = prime * result + ((cursoActual == null) ? 0 : cursoActual.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alumno other = (Alumno) obj;
        if (studentId == null) {
            if (other.studentId != null)
                return false;
        } else if (!studentId.equals(other.studentId))
            return false;
        if (fechaInscripcion == null) {
            if (other.fechaInscripcion != null)
                return false;
        } else if (!fechaInscripcion.equals(other.fechaInscripcion))
            return false;
        if (cursoActual == null) {
            if (other.cursoActual != null)
                return false;
        } else if (!cursoActual.equals(other.cursoActual))
            return false;
        return true;
    }
    
}
