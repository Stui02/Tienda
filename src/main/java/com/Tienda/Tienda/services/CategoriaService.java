/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda.Tienda.services;


import com.Tienda.Tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {

    // Se obtiene los registros de la tabla vategoria en un ArrayList
    // de objetos Categoria, todos o solo los activos
    public List<Categoria> getCategorias(boolean activos);

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria);

    public void delete(Categoria categoria);
}
