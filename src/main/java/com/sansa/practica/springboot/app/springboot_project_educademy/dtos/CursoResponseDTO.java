package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

public class CursoResponseDTO {

    private Long idCurso;
    private int nroCurso;
    private String divisionCurso;

    public CursoResponseDTO() {}

    public CursoResponseDTO(Long idCurso, int nroCurso, String divisionCurso) {
        this.idCurso = idCurso;
        this.nroCurso = nroCurso;
        this.divisionCurso = divisionCurso;
    }

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

}
