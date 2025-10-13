package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

public class MateriaInfoDTO {
    
    private Long idMateria;
    private String nombre;

    public MateriaInfoDTO(Long idMateria, String nombre) {
        this.idMateria = idMateria;
        this.nombre = nombre;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public String getNombre() {
        return nombre;
    }
}
