/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda.Tienda.services;

import com.Tienda.Tienda.domain.Producto;
import java.util.List;

public interface ProductoService {

    // Se obtiene los registros de la tabla vategoria en un ArrayList
    // de objetos Producto, todos o solo los activos
    public List<Producto> getProductos(boolean activos);

    public Producto getProducto(Producto producto);

    public void save(Producto producto);

    public void delete(Producto producto);
    //Recupera un listado de registros producto filtrados por precio y ordenados por descripciòn
    public List<Producto> consulta1(double precioInf, double precioSup);
    
    public List<Producto> consulta2(double precioInf, double precioSup);
    
    public List<Producto> consulta3(double precioInf, double precioSup);
    
    
}
