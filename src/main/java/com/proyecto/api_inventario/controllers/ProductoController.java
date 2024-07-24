package com.proyecto.api_inventario.controllers;

import com.proyecto.api_inventario.exception.ModelNotFoundException;
import com.proyecto.api_inventario.models.Producto;
import com.proyecto.api_inventario.services.ProductoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @ApiOperation(value = "Método para guardar los productos.")
    @PostMapping("/guardar-producto")
    public Producto saveProducto(@RequestBody Producto producto){
        return productoService.saveProducto(producto);
    }

    @ApiOperation(value = "Método para consultar y obtener todos los productos.")
    @GetMapping("/obtener-producto-all")
    public List<Producto> getProductoAll(){
        return productoService.getProductoAll();
    }

    @ApiOperation(value = "Método para consultar y obtener los productos por su ID.")
    @GetMapping("/obtener-producto-id/{id}")
    public Producto getProductoById(@PathVariable Long id){
        Optional<Producto> producto = productoService.getProductoById(id);
        if (producto.isPresent()) {
            return producto.get();
        }
        throw new ModelNotFoundException("El producto con ese ID no se encuentra registrado.");
    }

    @ApiOperation(value = "Método para borrar todos los productos.")
    @DeleteMapping("/borrar-producto-all")
    public String deleteProductoAll(){
        boolean productoVacio = productoService.getProductoAll().isEmpty();
        if (!productoVacio){
            productoService.deleteProductoAll();
            return "Se han borrado todos los productos.";
        }
        return "No hay productos para borrar";
    }

    @ApiOperation(value = "Método para borrar los productos por su ID.")
    @DeleteMapping("/borrar-producto-id/{id}")
    public String deleteProductoById(@PathVariable Long id){
        List<Producto> productoLista = productoService.getProductoAll();
        for (int i = 0; i < productoLista.size(); i++) {
            if (productoLista.get(i).getProd_id().equals(id)){
                productoService.deleteProductoById(id);
                return "Producto eliminado con éxito.";
            }
        }
        return "El producto con ese ID no se encuentra registrado.";
    }
}
