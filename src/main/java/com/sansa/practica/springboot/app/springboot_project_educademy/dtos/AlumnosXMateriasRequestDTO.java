package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

import java.util.HashSet;
import java.util.Set;


//Se utiliza para crear la cursada del alumno
//Se crea sin la nota
public class AlumnosXMateriasRequestDTO {

    private Long id;
    private Long alumnoId;
    private Long materiaId;
    private int anioCursado;
    private String estado;
    private Double notaFinal;
    private Set<Long> profesoresIds = new HashSet<>();

    public AlumnosXMateriasRequestDTO() {
    }

    public AlumnosXMateriasRequestDTO(Long id, Long alumnoId, Long materiaId, int anioCursado,
            String estado, Set<Long> profesoresIds) {
        this.id = id;
        this.alumnoId = alumnoId;
        this.materiaId = materiaId;
        this.anioCursado = anioCursado;
        this.estado = estado;
        this.profesoresIds = profesoresIds;
    }

    // Getters && Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlumnoId() {
        return alumnoId;
    }

    public void getAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void getMateriaId(Long materiaId) {
        this.materiaId = materiaId;
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
        this.setEstado(notaFinal >= 4 ? "APROBADO" : "DESAPROBADO");
    }

    public Set<Long> getProfesoresId() {
        return profesoresIds;
    }

    public void getProfesoresId(Set<Long> profesores) {
        this.profesoresIds = profesores;
    }

}
