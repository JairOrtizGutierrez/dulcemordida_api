package com.dulcemordidaService.ajuste.service.impl;

import com.dulcemordidaService.ajuste.entity.Ajuste;
import com.dulcemordidaService.ajuste.entity.AjusteDetalle;
import com.dulcemordidaService.ajuste.repository.AjusteDetalleRepository;
import com.dulcemordidaService.ajuste.repository.AjusteRepository;
import com.dulcemordidaService.ajuste.service.AjusteDetalleService;
import com.dulcemordidaService.utils.DataConvert;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AjusteDetalleServiceImpl implements AjusteDetalleService {
    @Autowired
    AjusteDetalleRepository ajusteDetalleRepository;

    @Autowired
    AjusteRepository ajusteRepository;

    @Override
    public AjusteDetalle createAjusteDetalle(AjusteDetalle ajusteDetalle) {
        Ajuste ajuste = this.getOrcreateAjuste(ajusteDetalle);
        ajusteDetalle.setAjuste(ajuste);
        return ajusteDetalleRepository.save(ajusteDetalle);
    }

    @Override
    public List<ObjectNode> getAllAjustesDetalleByAjusteId(int ajusteId) {
        return DataConvert._toJson(this.ajusteDetalleRepository.findByAjusteId(ajusteId));
    }

    @Override
    public AjusteDetalle updateAjusteDetalle(AjusteDetalle ajusteDetalle) {
        Ajuste ajuste = this.getOrcreateAjuste(ajusteDetalle);
        ajusteDetalle.setAjuste(ajuste);
        return this.ajusteDetalleRepository.save(ajusteDetalle);
    }

    @Override
    public void deleteAjusteDetalle(int ajusteDetalleId) {
        this.ajusteDetalleRepository.deleteById(ajusteDetalleId);
    }

    @Override
    public AjusteDetalle getAjusteDetalleById(int ajusteDetalleId) {
        return ajusteDetalleRepository.findById(ajusteDetalleId);
    }

    @Override
    public List<ObjectNode> getAjusteDetalleByNombreAndAjusteId(int ajusteId, String productoNombre) {
        return DataConvert._toJson(this.ajusteDetalleRepository.findByAjusteIdAndProductName(ajusteId, productoNombre));
    }

    public Ajuste getOrcreateAjuste(AjusteDetalle ajusteDetalle) {
        LocalDate localDate = ajusteDetalle.getAjuste().getFechaStock();
        Ajuste ajuste = ajusteRepository.findByFechaStock(localDate);
        if (ajuste == null) {
            Ajuste newAjuste = new Ajuste();
            newAjuste.setFechaStock(localDate);
            ajuste = newAjuste;
            ajusteRepository.save(ajuste);
        }
        return ajuste;
    }
 }