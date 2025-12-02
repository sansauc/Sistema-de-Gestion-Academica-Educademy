package com.sansa.practica.springboot.app.springboot_project_educademy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.User;
import com.sansa.practica.springboot.app.springboot_project_educademy.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

}
