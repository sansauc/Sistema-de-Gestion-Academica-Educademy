package com.sansa.practica.springboot.app.springboot_project_educademy.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumnos_x_materias")
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

    private int anioCursado;

    private String estado = "Cursando";

    private Double notaFinal;


    public AlumnosXMaterias() {
    }


    public AlumnosXMaterias(Long id, Alumno alumno, Materia materia, int anioCursado, String estado) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.anioCursado = anioCursado;
        this.estado = estado;
    }

    //Getters && Setters

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
    

}
