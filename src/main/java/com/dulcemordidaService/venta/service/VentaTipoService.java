package com.dulcemordidaService.venta.service;

import com.dulcemordidaService.venta.entity.VentaTipo;

import java.util.List;

public interface VentaTipoService {
    VentaTipo createVentaTipo(VentaTipo ventaTipo);

    List<VentaTipo> getAllVentaTipos();

    VentaTipo updateVentaTipo(VentaTipo ventaTipo);

    void deleteVentaTipo(int id);

    VentaTipo getVentaTipoById(int id);

    List<VentaTipo> getVentaTipoByNombre(String nombre);
}