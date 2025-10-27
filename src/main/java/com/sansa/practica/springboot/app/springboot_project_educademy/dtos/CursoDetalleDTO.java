package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;

public class CursoDetalleDTO {
    private Long idCurso;
    private int nroCurso;
    private String divisionCurso;
    private List<MateriaInfoDTO> materias;
   
    public CursoDetalleDTO() {}

    public CursoDetalleDTO(Long idCurso, int nroCurso, String divisionCurso, List<Materia> materias) {
        this.idCurso = idCurso;
        this.nroCurso = nroCurso;
        this.divisionCurso = divisionCurso;
        this.materias = (materias != null) 
            ? materias.stream()
                .map(dto -> new MateriaInfoDTO(dto.getIdMateria(), dto.getNombre()))
                        .collect(Collectors.toList())
                : List.of();
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

    public List<MateriaInfoDTO> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaInfoDTO> materias) {
        this.materias = materias;
    }
    
}
