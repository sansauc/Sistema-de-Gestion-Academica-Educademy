package com.sansa.practica.springboot.app.springboot_project_educademy.security.filter;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.sansa.practica.springboot.app.springboot_project_educademy.security.TokenJWTConfig.*;

//Este filtro se utiliza para authenticar y validar el token
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

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
     
                User user = (User)authResult.getPrincipal();
                String username = user.getUsername();
                Collection <? extends GrantedAuthority> roles = authResult.getAuthorities();
                
                Claims claims = Jwts.claims().build();
                claims.put("authorities", roles);

                String token = Jwts.builder()
                    .subject(username)
                    .claims(claims)
                    .expiration(new Date(System.currentTimeMillis() + 3600000)) //Esto corresponde a la fecha actual + hora, esta en milisegundos
                    .issuedAt(new Date()) //fecha en la que se genera el token
                    .signWith(SECRET_KEY)
                    .compact(); //Esto genera el token

                response.addHeader(HEADER_AUTHORIZATION,PREFIT_TOKEN + token);

                Map<String, String> body = new HashMap<>();
                body.put("token", token);
                body.put("username", username);
                body.put("message", "Hola " + username + " has iniciado sesión con exito");

                response.getWriter().write(new ObjectMapper().writeValueAsString(body)); //generamos el json 
                response.setContentType(CONTENT_TYPE);
                response.setStatus(200);

        
    }
//Quedamos en 2:01:00

    
    
    
}
