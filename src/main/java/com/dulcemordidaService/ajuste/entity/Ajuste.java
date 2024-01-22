package com.dulcemordidaService.ajuste.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="ajuste")
public class Ajuste {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="fechaStock")
    private LocalDate fechaStock;

    @OneToMany(mappedBy = "ajuste")
    @JsonIgnore
    private List<AjusteDetalle> ajusteDetalles;
}