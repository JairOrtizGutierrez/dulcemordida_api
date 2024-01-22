package com.dulcemordidaService.producto.service.impl;

import com.dulcemordidaService.producto.entity.Estado;
import com.dulcemordidaService.producto.repository.EstadoRepository;
import com.dulcemordidaService.producto.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {
    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public List<Estado> getAllEstados() {
        return this.estadoRepository.findAll();
    }
}