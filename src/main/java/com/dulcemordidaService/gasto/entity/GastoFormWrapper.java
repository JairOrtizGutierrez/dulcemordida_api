package com.dulcemordidaService.gasto.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class GastoFormWrapper {
    private int id;

    private String nombre;

    private String monto;

    private int gastoTipoId;

    private LocalDate fechaGasto;

    private MultipartFile imagen;

    private String descripcion;
}