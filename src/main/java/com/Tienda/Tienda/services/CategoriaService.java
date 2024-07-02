/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda.Tienda.services;

import com.Tienda.Tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author stu22
 */
public interface CategoriaService {
    //Se obtiene los registros de la tabla categoria en una ArrayList
    // de objectos Categoria, todos o solo los activos
    
    public List<Categoria>getCategorias(boolean activos);
}
