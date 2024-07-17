package com.proyecto.api_inventario.services;

import com.proyecto.api_inventario.models.Almacen;
import com.proyecto.api_inventario.repository.AlmacenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService {

    @Autowired
    private AlmacenRepository almacenRepository;

    public Almacen saveAlmacen (Almacen almacen){
        return almacenRepository.save(almacen);
    }

    public List<Almacen> getAlmacen(Almacen almacen){
        return almacenRepository.findAll();
    }

    public Optional<Almacen> getAlmacenById(Long id){
        return almacenRepository.findById(id);
    }

    public void deleteAlmacen(){
         almacenRepository.deleteAll();
    }

    public void deleteAlmacenById(Long id){
        almacenRepository.deleteById(id);
    }
}
