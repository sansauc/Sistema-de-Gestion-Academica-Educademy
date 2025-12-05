package com.sansa.practica.springboot.app.springboot_project_educademy.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sansa.practica.springboot.app.springboot_project_educademy.entities.User;
import com.sansa.practica.springboot.app.springboot_project_educademy.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> list() {
        return service.findAll();
    }

    //Este metodo se va a utilizar para crear todo tipo de usuarios
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result) {
        user.setAdmin(false);
        return this.create(user, result);
    }

    //Este metodo se utiliza solo para crear admins
    @PostMapping
    private ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }


    // ------ Validacion -------
    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>(); // map<nombre del atributo, mensaje de error>

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo: " + err.getField() + " " + err.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

}
