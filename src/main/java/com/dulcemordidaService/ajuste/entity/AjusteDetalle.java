package com.dulcemordidaService.ajuste.entity;

import com.dulcemordidaService.producto.entity.Producto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name="ajusteDetalle")
public class AjusteDetalle {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "ajusteId")
    private Ajuste ajuste;

    @ManyToOne
    @JoinColumn(name = "productoId")
    private Producto producto;

    @Column(name="creadoPor")
    private String creadoPor;

    @Column(name="fechaCreacion")
    private LocalDate fechaCreacion;

    @Column(name="horaCreacion")
    private LocalTime horaCreacion;

    @Column(name="editadoPor")
    private String editadoPor;

    @Column(name="fechaEdicion")
    private LocalDate fechaEdicion;

    @Column(name="horaEdicion")
    private LocalTime horaEdicion;

    @Column(name="cantidad")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name="ajusteTipoId")
    private AjusteTipo ajusteTipo;

    @PreUpdate
    private void preUpdate() {
        this.fechaEdicion = LocalDate.now();
        this.horaEdicion = LocalTime.now();
    }

    @PrePersist
    private void preInsert() {
        this.fechaCreacion = LocalDate.now();
        this.horaCreacion = LocalTime.now();
    }
}