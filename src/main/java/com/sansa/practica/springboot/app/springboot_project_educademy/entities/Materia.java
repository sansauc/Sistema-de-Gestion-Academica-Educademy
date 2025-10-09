package com.sansa.practica.springboot.app.springboot_project_educademy.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMateria;
    private String nombre;

    @ManyToMany
    @JoinTable(name = "materia_curso", joinColumns = @JoinColumn(name = "materia_id"), inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos = new ArrayList<>();; // Para saber a que curso pertenece la materia

    @ManyToMany
    @JoinTable(name = "materia_profesor", joinColumns = @JoinColumn(name = "materia_id"), inverseJoinColumns = @JoinColumn(name = "profesor_id"))
    private List<Profesor> profesores = new ArrayList<>();

    public Materia() {
    }

    public Materia(Long idMateria, String nombre) {
        this.idMateria = idMateria;
        this.nombre = nombre;
    }

    // Getters && Setters

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    // Metodos de clase

    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
        profesor.getMateriasDictadas().add(this);
    }

    public void quitarProfesor(Profesor profesor) {
        profesores.remove(profesor);
        profesor.getMateriasDictadas().remove(this);
    }

    public void agregarCurso(Curso curso) {
        this.cursos.add(curso);
        curso.getMaterias().add(this);
    }

}
