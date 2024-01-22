package com.dulcemordidaService.producto.service.impl;

import com.dulcemordidaService.producto.entity.SubCategoria;
import com.dulcemordidaService.producto.repository.SubCategoriaRepository;
import com.dulcemordidaService.producto.service.SubCategoriaService;
import com.dulcemordidaService.utils.DataConvert;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoriaServiceImpl implements SubCategoriaService {
    @Autowired
    SubCategoriaRepository subCategoriaRepository;

    @Override
    public SubCategoria createSubCategoria(SubCategoria subCategoria) {
        return this.subCategoriaRepository.save(subCategoria);
    }

    @Override
    public List<SubCategoria> getAllSubCategorias() {
        return this.subCategoriaRepository.findAllByOrderByIdDesc();
    }

    @Override
    public SubCategoria updateSubCategoria(SubCategoria subCategoria) {
        return this.subCategoriaRepository.save(subCategoria);
    }

    @Override
    public void deleteSubCategoria(int id) {
        this.subCategoriaRepository.deleteById(id);
    }

    @Override
    public SubCategoria getSubCategoriaById(int id) {
        return this.subCategoriaRepository.findById(id);
    }

    @Override
    public List<SubCategoria> getSubCategoriaByNombre(String nombre) {
        return this.subCategoriaRepository.findByNombreContains(nombre);
    }
}
