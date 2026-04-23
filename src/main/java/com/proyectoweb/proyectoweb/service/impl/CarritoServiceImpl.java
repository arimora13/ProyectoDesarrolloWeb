/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.service.impl;
import com.proyectoweb.proyectoweb.domain.ItemCarrito;
import com.proyectoweb.proyectoweb.service.CarritoService;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Donovan
 */
@Service
public class CarritoServiceImpl implements CarritoService {
  @Autowired
    private HttpSession session;

    private List<ItemCarrito> getCarrito() {
        
        List<ItemCarrito> carrito = (List<ItemCarrito>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
            session.setAttribute("carrito", carrito);
        }

        return carrito;
    }

    @Override
    public void agregarProducto(ItemCarrito item) {

        List<ItemCarrito> carrito = getCarrito();

        for (ItemCarrito i : carrito) {
            
            if (i.getProducto().getIdProducto().equals(item.getProducto().getIdProducto())) {
                i.setCantidad(i.getCantidad() + 1);
                return;
            }
        }

        item.setCantidad(1);
        carrito.add(item);
    }

    @Override
    public List<ItemCarrito> getItems() {
        return getCarrito();
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        getCarrito().removeIf(i -> i.getProducto().getIdProducto().equals(idProducto));
    }

    @Override
    public void limpiarCarrito() {
        getCarrito().clear();
    }

    @Override
    public BigDecimal getTotalCarrito() {
        return getCarrito().stream()
                .map(ItemCarrito::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
