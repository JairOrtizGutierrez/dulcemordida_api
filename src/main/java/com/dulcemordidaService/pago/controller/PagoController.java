package com.dulcemordidaService.pago.controller;

import com.dulcemordidaService.pago.entity.Pago;
import com.dulcemordidaService.pago.entity.PagoFormWrapper;
import com.dulcemordidaService.pago.service.PagoService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pagos")
public class PagoController {
    @Autowired
    PagoService pagoService;
    // Create
    @PostMapping
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago) {
        return ResponseEntity.ok(this.pagoService.createPago(pago));
    }
    // Read
    @GetMapping
    public ResponseEntity<List<Pago>> getAllPagos() {
        return ResponseEntity.ok(this.pagoService.getAllPagos());
    }
    // Update
    @PutMapping
    public ResponseEntity<Pago> updatePago(@RequestBody Pago pago) {
        return ResponseEntity.ok(this.pagoService.updatePago(pago));
    }
    // Delete
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deletePago(@PathVariable("id")int id) {
        this.pagoService.deletePago(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.pagoService.getPagoById(id));
    }

    @GetMapping(value="{fechaInicial}/{fechaFinal}")
    public ResponseEntity<List<Pago>> getPagoByRangoFechas(@PathVariable("fechaInicial") LocalDate fechaInicial, @PathVariable("fechaFinal") LocalDate fechaFinal) {
        return ResponseEntity.ok(this.pagoService.getPagoByRangoFechas(fechaInicial, fechaFinal));
    }

    @GetMapping(value="/daily")
    public ResponseEntity<ObjectNode> getDailyPayments() {
        return ResponseEntity.ok(this.pagoService.getDailyPayments());
    }

    @GetMapping(value="/weeklyTotal")
    public ResponseEntity<List<ObjectNode>> getTotalWeeklyPayments() {
        return ResponseEntity.ok(this.pagoService.getTotalWeeklyPayments());
    }

    @GetMapping(value="/weekly")
    public ResponseEntity<ObjectNode> getWeeklyPayments() {
        return ResponseEntity.ok(this.pagoService.getWeeklyPayments());
    }

    @GetMapping(value="/monthlyTotal")
    public ResponseEntity<ObjectNode> getTotalMonthlyPayments() {
        return ResponseEntity.ok(this.pagoService.getTotalMonthlyPayments());
    }

    @GetMapping(value="/yearlyTotal")
    public ResponseEntity<List<ObjectNode>> getTotalYearlyPayments() {
        return ResponseEntity.ok(this.pagoService.getTotalYearlyPayments());
    }

    @GetMapping(value="/yearly")
    public ResponseEntity<ObjectNode> getYearlyPayments() {
        return ResponseEntity.ok(this.pagoService.getYearlyPayments());
    }

    @PostMapping("/fileSystem")
    public ResponseEntity<Pago> createPago(@ModelAttribute PagoFormWrapper pago) {
        Optional<Pago> optionalPago = this.pagoService.createPago(pago);
        return (optionalPago.isPresent()) ? ResponseEntity.ok(optionalPago.get()) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/fileSystem")
    public ResponseEntity<Pago> updatePago(@ModelAttribute PagoFormWrapper pago) {
        Optional<Pago> optionalPago = this.pagoService.updatePago(pago);
        return (optionalPago.isPresent()) ? ResponseEntity.ok(optionalPago.get()) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}