package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

//Se usa para crear la entindad AlumnosXmaterias, es decir, modelar el cursado del alumno
public class AgregarCursadaDTO {

    private Long alumnoId;
    private Long materiaId;
    private int anioCursado;


    public AgregarCursadaDTO() {
    }


    public AgregarCursadaDTO(Long alumnoId, Long materiaId, int anioCursado) {
        this.alumnoId = alumnoId;
        this.materiaId = materiaId;
        this.anioCursado = anioCursado;
    }


    public Long getAlumnoId() {
        return alumnoId;
    }


    public void setAlumnoId(Long alumnoId) {
        this.alumnoId = alumnoId;
    }


    public Long getMateriaId() {
        return materiaId;
    }


    public void setMateriaId(Long materiaId) {
        this.materiaId = materiaId;
    }


    public int getAnioCursado() {
        return anioCursado;
    }


    public void setAnioCursado(int anioCursado) {
        this.anioCursado = anioCursado;
    }

    


    


    
}
