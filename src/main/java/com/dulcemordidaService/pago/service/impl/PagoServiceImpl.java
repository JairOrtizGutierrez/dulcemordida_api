package com.dulcemordidaService.pago.service.impl;

import com.dulcemordidaService.pago.entity.Pago;
import com.dulcemordidaService.pago.entity.PagoFormWrapper;
import com.dulcemordidaService.pago.entity.PagoTipo;
import com.dulcemordidaService.pago.repository.PagoRepository;
import com.dulcemordidaService.pago.service.PagoService;
import com.dulcemordidaService.utils.Constants;
import com.dulcemordidaService.utils.DataConvert;
import com.dulcemordidaService.utils.Utils;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = {SQLException.class, DataAccessException.class, IOException.class})
public class PagoServiceImpl implements PagoService {
    @Autowired
    PagoRepository pagoRepository;

    public String folderName = "/pagos";

    @Override
    public Pago createPago(Pago pago) {
        return this.pagoRepository.save(pago);
    }

    @Override
    public List<Pago> getAllPagos() {
        return this.pagoRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Pago updatePago(Pago pago) {
        return this.pagoRepository.save(pago);
    }

    @Override
    public void deletePago(int id) {
        this.pagoRepository.deleteById(id);
    }

    @Override
    public Pago getPagoById(int id) {
        return this.pagoRepository.findById(id);
    }

    @Override
    public List<Pago> getPagoByRangoFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
        return this.pagoRepository.findByFechaPagoBetweenOrderByIdDesc(fechaInicial, fechaFinal);
    }

    @Override
    public ObjectNode getDailyPayments() {
        return DataConvert._toJson(this.pagoRepository.getDailyPayments());
    }

    @Override
    public List<ObjectNode> getTotalWeeklyPayments() {
        return DataConvert._toJson(this.pagoRepository.getTotalWeeklyPayments());
    }

    @Override
    public ObjectNode getWeeklyPayments() {
        return DataConvert._toJson(this.pagoRepository.getWeeklyPayments());
    }

    @Override
    public ObjectNode getTotalMonthlyPayments() {
        return DataConvert._toJson(this.pagoRepository.getTotalMonthlyPayments());
    }

    @Override
    public List<ObjectNode> getTotalYearlyPayments() {
        return DataConvert._toJson(this.pagoRepository.getTotalYearlyPayments());
    }

    @Override
    public ObjectNode getYearlyPayments() {
        return DataConvert._toJson(this.pagoRepository.getYearlyPayments());
    }

    @Override
    public Optional<Pago> createPago(PagoFormWrapper pagoFormWrapper) {
        File newFile = null;
        try {
            Pago createdPago;
            if (pagoFormWrapper.getImagen().getOriginalFilename().isEmpty() || pagoFormWrapper.getImagen().getOriginalFilename().isBlank()) {
                createdPago = this.createPago(this.fillPagoEntity(pagoFormWrapper, null));
            } else {
                String date = pagoFormWrapper.getFechaPago().toString().replaceAll("-", "");
                newFile = Utils.transferImage(pagoFormWrapper.getImagen(), "pago_" + date + "_", new File(Constants.FOLDER_PATH + this.folderName));
                createdPago = this.createPago(this.fillPagoEntity(pagoFormWrapper, newFile.getName()));
            }
            return Optional.of(createdPago);
        } catch (Exception exception) {
            System.out.println("createPago " + exception);
            if (newFile != null && newFile.exists()) newFile.delete();
            return Optional.ofNullable(null);
        }
    }

    @Override
    public Optional<Pago> updatePago(PagoFormWrapper pagoFormWrapper) {
        File newFile = null;
        try {
            String fileName = this.getPagoById(pagoFormWrapper.getId()).getImagen();
            MultipartFile image = pagoFormWrapper.getImagen();
            String formFileName = image != null ? !image.getOriginalFilename().equalsIgnoreCase("null") ? image.getOriginalFilename() : null : null;
            Pago updatedPago;

            if (formFileName == null || formFileName.isEmpty() || formFileName.isBlank()) {
                updatedPago = this.updatePago(this.fillPagoEntity(pagoFormWrapper, null));
            } else {
                if (formFileName.equalsIgnoreCase(fileName)) {
                    updatedPago = this.updatePago(this.fillPagoEntity(pagoFormWrapper, fileName));
                } else {
                    File fileToDelete = new File(Constants.FOLDER_PATH + this.folderName + "/" + fileName);

                    String date = pagoFormWrapper.getFechaPago().toString().replaceAll("-", "");
                    newFile = Utils.transferImage(pagoFormWrapper.getImagen(), "pago_" + date + "_", new File(Constants.FOLDER_PATH + this.folderName));
                    updatedPago = this.updatePago(this.fillPagoEntity(pagoFormWrapper, newFile.getName()));

                    if (fileToDelete.exists()) fileToDelete.delete();
                }
            }
            return Optional.of(updatedPago);
        } catch (Exception exception) {
            System.out.println("updatePago " + exception);
            if (newFile != null && newFile.exists()) newFile.delete();
            return Optional.ofNullable(null);
        }
    }

    public Pago fillPagoEntity(PagoFormWrapper pagoFormWrapper, String fileName) {
        PagoTipo pagoTipo = new PagoTipo();
        pagoTipo.setId(pagoFormWrapper.getPagoTipoId());
        Pago pago = new Pago();
        pago.setId(pagoFormWrapper.getId());
        pago.setNombre(pagoFormWrapper.getNombre());
        pago.setMonto(pagoFormWrapper.getMonto());
        pago.setPagoTipo(pagoTipo);
        pago.setFechaPago(pagoFormWrapper.getFechaPago());
        pago.setImagen(fileName);
        pago.setDescripcion(pagoFormWrapper.getDescripcion());
        return pago;
    }
}
