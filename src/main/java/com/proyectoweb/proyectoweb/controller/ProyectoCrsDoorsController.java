/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ProyectoCrsDoorsController {
    @GetMapping("/proyectocrsdoor")
    public String inicio(Model model) {
        model.addAttribute("titulo", "Inicio");
        return "proyectocrsdoor/index";
    }
    @GetMapping("/proyectocrsdoor/servicios")
    public String servicios(Model model) {
        model.addAttribute("titulo", "Servicios");
        return "proyectocrsdoor/servicios";
    }
    @GetMapping("/proyectocrsdoor/productos")
    public String productos(Model model) {
        model.addAttribute("titulo", "Productos");
        return "proyectocrsdoor/productos";
    }
    @GetMapping("/proyectocrsdoor/detalle-producto")
    public String detalleProducto(Model model) {
        model.addAttribute("titulo", "Detalle Producto");
        return "proyectocrsdoor/detalleProducto";
    }
    @GetMapping("/proyectocrsdoor/proyectos")
    public String proyectos(Model model) {
        model.addAttribute("titulo", "Proyectos");
        return "proyectocrsdoor/proyectos";
    }
    @GetMapping("/proyectocrsdoor/conocenos")
    public String conocenos(Model model) {
        model.addAttribute("titulo", "Conócenos");
        return "proyectocrsdoor/conocenos";
    }
    @GetMapping("/proyectocrsdoor/contacto")
    public String contacto(Model model) {
        model.addAttribute("titulo", "Contacto");
        return "proyectocrsdoor/contacto";
    }
    @GetMapping("/proyectocrsdoor/login")
    public String login(Model model) {
        model.addAttribute("titulo", "Login");
        return "proyectocrsdoor/login";
    }
    @GetMapping("/proyectocrsdoor/registro")
    public String registro(Model model) {
        model.addAttribute("titulo", "Registro");
        return "proyectocrsdoor/registro";
    }
    @GetMapping("/proyectocrsdoor/carrito")
    public String carrito(Model model) {
        model.addAttribute("titulo", "Carrito");
        return "proyectocrsdoor/carrito";
    }
    @GetMapping("/proyectocrsdoor/ayuda")
    public String ayuda(Model model) {
        model.addAttribute("titulo", "Ayuda");
        return "proyectocrsdoor/ayuda";
    }
    @GetMapping("/proyectocrsdoor/cotizacion")
    public String cotizacion(Model model) {
        model.addAttribute("titulo", "Cotización");
        return "proyectocrsdoor/cotizacion";
    }
}