package com.proyecto.api_inventario.controllers;

import com.proyecto.api_inventario.exception.ModelNotFoundException;
import com.proyecto.api_inventario.models.Sede;
import com.proyecto.api_inventario.services.SedeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
/* @RequestMapping("/inventario") // No uso esta anotación porque quiero acceder directamente a los endpoints de los métodos http donde hago las peticiones.*/
@CrossOrigin("*")
@Api(value = "Inventario de productos", description = "Operaciones para el inventario")


public class SedeController {

    @Autowired
    private SedeService sedeService;
    private Sede sede;


    /**
     * El método de abajo: "@PostMapping" lo hago de tipo "return" y no "void" para que en Postman cuando haga una solicitud para guardar los datos
     * me retorne y me muestre los datos que estoy guardando.
     */

    @ApiOperation(value = "Método para guardar las sedes.")
    @PostMapping("/guardar-sede")
    public Sede saveSede(@RequestBody Sede sede) {
        return sedeService.saveSede(sede);
    }

    @ApiOperation(value = "Método para consultar y obtener todas las sedes.")
    @GetMapping("/obtener-sede-all")
    public List<Sede> getSedeAll() {
        return sedeService.getSedeAll();
    }

    @ApiOperation(value = "Método para consultar y obtener las sedes por su ID.")
    @GetMapping("/obtener-sede-id/{id}")
    public Sede getSedeById(@PathVariable Long id) {
        Optional<Sede> sede = sedeService.getSedeById(id);
        if (sede.isPresent()) {
            return sede.get();
        }
        throw new ModelNotFoundException("La sede con ese ID no se encuentra registrada.");
    }

    @ApiOperation(value = "Método para borrar todas las sedes.")
    @DeleteMapping("/borrar-sede-all")
    public String deleteSedeAll() {
        if (!sedeService.getSedeAll().isEmpty()){
            sedeService.deleteSedeAll();
            return "Se han borrado todas las sedes.";
        }
        return "No hay sedes para borrar.";
    }

    @ApiOperation(value = "Método para borrar las sedescpor su ID.")
    @DeleteMapping("/borrar-sede-id/{id}")
    public String deleteSedeById(@PathVariable Long id) {
        List<Sede> sedeLista = sedeService.getSedeAll();
        for (int i = 0; i < sedeLista.size(); i++) {
            if (sedeLista.get(i).getSede_id().equals(id)) {
                sedeService.deleteSedeById(id);
                return "Sede eliminada con éxito.";
            }
        }
        return "La sede no está registrada.";
    }
}
