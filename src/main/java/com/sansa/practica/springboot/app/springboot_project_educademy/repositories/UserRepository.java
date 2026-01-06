package com.sansa.practica.springboot.app.springboot_project_educademy.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.User;


public interface UserRepository extends CrudRepository <User, Long> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

}
