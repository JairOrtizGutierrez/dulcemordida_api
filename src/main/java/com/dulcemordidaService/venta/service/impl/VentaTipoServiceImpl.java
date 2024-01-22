package com.dulcemordidaService.venta.service.impl;

import com.dulcemordidaService.venta.entity.VentaTipo;
import com.dulcemordidaService.venta.repository.VentaTipoRepository;
import com.dulcemordidaService.venta.service.VentaTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaTipoServiceImpl implements VentaTipoService {
    @Autowired
    VentaTipoRepository ventaTipoRepository;

    @Override
    public VentaTipo createVentaTipo(VentaTipo ventaTipo) {
        return this.ventaTipoRepository.save(ventaTipo);
    }

    @Override
    public List<VentaTipo> getAllVentaTipos() {
        return this.ventaTipoRepository.findAllByOrderByIdDesc();
    }

    @Override
    public VentaTipo updateVentaTipo(VentaTipo ventaTipo) {
        return this.ventaTipoRepository.save(ventaTipo);
    }

    @Override
    public void deleteVentaTipo(int id) {
        this.ventaTipoRepository.deleteById(id);
    }

    @Override
    public VentaTipo getVentaTipoById(int id) {
        return this.ventaTipoRepository.findById(id);
    }

    @Override
    public List<VentaTipo> getVentaTipoByNombre(String nombre) {
        return this.ventaTipoRepository.findByNombreContains(nombre);
    }
}