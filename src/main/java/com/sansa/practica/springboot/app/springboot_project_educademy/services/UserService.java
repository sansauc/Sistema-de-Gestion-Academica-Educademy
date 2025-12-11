package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean isExistUsernameDb(String username);

}
