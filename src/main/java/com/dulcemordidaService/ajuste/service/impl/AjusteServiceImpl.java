package com.dulcemordidaService.ajuste.service.impl;

import com.dulcemordidaService.ajuste.repository.AjusteRepository;
import com.dulcemordidaService.ajuste.service.AjusteService;
import com.dulcemordidaService.utils.DataConvert;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AjusteServiceImpl implements AjusteService {
    @Autowired
    AjusteRepository ajusteRepository;

    @Override
    public List<ObjectNode> getAllAjustes() {
        return DataConvert._toJson(this.ajusteRepository.findAjustes());
    }

    @Override
    public List<ObjectNode> getAjusteByRangoFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
        return DataConvert._toJson(this.ajusteRepository.findByFechaStockBetween(fechaInicial, fechaFinal));
    }
}