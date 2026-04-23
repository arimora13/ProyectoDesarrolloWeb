/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.domain;

import java.math.BigDecimal;

import lombok.Data;
/**
 *
 * @author Donovan
 */
@Data
public class ItemCarrito {
   private Producto producto;
    private int cantidad;

    public BigDecimal getTotal() {
        return producto.getPrecio().multiply(new BigDecimal(cantidad));
    }
}