package com.sansa.practica.springboot.app.springboot_project_educademy.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    private int nroCurso;
    private String divisionCurso;

    @JsonIgnoreProperties({ "cursos", "handler", "hibernateLazyInitializer" })
    @ManyToMany(mappedBy = "cursos")
    private List<Materia> materias = new ArrayList<>();

    public Curso() {
    }

    public Curso(Long idCurso, int nroCurso, String divisionCurso) {
        this.idCurso = idCurso;
        this.nroCurso = nroCurso;
        this.divisionCurso = divisionCurso;
    }

    // Getters && Setters

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public int getNroCurso() {
        return nroCurso;
    }

    public void setNroCurso(int nroCurso) {
        this.nroCurso = nroCurso;
    }

    public String getDivisionCurso() {
        return divisionCurso;
    }

    public void setDivisionCurso(String divisionCurso) {
        this.divisionCurso = divisionCurso;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    // Metodos de Clase

    public void agregarMateria(Materia materia) {
        this.materias.add(materia);
        materia.getCursos().add(this);
    }

}
