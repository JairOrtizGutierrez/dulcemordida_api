package com.dulcemordidaService.producto.service;

import com.dulcemordidaService.producto.entity.Categoria;
import com.dulcemordidaService.producto.entity.SubCategoria;

import java.util.List;

public interface CategoriaService {
    Categoria createCategoria(Categoria categoria);

    List<Categoria> getAllCategorias();

    Categoria updateCategoria(Categoria categoria);

    void deleteCategoria(int id);

    Categoria getCategoriaById(int id);

    List<Categoria> getCategoriaByNombre(String nombre);

    List<SubCategoria> getSubCategoriaByCategoryId(int id);
}