/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.controller;

/**
 *
 * @author Grupo 7
 */

import com.proyectoweb.proyectoweb.domain.Producto;
import com.proyectoweb.proyectoweb.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProyectoWebController {

    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private com.proyectoweb.proyectoweb.service.CategoriaService categoriaService;

    @GetMapping("/proyectoweb")
    public String inicio(Model model) {
        model.addAttribute("titulo", "Inicio");
        model.addAttribute("productos", productoService.getProductosActivos());
        return "proyectoweb/index";
    }

    @GetMapping("/proyectoweb/productos")
    public String productos(
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) Boolean activo,
        @RequestParam(required = false) Long categoria,
        Model model) {

        model.addAttribute("titulo", "Productos");

        var productos = productoService.buscarProductos(nombre, activo, categoria);

        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categoriaService.getCategorias());

        return "proyectoweb/productos";
    }

    @GetMapping("/proyectoweb/detalle-producto/{idProducto}")
    public String detalleProducto(@PathVariable("idProducto") Long idProducto, Model model) {
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        producto = productoService.getProducto(producto);

        model.addAttribute("titulo", "Detalle Producto");
        model.addAttribute("producto", producto);
        return "proyectoweb/detalleProducto";
    }

    @GetMapping("/proyectoweb/carrito")
    public String carrito(Model model) {
        model.addAttribute("titulo", "Carrito");
        return "proyectoweb/carrito";
    }

    @GetMapping("/proyectoweb/servicios")
    public String servicios(Model model) {
        model.addAttribute("titulo", "Servicios");
        return "proyectoweb/servicios";
    }

   @GetMapping("/proyectoweb/proyectos")
public String proyectos(Model model) {

    String[] titles = {
        "Proyecto - Tienda H&M",
        "Proyecto - Hospitales",
        "Proyecto - Amazon",
        "Proyecto - COCINA",
        "Proyectos McDonal's",
        "Proyecto - INSS"
    };

    String[] descriptions = {
        "Especificaciones: Placa de empuje, cerraduras y placa de pateo.",
        "Especificaciones: Mirilla con cristal mallado certificado, placa de empuje, cerraduras y louver.",
        "Especificaciones: Mirilla con cristal mallado certificado, cierra puertas, cerradura, bisagras y barra antipánico.",
        "Especificaciones: Mirilla con cristal mallado certificado, placa de empuje con jaladera, cerradura y placa de pateo.",
        "Especificación: Puerta metálica resistente instalada en sucursal McDonald's.",
        "Especificaciones: Puerta corrediza, placa de pateo y placa de empuje con jaladera."
    };

    model.addAttribute("titles", titles);
    model.addAttribute("descriptions", descriptions);

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