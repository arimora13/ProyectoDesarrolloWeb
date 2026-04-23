/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.controller;

import com.proyectoweb.proyectoweb.domain.Categoria;
import com.proyectoweb.proyectoweb.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Grupo 7
 */
@Controller
@RequestMapping("/admin/categorias")
public class AdminCategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.getCategorias());
        return "proyectoweb/admin/listadoCategorias";
    }

    @GetMapping("/nueva")
    public String nuevaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "proyectoweb/admin/formCategoria";
    }

    @PostMapping("/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.saveCategoria(categoria);
        return "redirect:/admin/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable("id") Long idCategoria, Model model) {
        Categoria categoria = categoriaService.getCategoria(new Categoria(idCategoria));
        model.addAttribute("categoria", categoria);
        return "proyectoweb/admin/formCategoria";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Long idCategoria) {
        Categoria categoria = new Categoria(idCategoria);
        categoriaService.deleteCategoria(categoria);
        return "redirect:/admin/categorias";
    }

}