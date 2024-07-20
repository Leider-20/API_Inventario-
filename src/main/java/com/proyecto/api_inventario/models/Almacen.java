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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "almacen_id")
    private Long almacen_id;

    @Column(name = "nombre_almacen")
    private String nombre_almacen;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "almacen", cascade = CascadeType.ALL)
    private List<Producto> productos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sede_id")
    private Sede sede;



    // Getter and Setter

    public Long getAlmacen_id() {
        return almacen_id;
    }

    public void setAlmacen_id(Long almacen_id) {
        this.almacen_id = almacen_id;
    }

    public String getNombre_almacen() {
        return nombre_almacen;
    }

    public void setNombre_almacen(String nombre_almacen) {
        this.nombre_almacen = nombre_almacen;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }


    // TODO poner el nullable y el length en los diferentes atributos de la tabla.


}
