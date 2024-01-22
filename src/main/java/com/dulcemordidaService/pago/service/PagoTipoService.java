package com.dulcemordidaService.pago.service;

import com.dulcemordidaService.pago.entity.PagoTipo;

import java.util.List;

public interface PagoTipoService {
    PagoTipo createPagoTipo(PagoTipo pagoTipo);

    List<PagoTipo> getAllPagoTipos();

    PagoTipo updatePagoTipo(PagoTipo pagoTipo);

    void deletePagoTipo(int id);

    PagoTipo getPagoTipoById(int id);

    List<PagoTipo> getPagoTipoByNombre(String nombre);
}