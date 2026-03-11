/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.controller;

/**
 *
 * @author Arianna Mora
 */
import com.tiendaTech.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProyectoWebController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/proyectoweb")
    public String inicio(Model model) {
        model.addAttribute("titulo", "Inicio");
        model.addAttribute("productos", productoService.getProductosActivos());
        return "proyectoweb/index";
    }

    @GetMapping("/proyectoweb/productos")
    public String productos(Model model) {
        model.addAttribute("titulo", "Productos");
        model.addAttribute("productos", productoService.getProductosActivos());
        return "proyectoweb/productos";
    }

    @GetMapping("/proyectoweb/servicios")
    public String servicios(Model model) {
        model.addAttribute("titulo", "Servicios");
        return "proyectoweb/servicios";
    }

    @GetMapping("/proyectoweb/proyectos")
    public String proyectos(Model model) {
        model.addAttribute("titulo", "Proyectos");
        return "proyectoweb/proyectos";
    }

    @GetMapping("/proyectoweb/conocenos")
    public String conocenos(Model model) {
        model.addAttribute("titulo", "Conócenos");
        return "proyectoweb/conocenos";
    }

    @GetMapping("/proyectoweb/contacto")
    public String contacto(Model model) {
        model.addAttribute("titulo", "Contacto");
        return "proyectoweb/contacto";
    }
}