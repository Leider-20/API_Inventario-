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

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long prod_id;

    @Column(name = "nombre_producto")
    private String nombre_producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio")
    private Integer precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "almacen_id")
    private Almacen almacen;



    // Getter and Setter

    public Long getProd_id() {
        return prod_id;
    }

    public void setProd_id(Long prod_id) {
        this.prod_id = prod_id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }


    // TODO poner el nullable y el length en los diferentes atributos de la tabla.

}
