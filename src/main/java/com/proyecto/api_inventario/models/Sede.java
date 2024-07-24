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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sede_id")
    private Long sede_id;

    @Column(name = "nombre_sede")
    private String nombre_sede;

    @Column(name = "ubicacion")
    private String ubicacion;

    /** El "cascade = CascadeType.ALL, orphanRemoval = true" es para que cuando se realice alguna operación en la tabla de sedes, se realice la misma operación en la tabla de asociada, la tabla de almacenes. */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sede", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Almacen> almacenes;



    // Getter and Setter
    public Long getSede_id() {
        return sede_id;
    }

    public void setSede_id(Long sede_id) {
        this.sede_id = sede_id;
    }

    public String getNombre_sede() {
        return nombre_sede;
    }

    public void setNombre_sede(String nombre_sede) {
        this.nombre_sede = nombre_sede;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Almacen> getAlmacenes() {
        return almacenes;
    }

    public void setAlmacenes(List<Almacen> almacenes) {
        this.almacenes = almacenes;
    }


    // TODO poner el nullable y el length en los diferentes atributos de la tabla.

}
