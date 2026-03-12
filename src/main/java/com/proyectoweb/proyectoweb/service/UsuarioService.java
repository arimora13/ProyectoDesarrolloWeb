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

    public List<Usuario> getUsuarios();

    public Usuario getUsuario(Usuario usuario);

    public void saveUsuario(Usuario usuario, boolean esAdmin);

    public void deleteUsuario(Usuario usuario);

    public boolean existeCorreo(String correo);

}