package com.sansa.practica.springboot.app.springboot_project_educademy.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @JsonIgnoreProperties({"materias", "handler", "hibernateLazyInitializer"})//Con esto se soluciona la recursión infinita en el JSON
    @ManyToMany
    @JoinTable(name = "materia_curso", joinColumns = @JoinColumn(name = "materia_id"), inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private Set<Curso> cursos; // Para saber a que curso pertenece la materia

    @JsonIgnoreProperties({"materiasDictadas", "handler", "hibernateLazyInitializer"})//Con esto se soluciona la recursión infinita en el JSON
    @ManyToMany
    @JoinTable(name = "materia_profesor", joinColumns = @JoinColumn(name = "materia_id"), inverseJoinColumns = @JoinColumn(name = "profesor_id"))
    private Set<Profesor> profesores; //Si usamos List, estamos obligados a controlar que el profesor no se haya guardado con anterioridad, usando set nos olvidamos

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

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
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

    public void quitarCurso(Curso curso) {
        this.cursos.remove(curso);
        curso.getMaterias().remove(this);
    }

}
