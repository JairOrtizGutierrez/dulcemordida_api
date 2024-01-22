package com.dulcemordidaService.pago.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="pago")
public class Pago {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="monto", columnDefinition="Decimal(10, 2)")
    private String monto;

    @ManyToOne
    @JoinColumn(name="pagoTipoId")
    private PagoTipo pagoTipo;

    @Column(name="fechaPago")
    private LocalDate fechaPago;

    @Column(name="imagen")
    private String imagen;

    @Column(name="descripcion")
    private String descripcion;

    @PreUpdate
    private void preUpdate() {
        if (this.descripcion.isEmpty() || this.descripcion.isBlank()) this.descripcion = null;
    }

    @PrePersist
    private void preInsert() {
        if (this.descripcion.isEmpty() || this.descripcion.isBlank()) this.descripcion = null;
    }
}