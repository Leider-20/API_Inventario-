package com.proyecto.api_inventario.controllers;

import com.proyecto.api_inventario.exception.ModelNotFoundException;
import com.proyecto.api_inventario.models.Almacen;
import com.proyecto.api_inventario.services.AlmacenService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
/*@RequestMapping("/inventario") // No uso esta anotación porque quiero acceder directamente a los endpoints de cada uno de los métodos http donde hago las peticiones.*/

public class AlmacenController {

    @Autowired
    private AlmacenService almacenService;

    @ApiOperation(value = "Método para guardar los almacenes.")
    @PostMapping("/guardar-almacen")
    public ResponseEntity<Map<String, Object>> saveAlmacen(@RequestBody Almacen almacen){
        Almacen almacenGuardado = almacenService.saveAlmacen(almacen);
        Map<String, Object> response = new HashMap<>();
        response.put("almacen_id", almacenGuardado.getAlmacen_id());
        response.put("nombre_almacen", almacenGuardado.getNombre_almacen());
        response.put("sede_id", almacenGuardado.getSede().getSede_id());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Método para consultar y obtener todos los almacenes.")
    @GetMapping("/obtener-almacen-all")
    public ResponseEntity<List<Map<String, Object>>> getAlmacenAll(){
        Map<String, Object> response = new HashMap<>();
        List<Almacen> almacenGetAll = almacenService.getAlmacenAll();
        List<Map<String, Object>> almacenLista = new ArrayList<>();
        for (int i = 0; i < almacenGetAll.size(); i++) {
            response.put("almacen_id", almacenGetAll.get(i).getAlmacen_id());
            response.put("nombre_almacen", almacenGetAll.get(i).getNombre_almacen());
            response.put("sede_id", almacenGetAll.get(i).getSede().getSede_id());
            almacenLista.add(response);
        }
        return new ResponseEntity<>(almacenLista, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Método para consultar y obtener los almacenes por su ID.")
    @GetMapping("/obtener-almacen-id/{id}")
    public ResponseEntity<Map<String, Object>> getAlmacenById(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        Optional<Almacen> almacen = almacenService.getAlmacenById(id);
        if (almacen.isPresent()) {
            response.put("almacen_id", almacen.get().getAlmacen_id());
            response.put("nombre_almacen", almacen.get().getNombre_almacen());
            response.put("sede_id", almacen.get().getSede().getSede_id());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        throw new ModelNotFoundException("El almacén con ese ID no se encuentra registrado.");
    }

    @ApiOperation(value = "Método para borrar todos los almacenes.")
    @DeleteMapping("/borrar-almacen-all")
    public String deleteAlmacenAll(){
        boolean almacenVacio = almacenService.getAlmacenAll().isEmpty();
        if (!almacenVacio){
            almacenService.deleteAlmacenAll();
            return "Se han borrado todos los almacenes.";
        }
        return "No hay almacenes para borrar";
    }

    @ApiOperation(value = "Método para borrar los almacenes por su ID.")
    @DeleteMapping("/borrar-almacen-id/{id}")
    public String deleteAlmacenById(@PathVariable Long id){
        List<Almacen> almacenLista = almacenService.getAlmacenAll();
        for (int i = 0; i < almacenLista.size(); i++) {
            if (almacenLista.get(i).getAlmacen_id().equals(id)){
                almacenService.deleteAlmacenById(id);
                return "Almacén eliminado con éxito.";
            }
        }
        return "El almacén con ese ID no se encuentra registrado.";
    }
}
