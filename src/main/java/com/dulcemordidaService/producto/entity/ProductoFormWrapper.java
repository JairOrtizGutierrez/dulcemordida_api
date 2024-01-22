package com.dulcemordidaService.producto.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductoFormWrapper {
    private int id;

    private String nombre;

    private int subCategoriaId;

    private int marcaId;

    private int medidaId;

    private String precio;

    private MultipartFile imagen;

    private int estadoId;

    private String descripcion;
}