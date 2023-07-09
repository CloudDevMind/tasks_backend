package com.clouddevmind.Tasksproject.security;

import java.io.IOException;
import java.util.Collections;

import javax.naming.AuthenticationException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    /**
     * @return
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, 
                                                HttpServletResponse response){

        AuthCredentials authCredentials = new AuthCredentials();

        try{
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        }catch(IOException e){}

        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                authCredentials.getUserName(), 
                authCredentials.getPassword(), 
                Collections.emptyList()
        );

        return getAuthenticationManager().authenticate(usernamePAT);
    }
}
