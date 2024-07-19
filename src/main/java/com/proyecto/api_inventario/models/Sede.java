package com.proyecto.api_inventario.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sede_id")
    private Long sede_id;

    @Column(name = "nombre_sede")
    private String nombre_sede;

    @Column(name = "ubicacion")
    private String ubicacion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sede", cascade = CascadeType.ALL)
    private List<Almacen> almacenes;


    // TODO poner el nullable y el length en los diferentes atributos de la tabla.

}
