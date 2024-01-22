package com.dulcemordidaService.gasto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="gastoTipo")
public class GastoTipo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "gastoTipo")
    @JsonIgnore
    private List<Gasto> gasto;

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