/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.config;

/**
 *
 * @author GRUPO 7
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/",
                    "/proyectoweb",
                    "/proyectoweb/productos",
                    "/proyectoweb/detalle-producto/**",
                    "/proyectoweb/servicios",
                    "/proyectoweb/proyectos",
                    "/proyectoweb/conocenos",
                    "/proyectoweb/contacto",
                    "/proyectoweb/registro",
                    "/login",
                    "/css/**",
                    "/js/**",
                    "/img/**",
                    "/uploads/**",
                    "/webjars/**"
                ).permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/usuario/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/proyectoweb", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/proyectoweb")
                .permitAll()
            );

        return http.build();
    }
    
}