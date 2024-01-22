package com.dulcemordidaService.gasto.service.impl;

import com.dulcemordidaService.gasto.entity.GastoTipo;
import com.dulcemordidaService.gasto.repository.GastoTipoRepository;
import com.dulcemordidaService.gasto.service.GastoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GastoTipoServiceImpl implements GastoTipoService {
    @Autowired
    GastoTipoRepository gastoTipoRepository;

    @Override
    public GastoTipo createGastoTipo(GastoTipo gastoTipo) {
        return this.gastoTipoRepository.save(gastoTipo);
    }

    @Override
    public List<GastoTipo> getAllGastoTipos() {
        return this.gastoTipoRepository.findAllByOrderByIdDesc();
    }

    @Override
    public GastoTipo updateGastoTipo(GastoTipo gastoTipo) {
        return this.gastoTipoRepository.save(gastoTipo);
    }

    @Override
    public void deleteGastoTipo(int id) {
        this.gastoTipoRepository.deleteById(id);
    }

    @Override
    public GastoTipo getGastoTipoById(int id) {
        return this.gastoTipoRepository.findById(id);
    }

    @Override
    public List<GastoTipo> getGastoTipoByNombre(String nombre) {
        return this.gastoTipoRepository.findByNombreContains(nombre);
    }
}