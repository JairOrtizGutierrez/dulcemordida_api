package com.dulcemordidaService.producto.service.impl;

import com.dulcemordidaService.producto.entity.Marca;
import com.dulcemordidaService.producto.repository.MarcaRepository;
import com.dulcemordidaService.producto.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {
    @Autowired
    MarcaRepository marcaRepository;

    @Override
    public Marca createMarca(Marca marca) {
        return this.marcaRepository.save(marca);
    }

    @Override
    public List<Marca> getAllMarcas() {
        return this.marcaRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Marca updateMarca(Marca marca) {
        return this.marcaRepository.save(marca);
    }

    @Override
    public void deleteMarca(int id) {
        this.marcaRepository.deleteById(id);
    }

    @Override
    public Marca getMarcaById(int id) {
        return this.marcaRepository.findById(id);
    }

    @Override
    public List<Marca> getMarcaByNombre(String nombre) {
        return this.marcaRepository.findByNombreContains(nombre);
    }
}