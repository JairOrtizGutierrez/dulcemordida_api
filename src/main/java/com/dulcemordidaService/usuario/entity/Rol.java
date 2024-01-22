package com.dulcemordidaService.usuario.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="rol")
public class Rol {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;
}