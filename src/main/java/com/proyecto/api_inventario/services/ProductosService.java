package com.proyecto.api_inventario.services;

import com.proyecto.api_inventario.models.Almacen;
import com.proyecto.api_inventario.models.Productos;
import com.proyecto.api_inventario.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public Productos saveProductos (Productos productos){
        return productosRepository.save(productos);
    }

    public List<Productos> getProductos(Productos productos){
        return productosRepository.findAll();
    }

    public Optional<Productos> getProductosById(Long id){
        return productosRepository.findById(id);
    }

    public void deleteProductos(){
        productosRepository.deleteAll();
    }

    public void deleteProductosById(Long id){
        productosRepository.deleteById(id);
    }
}
