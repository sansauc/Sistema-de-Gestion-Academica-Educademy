package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Materia;


//Esta clase se usa solo para respuestas que involucren info de un profesor, incluye las materias dictadas
public class ProfesorSimpleInfoDTO {

    private Long id;
    private Long dni;
    private String name;
    private String lastname;
    private String email;
    private Date birthdate;
    private String profesorId;
    private Date fechaIngreso;
    private List<MateriaInfoDTO> materiasDictadas;

    public ProfesorSimpleInfoDTO(Long id, Long dni, String name, String lastname, String email, Date birthdate, String profesorId, Date fechaIngreso, List<Materia> materiasDictadas) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.profesorId = profesorId;
        this.fechaIngreso = fechaIngreso;
        this.materiasDictadas = materiasDictadas.stream()
                .map(dto -> new MateriaInfoDTO(dto.getIdMateria(), dto.getNombre()))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(String profesorId) {
        this.profesorId = profesorId;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<MateriaInfoDTO> getMateriasDictadas() {
        return materiasDictadas;
    }

    public void setMateriasDictadas(List<MateriaInfoDTO> materiasDictadas) {
        this.materiasDictadas = materiasDictadas;
    }

    


}
