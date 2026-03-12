/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.service.impl;
import com.proyectoweb.proyectoweb.domain.Usuario;
import com.proyectoweb.proyectoweb.dao.UsuarioDao;
import com.proyectoweb.proyectoweb.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
/**
 *
 * @author Arianna Mora
 */



@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    public void saveUsuario(Usuario usuario, boolean esAdmin) {

        if (usuario.getIdUsuario() == null) {

            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

            if (esAdmin) {
                usuario.setRol("ROLE_ADMIN");
            } else {
                usuario.setRol("ROLE_USER");
            }

            usuario.setActivo(true);

        } else {

            Usuario usuarioDB = usuarioDao.findById(usuario.getIdUsuario()).orElse(null);

            if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
                usuario.setPassword(usuarioDB.getPassword());
            } else {
                usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            }

        }

        usuarioDao.save(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    public boolean existeCorreo(String correo) {
        Usuario usuario = usuarioDao.findByCorreo(correo);
        return usuario != null;
    }

}