package com.proyecto.api_inventario.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sede_almacen_id")
    private Long sede_almacen_id;

    @Column(name = "cantidad_productos")
    private Integer cantidad_productos;

}
