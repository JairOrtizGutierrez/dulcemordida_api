package com.dulcemordidaService.producto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="marca")
public class Marca {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "marca")
    @JsonIgnore
    private List<Producto> productos;

    @Column(name="descripcion")
    private String descripcion;

    @PreUpdate
    private void preUpdate() {
        if (this.descripcion == "") this.descripcion = null;
    }

    @PrePersist
    private void preInsert() {
        if (this.descripcion == "") this.descripcion = null;
    }
}