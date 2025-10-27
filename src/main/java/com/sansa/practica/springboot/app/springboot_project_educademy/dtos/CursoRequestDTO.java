package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

public class CursoRequestDTO {
    
    private int nroCurso;
    private String divisionCurso;

    public CursoRequestDTO(){}

    public CursoRequestDTO(int nroCurso, String divisionCurso) {
        this.nroCurso = nroCurso;
        this.divisionCurso = divisionCurso;
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
