package com.dulcemordidaService.producto.service;

import com.dulcemordidaService.producto.entity.Medida;

import java.util.List;

public interface MedidaService {
    Medida createMedida(Medida medida);

    List<Medida> getAllMedidas();

    Medida updateMedida(Medida medida);

    void deleteMedida(int id);

    Medida getMedidaById(int id);

    List<Medida> getMedidaByNombre(String nombre);

    Medida getMedidaByProductId(int id);
}