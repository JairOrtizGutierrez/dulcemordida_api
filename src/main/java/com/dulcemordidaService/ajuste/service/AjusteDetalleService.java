package com.dulcemordidaService.ajuste.service;

import com.dulcemordidaService.ajuste.entity.AjusteDetalle;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface AjusteDetalleService {
    AjusteDetalle createAjusteDetalle(AjusteDetalle ajusteDetalle);

    List<ObjectNode> getAllAjustesDetalleByAjusteId(int ajusteId);

    AjusteDetalle updateAjusteDetalle(AjusteDetalle ajusteDetalle);

    void deleteAjusteDetalle(int ajusteDetalleId);

    AjusteDetalle getAjusteDetalleById(int ajusteDetalleId);

    List<ObjectNode> getAjusteDetalleByNombreAndAjusteId(int ajusteId, String productoNombre);
}