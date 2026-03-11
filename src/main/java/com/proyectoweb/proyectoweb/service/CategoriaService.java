/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.service;

/**
 *
 * @author Arianna Mora
 */
    
import com.proyectoweb.proyectoweb.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    List<Categoria> getCategorias();

    Categoria getCategoria(Categoria categoria);

    void saveCategoria(Categoria categoria);

    void deleteCategoria(Categoria categoria);
}