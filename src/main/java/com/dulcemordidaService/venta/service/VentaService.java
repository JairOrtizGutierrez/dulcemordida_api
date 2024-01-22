package com.dulcemordidaService.venta.service;

import com.dulcemordidaService.venta.entity.Venta;
import com.dulcemordidaService.venta.entity.VentaFormWrapper;
import com.dulcemordidaService.venta.entity.VentaFormWrapperTest;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VentaService {
    Venta createVenta(Venta venta);

    List<Venta> getAllVentas();

    Venta updateVenta(Venta venta);

    void deleteVenta(int id);

    Venta getVentaById(int id);

    List<Venta> getVentaByRangoFechas(LocalDate fechaInicial, LocalDate fechaFinal);

    List<ObjectNode> getTotalSales(LocalDate fechaInicial, LocalDate fechaFinal);

    ObjectNode getDailySales();

    List<ObjectNode> getTotalWeeklySales();

    ObjectNode getTotalMonthlySales();

    ObjectNode getWeeklySales();

    List<ObjectNode> getTotalYearlySales();

    ObjectNode getYearlySales();

    Optional<Venta> createVenta(VentaFormWrapper ventaFormWrapper);

    Optional<Venta[]> createMultipleVenta(VentaFormWrapper[] ventaFormWrapper);

    Optional<Venta> updateVenta(VentaFormWrapper ventaFormWrapper);
}