package com.dulcemordidaService.producto.service;

import com.dulcemordidaService.producto.entity.Marca;

import java.util.List;

public interface MarcaService {
    Marca createMarca(Marca marca);

    List<Marca> getAllMarcas();

    Marca updateMarca(Marca marca);

    void deleteMarca(int id);

    Marca getMarcaById(int id);

    List<Marca> getMarcaByNombre(String nombre);
}