package com.sansa.practica.springboot.app.springboot_project_educademy.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.Role;
import java.util.List;


public interface RoleRepository extends CrudRepository<Role, Long>{

    Optional<Role> findByName(String username);
}
