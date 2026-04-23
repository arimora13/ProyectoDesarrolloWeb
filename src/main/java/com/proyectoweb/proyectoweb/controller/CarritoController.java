/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.controller;
import com.proyectoweb.proyectoweb.domain.ItemCarrito;
import com.proyectoweb.proyectoweb.domain.Producto;
import com.proyectoweb.proyectoweb.service.CarritoService;
import com.proyectoweb.proyectoweb.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Grupo 7
 */
@Controller
@RequestMapping("/carrito")
public class CarritoController {
   @Autowired
    private CarritoService carritoService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/ver")
    public String verCarrito(Model model) {
        model.addAttribute("items", carritoService.getItems());
        model.addAttribute("total", carritoService.getTotalCarrito());
        return "proyectoweb/carrito";
    }

    @GetMapping("/agregar/{id}")
    public String agregar(@PathVariable("id") Long idProducto) {

        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        producto = productoService.getProducto(producto);

        ItemCarrito item = new ItemCarrito();
        item.setProducto(producto);

        carritoService.agregarProducto(item);

        return "redirect:/carrito/ver";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long idProducto) {
        carritoService.eliminarProducto(idProducto);
        return "redirect:/carrito/ver";
    }
@GetMapping("/finalizar")
public String finalizar(Model model) {

    carritoService.limpiarCarrito();

    return "proyectoweb/compra_exitosa";
} 
}
