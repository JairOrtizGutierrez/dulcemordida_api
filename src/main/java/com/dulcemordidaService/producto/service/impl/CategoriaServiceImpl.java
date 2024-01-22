package com.dulcemordidaService.producto.service.impl;

import com.dulcemordidaService.producto.entity.Categoria;
import com.dulcemordidaService.producto.entity.SubCategoria;
import com.dulcemordidaService.producto.repository.CategoriaRepository;
import com.dulcemordidaService.producto.repository.SubCategoriaRepository;
import com.dulcemordidaService.producto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    SubCategoriaRepository subCategoriaRepository;

    @Override
    public Categoria createCategoria(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> getAllCategorias() {
        return this.categoriaRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public void deleteCategoria(int id) {
        this.categoriaRepository.deleteById(id);
    }

    @Override
    public Categoria getCategoriaById(int id) {
        return this.categoriaRepository.findById(id);
    }

    @Override
    public List<Categoria> getCategoriaByNombre(String nombre) {
        return this.categoriaRepository.findByNombreContains(nombre);
    }

    @Override
    public List<SubCategoria> getSubCategoriaByCategoryId(int id) {
        return this.subCategoriaRepository.findSubcategoriasByCategoriaId(id);
    }
}