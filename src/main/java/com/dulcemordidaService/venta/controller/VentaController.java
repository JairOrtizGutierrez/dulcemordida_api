package com.dulcemordidaService.venta.controller;

import com.dulcemordidaService.venta.entity.Venta;
import com.dulcemordidaService.venta.entity.VentaFormWrapper;
import com.dulcemordidaService.venta.entity.VentaFormWrapperTest;
import com.dulcemordidaService.venta.service.VentaService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ventas")
public class VentaController {
    @Autowired
    VentaService ventaService;
    // Create
    @PostMapping
    public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
        return ResponseEntity.ok(this.ventaService.createVenta(venta));
    }
    // Read
    @GetMapping
    public ResponseEntity<List<Venta>> getAllVentas() {
        return ResponseEntity.ok(this.ventaService.getAllVentas());
    }
    // Update
    @PutMapping
    public ResponseEntity<Venta> updateVenta(@RequestBody Venta venta) {
        return ResponseEntity.ok(this.ventaService.updateVenta(venta));
    }
    // Delete
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable("id")int id) {
        this.ventaService.deleteVenta(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.ventaService.getVentaById(id));
    }

    @GetMapping(value="{fechaInicial}/{fechaFinal}")
    public ResponseEntity<List<Venta>> getVentaByRangoFechas(@PathVariable("fechaInicial") LocalDate fechaInicial, @PathVariable("fechaFinal") LocalDate fechaFinal) {
        return ResponseEntity.ok(this.ventaService.getVentaByRangoFechas(fechaInicial, fechaFinal));
    }

    @GetMapping(value="/total/{fechaInicial}/{fechaFinal}")
    public ResponseEntity<List<ObjectNode>> getTotalSales(@PathVariable("fechaInicial") LocalDate fechaInicial, @PathVariable("fechaFinal") LocalDate fechaFinal) {
        return ResponseEntity.ok(this.ventaService.getTotalSales(fechaInicial, fechaFinal));
    }

    @GetMapping(value="/daily")
    public ResponseEntity<ObjectNode> getDailySales() {
        return ResponseEntity.ok(this.ventaService.getDailySales());
    }

    @GetMapping(value="/weeklyTotal")
    public ResponseEntity<List<ObjectNode>> getWeeklyTotalVenta() {
        return ResponseEntity.ok(this.ventaService.getTotalWeeklySales());
    }

    @GetMapping(value="/weekly")
    public ResponseEntity<ObjectNode> getWeeklySales() {
        return ResponseEntity.ok(this.ventaService.getWeeklySales());
    }

    @GetMapping(value="/monthlyTotal")
    public ResponseEntity<ObjectNode> getMonthlyTotalVenta() {
        return ResponseEntity.ok(this.ventaService.getTotalMonthlySales());
    }

    @GetMapping(value="/yearlyTotal")
    public ResponseEntity<List<ObjectNode>> getTotalYearlySales() {
        return ResponseEntity.ok(this.ventaService.getTotalYearlySales());
    }

    @GetMapping(value="/yearly")
    public ResponseEntity<ObjectNode> getYearlySales() {
        return ResponseEntity.ok(this.ventaService.getYearlySales());
    }

    @PostMapping("/fileSystem")
    public ResponseEntity<Venta> createVenta(@ModelAttribute VentaFormWrapper venta) {
        Optional<Venta> optionalVenta = this.ventaService.createVenta(venta);
        return (optionalVenta.isPresent()) ? ResponseEntity.ok(optionalVenta.get()) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping("/fileSystemTest")
    public ResponseEntity<Venta[]> createVentaTest(@ModelAttribute VentaFormWrapperTest ventas) {
        ArrayList<VentaFormWrapper> ventasFormWrapperArray = new ArrayList<VentaFormWrapper>();
        int length = ventas.getProductoId().length;
        for (int i = 0; i < length; i++) {
            VentaFormWrapper ventaFormWrapper = new VentaFormWrapper();
            ventaFormWrapper.setId(0);
            ventaFormWrapper.setProductoId(ventas.getProductoId()[i]);
            ventaFormWrapper.setCantidad(ventas.getCantidad()[i]);
            ventaFormWrapper.setMonto(ventas.getMonto()[i]);
            ventaFormWrapper.setVentaTipoId(1);
            ventaFormWrapper.setFechaVenta(ventas.getFechaVenta());
            ventaFormWrapper.setImagen(null);
            ventaFormWrapper.setDescripcion("");
            ventasFormWrapperArray.add(ventaFormWrapper);
        }
        int n = ventasFormWrapperArray.size();
        VentaFormWrapper[] arg = new VentaFormWrapper[n];
        System.out.println(ventasFormWrapperArray.toArray(arg));
        Optional<Venta[]> optionalVentas = this.ventaService.createMultipleVenta(ventasFormWrapperArray.toArray(arg));
        return (optionalVentas.isPresent()) ? ResponseEntity.ok(optionalVentas.get()) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/fileSystem")
    public ResponseEntity<Venta> updateVenta(@ModelAttribute VentaFormWrapper venta) {
        Optional<Venta> optionalVenta = this.ventaService.updateVenta(venta);
        return (optionalVenta.isPresent()) ? ResponseEntity.ok(optionalVenta.get()) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}