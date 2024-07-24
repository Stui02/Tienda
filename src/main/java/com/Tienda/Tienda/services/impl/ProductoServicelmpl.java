/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda.Tienda.services.impl;

import com.Tienda.Tienda.dao.ProductoDao;
import com.Tienda.Tienda.domain.Producto;
import com.Tienda.Tienda.services.ProductoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServicelmpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();

        if (activos) {
            lista.removeIf(c
                    -> !c.isActivo());
        }
        return lista;
    }

    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> consulta1(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> consulta2(double precioInf, double precioSup) {
        return productoDao.consultaJPQL(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> consulta3(double precioInf, double precioSup) {
        return productoDao.consultaSQL(precioInf, precioSup);
    }
}
