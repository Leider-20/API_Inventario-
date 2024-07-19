package com.proyecto.api_inventario.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

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
    @Column(name = "almacen_id")
    private Long almacen_id;

    @Column(name = "nombre_almacen")
    private String nombre_almacen;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "almacen", cascade = CascadeType.ALL)
    private List<Producto> productos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sede_id")
    private Sede sede;


    // TODO poner el nullable y el length en los diferentes atributos de la tabla.


}
