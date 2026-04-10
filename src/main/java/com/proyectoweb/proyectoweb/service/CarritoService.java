/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectoweb.proyectoweb.service;
import com.proyectoweb.proyectoweb.domain.ItemCarrito;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Donovan
 */
public interface CarritoService {

    void agregarProducto(ItemCarrito item);

    List<ItemCarrito> getItems();

    void eliminarProducto(Long idProducto);

    void limpiarCarrito();

    BigDecimal getTotalCarrito();
    
}