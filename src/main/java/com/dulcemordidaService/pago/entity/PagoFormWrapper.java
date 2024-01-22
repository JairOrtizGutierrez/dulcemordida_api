package com.dulcemordidaService.pago.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class PagoFormWrapper {
    private int id;

    private String nombre;

    private String monto;

    private int pagoTipoId;

    private LocalDate fechaPago;

    private MultipartFile imagen;

    private String descripcion;
}