/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda.Tienda.dao;

import com.Tienda.Tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductoDao extends JpaRepository<Producto, Long> {

    public List<Producto> findByPrecioBetweenOrderByDescripcion(
            double precioInf,
            double precioSup);

    @Query(value = "SELECT a FROM Producto a "
            + "WHERE a.precio BETWEEN :precioInf AND :precioSup "
            + "ORDER BY a.descripcion ASC")
    public List<Producto> consultaJPQL(double precioInf, double precioSup);

    @Query(nativeQuery=true,
            value = "SELECT a FROM Producto a "
            + "WHERE a.precio BETWEEN :precioInf AND :precioSup "
            + "ORDER BY a.descripcion ASC")
    public List<Producto> consultaSQL(double precioInf, double precioSup);

}
