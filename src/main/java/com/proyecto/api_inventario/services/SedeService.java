package com.proyecto.api_inventario.services;

import com.proyecto.api_inventario.models.Sede;
import com.proyecto.api_inventario.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    public Sede saveSede (Sede sede){
        return sedeRepository.save(sede);
    }

    public List<Sede> getSedeAll(){
        return sedeRepository.findAll();
    }

    public Optional<Sede> getSedeById(Long id){
        return sedeRepository.findById(id);
    }

    public void deleteSedeAll (){
        sedeRepository.deleteAll();
    }

    public void deleteSedeById (Long id){
        sedeRepository.deleteById(id);
    }


    /** @La diferencia entre el método "deleteSedeById" de arriba y el que está aquí abajo es que el de abajo tiene una restricción.
     * Al intentar borrar una sede si hay almacenes en las tablas de la BD asociados a esta, entonces no se borrará la sede*/

    /*public void deleteSedeById(Long id) {
        List<Almacen> almacenes = almacenRepository.findBySedeId(id);
        if (!almacenes.isEmpty()) {
            throw new DataIntegrityViolationException("No se puede eliminar la sede porque tiene almacenes asociados.");
        }
        sedeRepository.deleteById(id);
    }*/
}
