package com.proyecto.api_inventario.repository;

import com.proyecto.api_inventario.models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
}
