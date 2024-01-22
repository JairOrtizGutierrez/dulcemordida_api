package com.dulcemordidaService.gasto.controller;

import com.dulcemordidaService.gasto.entity.GastoTipo;
import com.dulcemordidaService.gasto.service.GastoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gastoTipos")
public class GastoTipoController {
    @Autowired
    GastoTipoService gastoTipoService;
    // Create
    @PostMapping
    public ResponseEntity<GastoTipo> createGastoTipo(@RequestBody GastoTipo gastoTipo) {
        return ResponseEntity.ok(this.gastoTipoService.createGastoTipo(gastoTipo));
    }
    // Read
    @GetMapping
    public ResponseEntity<List<GastoTipo>> getAllGastoTipos() {
        return ResponseEntity.ok(this.gastoTipoService.getAllGastoTipos());
    }
    // Update
    @PutMapping
    public ResponseEntity<GastoTipo> updateGastoTipo(@RequestBody GastoTipo gastoTipo) {
        return ResponseEntity.ok(this.gastoTipoService.updateGastoTipo(gastoTipo));
    }
    // Delete
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteGastoTipo(@PathVariable("id")int id) {
        this.gastoTipoService.deleteGastoTipo(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{id}")
    public ResponseEntity<GastoTipo> getGastoTipoById(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.gastoTipoService.getGastoTipoById(id));
    }

    @GetMapping(value="{nombre}")
    public ResponseEntity<List<GastoTipo>> getGastoTipoByNombre(@PathVariable("nombre")String nombre) {
        return ResponseEntity.ok(this.gastoTipoService.getGastoTipoByNombre(nombre));
    }
}