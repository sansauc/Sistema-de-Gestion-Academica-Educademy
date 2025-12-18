package com.sansa.practica.springboot.app.springboot_project_educademy.security.filter;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sansa.practica.springboot.app.springboot_project_educademy.entities.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

                User user = null;
                String username = null;
                String password = null;

                try {
                    user = new ObjectMapper().readValue(request.getInputStream(), User.class); //Capturamos el json y lo hacemos tipo User (de nuestro package entities)
                    username=user.getUsername();
                    password = user.getPassword();
                } catch (StreamReadException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (DatabindException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

                return authenticationManager.authenticate(authenticationToken);
    }

    
    
}
