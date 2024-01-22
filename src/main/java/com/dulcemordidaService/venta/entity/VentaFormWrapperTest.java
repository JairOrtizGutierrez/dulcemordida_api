package com.dulcemordidaService.venta.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Arrays;

@Data
public class VentaFormWrapperTest {
    private int id;

    private int[] productoId;

    private int[] cantidad;

    private String[] monto;

    private int ventaTipoId;

    private LocalDate fechaVenta;

    private MultipartFile imagen;

    private String descripcion;

    public void setProductoId(String productoId) {
        int[] array = Arrays.stream(productoId.replace("[", "").replace("]", "").split(",")).mapToInt(Integer::parseInt).toArray();;
        this.productoId = array;
    }

    public void setCantidad(String cantidad) {
        int[] array = Arrays.stream(cantidad.replace("[", "").replace("]", "").split(",")).mapToInt(Integer::parseInt).toArray();;
        this.cantidad = array;
    }

    public void setMonto(String monto) {
        String[] array = monto.replace("[", "").replace("]", "").replace("\"", "").split(",");
        this.monto = array;
    }
}