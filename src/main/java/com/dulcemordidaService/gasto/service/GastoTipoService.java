package com.dulcemordidaService.gasto.service;

import com.dulcemordidaService.gasto.entity.GastoTipo;

import java.util.List;

public interface GastoTipoService {
    GastoTipo createGastoTipo(GastoTipo gastoTipo);

    List<GastoTipo> getAllGastoTipos();

    GastoTipo updateGastoTipo(GastoTipo gastoTipo);

    void deleteGastoTipo(int id);

    GastoTipo getGastoTipoById(int id);

    List<GastoTipo> getGastoTipoByNombre(String nombre);
}