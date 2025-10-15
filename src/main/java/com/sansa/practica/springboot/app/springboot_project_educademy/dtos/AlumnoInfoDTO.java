package com.sansa.practica.springboot.app.springboot_project_educademy.dtos;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.AlumnosXMaterias;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Curso;

public class AlumnoInfoDTO {
    // Atributos heredados de Persona
    private Long id;
    private long dni;
    private String name;

    private String lastname;
    private String email;
    private Date birthdate;

    // Atributos específicos de Alumno
    private String studentId;
    private Date fechaInscripcion;
    private CursoInfoDto cursoActual;
    private List<MateriaInfoDTO> materiasCursadas;

    public AlumnoInfoDTO(Long id, Long dni, String name, String lastname, String email, java.util.Date birthdate,
            String studentId,
            java.util.Date fechaInscripcion, Curso cursoActual, List<AlumnosXMaterias> materiasCursadas) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.birthdate = birthdate;
        this.studentId = studentId;
        this.fechaInscripcion = fechaInscripcion;
        this.cursoActual = this.convertirACursoInfoDto(cursoActual);
        this.materiasCursadas = materiasCursadas.stream()
                .map(dto -> new MateriaInfoDTO(dto.getMateria().getIdMateria(), dto.getMateria().getNombre()))
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public CursoInfoDto getCursoActual() {
        return cursoActual;
    }

    public void setCursoActual(CursoInfoDto cursoActual) {
        this.cursoActual = cursoActual;
    }

    public List<MateriaInfoDTO> getMateriasCursadas() {
        return materiasCursadas;
    }

    public void setMateriasCursadas(List<MateriaInfoDTO> materiasCursadas) {
        this.materiasCursadas = materiasCursadas;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    private CursoInfoDto convertirACursoInfoDto(Curso curso) {
        if (curso == null) {
            return null;
        }
        CursoInfoDto dto = new CursoInfoDto();
        dto.setNroCurso(curso.getNroCurso());
        dto.setDivisionCurso(curso.getDivisionCurso());
        return dto;
    }

}
