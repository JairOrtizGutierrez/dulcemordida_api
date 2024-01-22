package com.dulcemordidaService.ajuste.service.impl;

import com.dulcemordidaService.ajuste.entity.AjusteTipo;
import com.dulcemordidaService.ajuste.repository.AjusteTipoRepository;
import com.dulcemordidaService.ajuste.service.AjusteTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AjusteTipoServiceImpl implements AjusteTipoService {
    @Autowired
    AjusteTipoRepository ajusteTipoRepository;

    @Override
    public List<AjusteTipo> getAllAjustesTipo() {
        return this.ajusteTipoRepository.findAll();
    }
}