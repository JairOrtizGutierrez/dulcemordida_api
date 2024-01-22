package com.dulcemordidaService.venta.service.impl;

import com.dulcemordidaService.producto.entity.Producto;
import com.dulcemordidaService.utils.DataConvert;
import com.dulcemordidaService.venta.entity.Venta;
import com.dulcemordidaService.venta.entity.VentaFormWrapper;
import com.dulcemordidaService.venta.entity.VentaTipo;
import com.dulcemordidaService.venta.repository.VentaRepository;
import com.dulcemordidaService.utils.Constants;
import com.dulcemordidaService.utils.Utils;
import com.dulcemordidaService.venta.service.VentaService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = {SQLException.class, DataAccessException.class, IOException.class})
public class VentaServiceImpl implements VentaService {
    @Autowired
    VentaRepository ventaRepository;

    public String folderName = "/ventas";

    @Override
    public Venta createVenta(Venta venta) {
        return this.ventaRepository.save(venta);
    }

    @Override
    public List<Venta> getAllVentas() {
        return this.ventaRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Venta updateVenta(Venta venta) {
        return this.ventaRepository.save(venta);
    }

    @Override
    public void deleteVenta(int id) {
        this.ventaRepository.deleteById(id);
    }

    @Override
    public Venta getVentaById(int id) {
        return this.ventaRepository.findById(id);
    }

    @Override
    public List<Venta> getVentaByRangoFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
        return this.ventaRepository.findByFechaVentaBetweenOrderByIdDesc(fechaInicial, fechaFinal);
    }

    @Override
    public List<ObjectNode> getTotalSales(LocalDate fechaInicial, LocalDate fechaFinal) {
        return DataConvert._toJson(this.ventaRepository.getTotalSales(fechaInicial, fechaFinal));
    }

    @Override
    public ObjectNode getDailySales() {
        return DataConvert._toJson(this.ventaRepository.getDailySales());
    }

    @Override
    public List<ObjectNode> getTotalWeeklySales() {
        return DataConvert._toJson(this.ventaRepository.getTotalWeeklySales());
    }

    @Override
    public ObjectNode getWeeklySales() {
        return DataConvert._toJson(this.ventaRepository.getWeeklySales());
    }

    @Override
    public ObjectNode getTotalMonthlySales() {
        return DataConvert._toJson(this.ventaRepository.getTotalMonthlySales());
    }

    @Override
    public List<ObjectNode> getTotalYearlySales() {
        return DataConvert._toJson(this.ventaRepository.getTotalYearlySales());
    }

    @Override
    public ObjectNode getYearlySales() {
        return DataConvert._toJson(this.ventaRepository.getYearlySales());
    }

    @Override
    public Optional<Venta> createVenta(VentaFormWrapper ventaFormWrapper) {
        File newFile = null;
        try {
            Venta createdVenta;
            if (ventaFormWrapper.getImagen().getOriginalFilename().isEmpty() || ventaFormWrapper.getImagen().getOriginalFilename().isBlank()) {
                createdVenta = this.createVenta(this.fillVentaEntity(ventaFormWrapper, null));
            } else {
                String date = ventaFormWrapper.getFechaVenta().toString().replaceAll("-", "");
                newFile = Utils.transferImage(ventaFormWrapper.getImagen(), "venta_" + date + "_", new File(Constants.FOLDER_PATH + this.folderName));
                createdVenta = this.createVenta(this.fillVentaEntity(ventaFormWrapper, newFile.getName()));
            }
            return Optional.of(createdVenta);
        } catch (Exception exception) {
            System.out.println("createVenta " + exception);
            if (newFile != null && newFile.exists()) newFile.delete();
            return Optional.ofNullable(null);
        }
    }

    @Override
    public Optional<Venta[]> createMultipleVenta(VentaFormWrapper[] ventaFormWrapper) {
        try {
            ArrayList<Venta> ventas = new ArrayList<Venta>();
            for (VentaFormWrapper venta: ventaFormWrapper) ventas.add(this.createVenta(this.fillVentaEntity(venta, null)));
            int n = ventas.size();
            Venta[] arg = new Venta[n];
            return Optional.of(ventas.toArray(arg));
        } catch (Exception exception) {
            System.out.println(exception);
            return Optional.ofNullable(null);
        }
    }

    @Override
    public Optional<Venta> updateVenta(VentaFormWrapper ventaFormWrapper) {
        File newFile = null;
        try {
            String fileName = this.getVentaById(ventaFormWrapper.getId()).getImagen();
            MultipartFile image = ventaFormWrapper.getImagen();
            String formFileName = image != null ? !image.getOriginalFilename().equalsIgnoreCase("null") ? image.getOriginalFilename() : null : null;
            Venta updatedVenta;
            if (formFileName == null || formFileName.isEmpty() || formFileName.isBlank()) {
                updatedVenta = this.updateVenta(this.fillVentaEntity(ventaFormWrapper, null));
            } else {
                if (formFileName.equalsIgnoreCase(fileName)) {
                    updatedVenta = this.updateVenta(this.fillVentaEntity(ventaFormWrapper, fileName));
                } else {
                    File fileToDelete = new File(Constants.FOLDER_PATH + this.folderName + "/" + fileName);

                    String date = ventaFormWrapper.getFechaVenta().toString().replaceAll("-", "");
                    newFile = Utils.transferImage(ventaFormWrapper.getImagen(), "venta_" + date + "_", new File(Constants.FOLDER_PATH + this.folderName));
                    updatedVenta = this.updateVenta(this.fillVentaEntity(ventaFormWrapper, newFile.getName()));

                    if (fileToDelete.exists()) fileToDelete.delete();
                }
            }
            return Optional.of(updatedVenta);
        } catch (Exception exception) {
            System.out.println("updateVenta " + exception);
            if (newFile != null && newFile.exists()) newFile.delete();
            return Optional.ofNullable(null);
        }
    }

    public Venta fillVentaEntity(VentaFormWrapper ventaFormWrapper, String fileName) {
        Producto producto = new Producto();
        producto.setId(ventaFormWrapper.getProductoId());
        VentaTipo ventaTipo = new VentaTipo();
        ventaTipo.setId(ventaFormWrapper.getVentaTipoId());
        Venta venta = new Venta();
        venta.setId(ventaFormWrapper.getId());
        venta.setProducto(producto);
        venta.setCantidad(ventaFormWrapper.getCantidad());
        venta.setMonto(ventaFormWrapper.getMonto());
        venta.setVentaTipo(ventaTipo);
        venta.setFechaVenta(ventaFormWrapper.getFechaVenta());
        venta.setImagen(fileName);
        venta.setDescripcion(ventaFormWrapper.getDescripcion());
        return venta;
    }
}