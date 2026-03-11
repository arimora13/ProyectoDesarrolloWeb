/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.controller;

/**
 *
 * @author Arianna Mora
 */
import com.tiendaTech.tienda.domain.Usuario;
import com.tiendaTech.tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/proyectoweb/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("titulo", "Registro");
        model.addAttribute("usuario", new Usuario());
        return "proyectoweb/registro";
    }

    @PostMapping("/proyectoweb/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario, Model model) {

        if (usuarioService.existeCorreo(usuario.getCorreo())) {
            model.addAttribute("titulo", "Registro");
            model.addAttribute("error", "Ya existe un usuario con ese correo");
            model.addAttribute("usuario", usuario);
            return "proyectoweb/registro";
        }

        usuarioService.saveUsuario(usuario, false);
        return "redirect:/login";
    }
}