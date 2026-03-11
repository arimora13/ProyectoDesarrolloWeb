/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.controller;

/**
 *
 * @author Arianna Mora
 */

import com.proyectoweb.proyectoweb.domain.Usuario;
import com.proyectoweb.proyectoweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/usuarios")
public class AdminUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("titulo", "Administrar Usuarios");
        model.addAttribute("usuarios", usuarioService.getUsuarios());
        return "proyectoweb/admin/listadoUsuarios";
    }

    @GetMapping("/nuevo")
    public String nuevoUsuario(Model model) {
        Usuario usuario = new Usuario();
        usuario.setActivo(true);

        model.addAttribute("titulo", "Nuevo Usuario");
        model.addAttribute("usuario", usuario);
        return "proyectoweb/admin/formUsuario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        boolean esAdmin = "ROLE_ADMIN".equals(usuario.getRol());
        usuarioService.saveUsuario(usuario, esAdmin);
        return "redirect:/admin/usuarios/listado";
    }

    @GetMapping("/editar/{idUsuario}")
    public String editarUsuario(@PathVariable("idUsuario") Long idUsuario, Model model) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        usuario = usuarioService.getUsuario(usuario);

        model.addAttribute("titulo", "Editar Usuario");
        model.addAttribute("usuario", usuario);
        return "proyectoweb/admin/formUsuario";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String eliminarUsuario(@PathVariable("idUsuario") Long idUsuario) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        usuarioService.deleteUsuario(usuario);
        return "redirect:/admin/usuarios/listado";
    }
}