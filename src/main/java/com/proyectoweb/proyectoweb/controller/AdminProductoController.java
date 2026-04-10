/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.controller;

/**
 *
 * @author Grupo 7
 */
import org.springframework.security.access.prepost.PreAuthorize;
import com.proyectoweb.proyectoweb.domain.Producto;
import com.proyectoweb.proyectoweb.service.CategoriaService;
import com.proyectoweb.proyectoweb.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/productos")
@PreAuthorize("hasRole('ADMIN')")
public class AdminProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("titulo", "Administrar Productos");
        model.addAttribute("productos", productoService.getProductos());
        return "proyectoweb/admin/listadoProductos";
    }

    @GetMapping("/nuevo")
    public String nuevoProducto(Model model) {
        model.addAttribute("titulo", "Nuevo Producto");
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "proyectoweb/admin/formProducto";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/admin/productos/listado";
    }

    @GetMapping("/editar/{idProducto}")
    public String editarProducto(@PathVariable("idProducto") Long idProducto, Model model) {
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);

        model.addAttribute("titulo", "Editar Producto");
        model.addAttribute("producto", productoService.getProducto(producto));
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "proyectoweb/admin/formProducto";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String eliminarProducto(@PathVariable("idProducto") Long idProducto) {
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        productoService.deleteProducto(producto);
        return "redirect:/admin/productos/listado";
    }
}