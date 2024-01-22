package com.dulcemordidaService.producto.service;

import com.dulcemordidaService.producto.entity.SubCategoria;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface SubCategoriaService {
    SubCategoria createSubCategoria(SubCategoria subCategoria);

    List<SubCategoria> getAllSubCategorias();

    SubCategoria updateSubCategoria(SubCategoria subCategoria);

    void deleteSubCategoria(int id);

    SubCategoria getSubCategoriaById(int id);

    List<SubCategoria> getSubCategoriaByNombre(String nombre);
}