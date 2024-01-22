package com.dulcemordidaService.pago.controller;

import com.dulcemordidaService.pago.entity.PagoTipo;
import com.dulcemordidaService.pago.service.PagoTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pagoTipos")
public class PagoTipoController {
    @Autowired
    PagoTipoService pagoTipoService;
    // Create
    @PostMapping
    public ResponseEntity<PagoTipo> createPagoTipo(@RequestBody PagoTipo pagoTipo) {
        return ResponseEntity.ok(this.pagoTipoService.createPagoTipo(pagoTipo));
    }
    // Read
    @GetMapping
    public ResponseEntity<List<PagoTipo>> getAllPagoTipos() {
        return ResponseEntity.ok(this.pagoTipoService.getAllPagoTipos());
    }
    // Update
    @PutMapping
    public ResponseEntity<PagoTipo> updatePagoTipo(@RequestBody PagoTipo pagoTipo) {
        return ResponseEntity.ok(this.pagoTipoService.updatePagoTipo(pagoTipo));
    }
    // Delete
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deletePagoTipo(@PathVariable("id")int id) {
        this.pagoTipoService.deletePagoTipo(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{id}")
    public ResponseEntity<PagoTipo> getPagoTipoById(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.pagoTipoService.getPagoTipoById(id));
    }

    @GetMapping(value="{nombre}")
    public ResponseEntity<List<PagoTipo>> getPagoTipoByNombre(@PathVariable("nombre")String nombre) {
        return ResponseEntity.ok(this.pagoTipoService.getPagoTipoByNombre(nombre));
    }
}