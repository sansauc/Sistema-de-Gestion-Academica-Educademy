package com.sansa.practica.springboot.app.springboot_project_educademy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig {

    @Bean //Para poder injectar lo que devuelve el método 
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
