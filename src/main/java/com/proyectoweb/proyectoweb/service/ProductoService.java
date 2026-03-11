/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.service;
import com.proyectoweb.proyectoweb.domain.Producto;
import java.util.List;
/**
 *
 * @author Arianna Mora
 */

public interface ProductoService {
List<Producto> getProductos();

    List<Producto> getProductosActivos();

    List<Producto> buscarPorNombre(String nombre);

    Producto getProducto(Producto producto);

    void saveProducto(Producto producto);

    void deleteProducto(Producto producto);
}
