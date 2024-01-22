package com.dulcemordidaService.ajuste.service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.LocalDate;
import java.util.List;

public interface AjusteService {
    List<ObjectNode> getAllAjustes();

    List<ObjectNode> getAjusteByRangoFechas(LocalDate fechaInicial, LocalDate fechaFinal);
}