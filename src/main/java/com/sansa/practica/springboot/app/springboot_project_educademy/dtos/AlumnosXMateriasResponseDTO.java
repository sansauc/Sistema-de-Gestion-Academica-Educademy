package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

//Devuelve información simple del cursado de los alumnos
public class AlumnosXMateriasResponseDTO {

    private Long id;
    private Long alumnoId;
    private String alumnoNombre;
    private Long materiaId;
    private String materiaNombre;
    private int anioCursado;
    private String estado;
    private Double notaFinal;

    public AlumnosXMateriasResponseDTO() {
    }

    public AlumnosXMateriasResponseDTO(Long id, Long alumnoId, String alumnoNombre, Long materiaId,
            String materiaNombre, int anioCursado, String estado, Double notaFinal) {

        this.id = id;
        this.alumnoId = alumnoId;
        this.alumnoNombre = alumnoNombre;
        this.materiaId = materiaId;
        this.materiaNombre = materiaNombre;
        this.anioCursado = anioCursado;
        this.estado = estado;
        this.notaFinal = notaFinal;
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

    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }

    public String getAlumnoNombre() {
        return alumnoNombre;
    }

    public void setAlumnoNombre(String alumnoNombre) {
        this.alumnoNombre = alumnoNombre;
    }

    public Long getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }

    public String getMateriaNombre() {
        return materiaNombre;
    }

    public void setMateriaNombre(String materiaNombre) {
        this.materiaNombre = materiaNombre;
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

    

}
