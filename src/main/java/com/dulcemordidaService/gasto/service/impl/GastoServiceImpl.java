package com.dulcemordidaService.gasto.service.impl;

import com.dulcemordidaService.gasto.entity.Gasto;
import com.dulcemordidaService.gasto.entity.GastoFormWrapper;
import com.dulcemordidaService.gasto.entity.GastoTipo;
import com.dulcemordidaService.gasto.repository.GastoRepository;
import com.dulcemordidaService.gasto.service.GastoService;
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
public class GastoServiceImpl implements GastoService {
    @Autowired
    GastoRepository gastoRepository;

    public String folderName = "/gastos";

    @Override
    public Gasto createGasto(Gasto gasto) {
        return this.gastoRepository.save(gasto);
    }

    @Override
    public List<Gasto> getAllGastos() {
        return this.gastoRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Gasto updateGasto(Gasto gasto) {
        return this.gastoRepository.save(gasto);
    }

    @Override
    public void deleteGasto(int id) {
        this.gastoRepository.deleteById(id);
    }

    @Override
    public Gasto getGastoById(int id) {
        return this.gastoRepository.findById(id);
    }

    @Override
    public List<Gasto> getGastoByRangoFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
        return this.gastoRepository.findByFechaGastoBetweenOrderByIdDesc(fechaInicial, fechaFinal);
    }

    @Override
    public ObjectNode getDailyExpenses() {
        return DataConvert._toJson(this.gastoRepository.getDailyExpenses());
    }

    @Override
    public List<ObjectNode> getTotalWeeklyExpenses() {
        return DataConvert._toJson(this.gastoRepository.getTotalWeeklyExpenses());
    }

    @Override
    public ObjectNode getWeeklyExpenses() {
        return DataConvert._toJson(this.gastoRepository.getWeeklyExpenses());
    }

    @Override
    public ObjectNode getTotalMonthlyExpenses() {
        return DataConvert._toJson(this.gastoRepository.getTotalMonthlyExpenses());
    }

    @Override
    public List<ObjectNode> getTotalYearlyExpenses() {
        return DataConvert._toJson(this.gastoRepository.getTotalYearlyExpenses());
    }

    @Override
    public ObjectNode getYearlyExpenses() {
        return DataConvert._toJson(this.gastoRepository.getYearlyExpenses());
    }

    @Override
    public Optional<Gasto> createGasto(GastoFormWrapper gastoFormWrapper) {
        File newFile = null;
        try {
            Gasto createdGasto;
            if (gastoFormWrapper.getImagen().getOriginalFilename().isEmpty() || gastoFormWrapper.getImagen().getOriginalFilename().isBlank()) {
                createdGasto = this.createGasto(this.fillGastoEntity(gastoFormWrapper, null));
            } else {
                String date = gastoFormWrapper.getFechaGasto().toString().replaceAll("-", "");
                newFile = Utils.transferImage(gastoFormWrapper.getImagen(), "gasto_" + date + "_", new File(Constants.FOLDER_PATH + this.folderName));
                createdGasto = this.createGasto(this.fillGastoEntity(gastoFormWrapper, newFile.getName()));
            }
            return Optional.of(createdGasto);
        } catch (Exception exception) {
            System.out.println("createGasto " + exception);
            if (newFile != null && newFile.exists()) newFile.delete();
            return Optional.ofNullable(null);
        }
    }

    @Override
    public Optional<Gasto> updateGasto(GastoFormWrapper gastoFormWrapper) {
        File newFile = null;
        try {
            String fileName = this.getGastoById(gastoFormWrapper.getId()).getImagen();
            MultipartFile image = gastoFormWrapper.getImagen();
            String formFileName = image != null ? !image.getOriginalFilename().equalsIgnoreCase("null") ? image.getOriginalFilename() : null : null;
            Gasto updatedGasto;

            if (formFileName == null || formFileName.isEmpty() || formFileName.isBlank()) {
                updatedGasto = this.updateGasto(this.fillGastoEntity(gastoFormWrapper, null));
            } else {
                if (formFileName.equalsIgnoreCase(fileName)) {
                    updatedGasto = this.updateGasto(this.fillGastoEntity(gastoFormWrapper, fileName));
                } else {
                    File fileToDelete = new File(Constants.FOLDER_PATH + this.folderName + "/" + fileName);

                    String date = gastoFormWrapper.getFechaGasto().toString().replaceAll("-", "");
                    newFile = Utils.transferImage(gastoFormWrapper.getImagen(), "gasto_" + date + "_", new File(Constants.FOLDER_PATH + this.folderName));
                    updatedGasto = this.updateGasto(this.fillGastoEntity(gastoFormWrapper, newFile.getName()));

                    if (fileToDelete.exists()) fileToDelete.delete();
                }
            }
            return Optional.of(updatedGasto);
        } catch (Exception exception) {
            System.out.println("updateGasto " + exception);
            if (newFile != null && newFile.exists()) newFile.delete();
            return Optional.ofNullable(null);
        }
    }

    public Gasto fillGastoEntity(GastoFormWrapper gastoFormWrapper, String fileName) {
        GastoTipo gastoTipo = new GastoTipo();
        gastoTipo.setId(gastoFormWrapper.getGastoTipoId());
        Gasto gasto = new Gasto();
        gasto.setId(gastoFormWrapper.getId());
        gasto.setNombre(gastoFormWrapper.getNombre());
        gasto.setMonto(gastoFormWrapper.getMonto());
        gasto.setGastoTipo(gastoTipo);
        gasto.setFechaGasto(gastoFormWrapper.getFechaGasto());
        gasto.setImagen(fileName);
        gasto.setDescripcion(gastoFormWrapper.getDescripcion());
        return gasto;
    }
}