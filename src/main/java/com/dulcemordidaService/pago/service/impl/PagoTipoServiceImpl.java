package com.dulcemordidaService.pago.service.impl;

import com.dulcemordidaService.pago.entity.PagoTipo;
import com.dulcemordidaService.pago.repository.PagoTipoRepository;
import com.dulcemordidaService.pago.service.PagoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoTipoServiceImpl implements PagoTipoService {
    @Autowired
    PagoTipoRepository pagoTipoRepository;

    @Override
    public PagoTipo createPagoTipo(PagoTipo pagoTipo) {
        return this.pagoTipoRepository.save(pagoTipo);
    }

    @Override
    public List<PagoTipo> getAllPagoTipos() {
        return this.pagoTipoRepository.findAllByOrderByIdDesc();
    }

    @Override
    public PagoTipo updatePagoTipo(PagoTipo pagoTipo) {
        return this.pagoTipoRepository.save(pagoTipo);
    }

    @Override
    public void deletePagoTipo(int id) {
        this.pagoTipoRepository.deleteById(id);
    }

    @Override
    public PagoTipo getPagoTipoById(int id) {
        return this.pagoTipoRepository.findById(id);
    }

    @Override
    public List<PagoTipo> getPagoTipoByNombre(String nombre) {
        return this.pagoTipoRepository.findByNombreContains(nombre);
    }
}