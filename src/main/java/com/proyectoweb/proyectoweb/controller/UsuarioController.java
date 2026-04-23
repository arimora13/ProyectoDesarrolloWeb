/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.controller;

/**
 *
 * @author Arianna Mora
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @GetMapping("/inicio")
    public String inicioUsuario(Model model) {
        model.addAttribute("titulo", "Área de Usuario");
        return "redirect:/proyectoweb";
    }

    @GetMapping("/carrito")
    public String carritoUsuario(Model model) {
        model.addAttribute("titulo", "Carrito");
        return "proyectoweb/carrito";
    }
}