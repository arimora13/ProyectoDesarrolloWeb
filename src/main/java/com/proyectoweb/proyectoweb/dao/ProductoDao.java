/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyectoweb.proyectoweb.dao;

import com.proyectoweb.proyectoweb.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author Grupo 7
 */
public interface ProductoDao extends JpaRepository<Producto, Long> {

    List<Producto> findByActivoTrue();
    
    List<Producto> findByActivo(boolean activo);

    List<Producto> findByActivoTrueAndNombreContainingIgnoreCase(String nombre);
    
    List<Producto> findByCategoria_IdCategoria(Long idCategoria);

    @Query("""
           SELECT p FROM Producto p
           WHERE (:nombre IS NULL OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')))
           AND (:activo IS NULL OR p.activo = :activo)
           AND (:categoria IS NULL OR p.categoria.idCategoria = :categoria)
           """)
    List<Producto> buscarProductos(
            @Param("nombre") String nombre,
            @Param("activo") Boolean activo,
            @Param("categoria") Long categoria);
}
