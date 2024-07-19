package com.proyecto.api_inventario.services;

import com.proyecto.api_inventario.models.Producto;
import com.proyecto.api_inventario.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public Producto saveProductos (Producto producto){
        return productosRepository.save(producto);
    }

    public List<Producto> getProductosAll(Producto producto){
        return productosRepository.findAll();
    }

    public Optional<Producto> getProductosById(Long id){
        return productosRepository.findById(id);
    }

    public void deleteProductosAll(){
        productosRepository.deleteAll();
    }

    public void deleteProductosById(Long id){
        productosRepository.deleteById(id);
    }
}
