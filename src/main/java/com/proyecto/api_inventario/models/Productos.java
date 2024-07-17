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
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "referencia_id")
    private Long referencia_id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Integer precio;
}
