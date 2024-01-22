package com.dulcemordidaService.producto.service.impl;

import com.dulcemordidaService.producto.entity.Medida;
import com.dulcemordidaService.producto.repository.MedidaRepository;
import com.dulcemordidaService.producto.service.MedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedidaServiceImpl implements MedidaService {
    @Autowired
    MedidaRepository medidaRepository;

    @Override
    public Medida createMedida(Medida medida) {
        return this.medidaRepository.save(medida);
    }

    @Override
    public List<Medida> getAllMedidas() {
        return this.medidaRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Medida updateMedida(Medida medida) {
        return this.medidaRepository.save(medida);
    }

    @Override
    public void deleteMedida(int id) {
        this.medidaRepository.deleteById(id);
    }

    @Override
    public Medida getMedidaById(int id) {
        return this.medidaRepository.findById(id);
    }

    @Override
    public List<Medida> getMedidaByNombre(String nombre) {
        return this.medidaRepository.findByNombreContains(nombre);
    }

    @Override
    public Medida getMedidaByProductId(int id) {
        return this.medidaRepository.findByProductoId(id);
    }
}