package com.proyectoweb.proyectoweb.service;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Arianna Mora
 */

import com.proyectoweb.proyectoweb.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> getUsuarios();

    Usuario getUsuario(Usuario usuario);

    void saveUsuario(Usuario usuario, boolean esAdmin);

    void deleteUsuario(Usuario usuario);

    Usuario buscarPorCorreo(String correo);

    boolean existeCorreo(String correo);
}