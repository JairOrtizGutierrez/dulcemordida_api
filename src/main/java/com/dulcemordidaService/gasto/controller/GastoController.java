package com.dulcemordidaService.gasto.controller;

import com.dulcemordidaService.gasto.entity.Gasto;
import com.dulcemordidaService.gasto.entity.GastoFormWrapper;
import com.dulcemordidaService.gasto.service.GastoService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("gastos")
public class GastoController {
    @Autowired
    GastoService gastoService;
    // Create
    @PostMapping
    public ResponseEntity<Gasto> createGasto(@RequestBody Gasto gasto) {
        return ResponseEntity.ok(this.gastoService.createGasto(gasto));
    }
    // Read
    @GetMapping
    public ResponseEntity<List<Gasto>> getAllGastos() {
        return ResponseEntity.ok(this.gastoService.getAllGastos());
    }
    // Update
    @PutMapping
    public ResponseEntity<Gasto> updateGasto(@RequestBody Gasto gasto) {
        return ResponseEntity.ok(this.gastoService.updateGasto(gasto));
    }
    // Delete
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteGasto(@PathVariable("id")int id) {
        this.gastoService.deleteGasto(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{id}")
    public ResponseEntity<Gasto> getGastoById(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.gastoService.getGastoById(id));
    }

    @GetMapping(value="{fechaInicial}/{fechaFinal}")
    public ResponseEntity<List<Gasto>> getGastoByRangoFechas(@PathVariable("fechaInicial") LocalDate fechaInicial, @PathVariable("fechaFinal") LocalDate fechaFinal) {
        return ResponseEntity.ok(this.gastoService.getGastoByRangoFechas(fechaInicial, fechaFinal));
    }

    @GetMapping(value="/daily")
    public ResponseEntity<ObjectNode> getDailyExpenses() {
        return ResponseEntity.ok(this.gastoService.getDailyExpenses());
    }

    @GetMapping(value="/weeklyTotal")
    public ResponseEntity<List<ObjectNode>> getTotalWeeklyExpenses() {
        return ResponseEntity.ok(this.gastoService.getTotalWeeklyExpenses());
    }

    @GetMapping(value="/weekly")
    public ResponseEntity<ObjectNode> getWeeklyExpenses() {
        return ResponseEntity.ok(this.gastoService.getWeeklyExpenses());
    }

    @GetMapping(value="/monthlyTotal")
    public ResponseEntity<ObjectNode> getTotalMonthlyExpenses() {
        return ResponseEntity.ok(this.gastoService.getTotalMonthlyExpenses());
    }

    @GetMapping(value="/yearlyTotal")
    public ResponseEntity<List<ObjectNode>> getTotalYearlyExpenses() {
        return ResponseEntity.ok(this.gastoService.getTotalYearlyExpenses());
    }

    @GetMapping(value="/yearly")
    public ResponseEntity<ObjectNode> getYearlyExpenses() {
        return ResponseEntity.ok(this.gastoService.getYearlyExpenses());
    }

    @PostMapping("/fileSystem")
    public ResponseEntity<Gasto> createGasto(@ModelAttribute GastoFormWrapper gasto) {
        Optional<Gasto> optionalGasto = this.gastoService.createGasto(gasto);
        return (optionalGasto.isPresent()) ? ResponseEntity.ok(optionalGasto.get()) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/fileSystem")
    public ResponseEntity<Gasto> updateGasto(@ModelAttribute GastoFormWrapper gasto) {
        Optional<Gasto> optionalGasto = this.gastoService.updateGasto(gasto);
        return (optionalGasto.isPresent()) ? ResponseEntity.ok(optionalGasto.get()) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}