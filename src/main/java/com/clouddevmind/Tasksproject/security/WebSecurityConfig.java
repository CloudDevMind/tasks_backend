package com.clouddevmind.Tasksproject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    
    /**
     * Bean configures the filter chain for authorization via jwt in our app, guys
     * @param http
     * @param authManager
     * @return HttpSecurity
     * @throws Exception
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{
        return http
                .csrf().disable()
                //Three liner: authorize any authenticated requests
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                //And config is http basic
                .and()
                .httpBasic()
                .and()
                //And session management is given by STATELESS policy
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //Then you build your HttpSecurity
                .build();
    }

    /**
     * Creates an InMemory user
     * @return InMemoryUserDetailsManager 
     */
    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //We use the manager in order to create an InMemory user and test the filterChain authentication
        manager.createUser(User.withUsername("admin")
        .password(passwordEncoder().encode("admin"))
        .roles()
        .build());

        return manager;
    }

    /**
     * Manages authentication using username and password
     * @param http
     * @return AuthenticationManager
     * @throws Exception
     */
    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    /**
     * Provides BCrypt Encription for the password
     * @return BCryptPasswordEncoder
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
