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

}
