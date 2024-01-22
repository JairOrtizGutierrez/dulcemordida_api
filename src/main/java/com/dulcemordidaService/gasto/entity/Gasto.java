package com.dulcemordidaService.gasto.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="gasto")
public class Gasto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="monto", columnDefinition="Decimal(10, 2)")
    private String monto;

    @ManyToOne
    @JoinColumn(name="gastoTipoId")
    private GastoTipo gastoTipo;

    @Column(name="fechaGasto")
    private LocalDate fechaGasto;

    @Column(name="imagen")
    private String imagen;

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