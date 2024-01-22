package com.dulcemordidaService.venta.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
public class VentaFormWrapper {
    private int id;

    private int productoId;

    private int cantidad;

    private String monto;

    private int ventaTipoId;

    private LocalDate fechaVenta;

    private MultipartFile imagen;

    private String descripcion;
}