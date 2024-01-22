package com.dulcemordidaService.venta.entity;

import com.dulcemordidaService.producto.entity.Producto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="venta")
public class Venta {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="productoId")
    private Producto producto;

    @Column(name="cantidad")
    private int cantidad;

    @Column(name="monto", columnDefinition="Decimal(10, 2)")
    private String monto;

    @ManyToOne
    @JoinColumn(name="ventaTipoId")
    private VentaTipo ventaTipo;

    @Column(name="fechaVenta")
    private LocalDate fechaVenta;

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