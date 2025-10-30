package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Profesor;

//Devuelve información detallada de la cursada del alumno
public class AlumnosXMateriasDetalleDTO {

    private Long id;
    private AlumnoResponseDTO alumno;
    private MateriaInfoDTO materia;
    private int anioCursado;
    private String estado;
    private Double notaFinal;
    private Set<ProfesorResponseDTO> profesores = new HashSet<>();

    public AlumnosXMateriasDetalleDTO() {
    }

    public AlumnosXMateriasDetalleDTO(Long id, AlumnoResponseDTO alumno, MateriaInfoDTO materia, int anioCursado,
            String estado, Double notaFinal, Set<Profesor> profesores) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.anioCursado = anioCursado;
        this.estado = estado;
        this.notaFinal = notaFinal;
        this.profesores = (Set<ProfesorResponseDTO>) profesores.stream()
                .map(p -> new ProfesorResponseDTO(
                        p.getId(),
                        p.getDni(),
                        p.getName(),
                        p.getLastname(),
                        p.getEmail(),
                        p.getBirthdate(),
                        p.getProfesorId(),
                        p.getFechaIngreso()))
                .collect(Collectors.toList());
        ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlumnoResponseDTO getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoResponseDTO alumno) {
        this.alumno = alumno;
    }

    public MateriaInfoDTO getMateria() {
        return materia;
    }

    public void setMateria(MateriaInfoDTO materia) {
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

    public Set<ProfesorResponseDTO> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<ProfesorResponseDTO> profesores) {
        this.profesores = profesores;
    }

    

}
