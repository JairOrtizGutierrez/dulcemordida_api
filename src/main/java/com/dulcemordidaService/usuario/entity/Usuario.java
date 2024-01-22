package com.dulcemordidaService.usuario.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="correo")
    private String correo;

    @Column(name="contraseña")
    private String contraseña;

    @ManyToOne
    @JoinColumn(name="rolId")
    private Rol rol;
}