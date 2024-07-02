/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.Tienda.services.impl;

import com.Tienda.Tienda.dao.CategoriaDao;
import com.Tienda.Tienda.domain.Categoria;
import com.Tienda.Tienda.services.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author stu22
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista= categoriaDao.findAll();
        
        if (activos){
            // solo quiero las categorias activas
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
        
     
    }
    
    
}
