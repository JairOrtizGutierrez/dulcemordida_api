package com.dulcemordidaService.producto.entity;

import com.dulcemordidaService.ajuste.entity.AjusteDetalle;
import com.dulcemordidaService.venta.entity.Venta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="producto")
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "subCategoriaId")
    private SubCategoria subCategoria;

    @ManyToOne
    @JoinColumn(name="marcaId")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name="medidaId")
    private Medida medida;

    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    private List<AjusteDetalle> ajusteDetalles;

    @Column(name="precio", columnDefinition="Decimal(10, 2)")
    private String precio;

    @Column(name="imagen")
    private String imagen;

    @ManyToOne
    @JoinColumn(name="estadoId")
    private Estado estado;

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