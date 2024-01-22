package com.dulcemordidaService.ajuste.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="ajusteTipo")
public class AjusteTipo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @OneToMany(mappedBy = "ajusteTipo")
    @JsonIgnore
    private List<AjusteDetalle> ajustesDetalle;
}