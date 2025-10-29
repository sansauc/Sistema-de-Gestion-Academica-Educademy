package com.sansa.practica.springboot.app.springboot_project_educademy.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "alumnos_x_materias", 
       uniqueConstraints = @UniqueConstraint(
        columnNames = {"alumno_id","materia_id","anio_cursado"}))
       
public class AlumnosXMaterias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    @Column(name = "anio_cursado")
    private int anioCursado;

    private String estado = "Cursando";

    private Double notaFinal;

    // Profesores que dictaron esa materia en ese año específico
    @JsonIgnoreProperties({ "alumnosMateriasDictadas", "handler", "hibernateLazyInitializer" })
    @ManyToMany
    @JoinTable(name = "alumnos_x_materias_profesores", joinColumns = @JoinColumn(name = "alumno_materia_id"), inverseJoinColumns = @JoinColumn(name = "profesor_id"))
    private Set<Profesor> profesores = new HashSet<>();

    public AlumnosXMaterias() {
    }

    public AlumnosXMaterias(Long id, Alumno alumno, Materia materia, int anioCursado, String estado) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.anioCursado = anioCursado;
        this.estado = estado;
    }

    // Getters && Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getAnioCursado() {
        return anioCursado;
    }

    public void setAnioCursado(int anioCursado) {
        this.anioCursado = anioCursado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    // ===== Métodos de clase =====
    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    public void quitarProfesor(Profesor profesor) {
        profesores.remove(profesor);
    }

}
