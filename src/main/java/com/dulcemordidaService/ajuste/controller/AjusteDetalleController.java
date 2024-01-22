package com.dulcemordidaService.ajuste.controller;

import com.dulcemordidaService.ajuste.entity.AjusteDetalle;
import com.dulcemordidaService.ajuste.service.AjusteDetalleService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ajustesDetalle")
public class AjusteDetalleController {
    @Autowired
    AjusteDetalleService ajusteDetalleService;
    // Create
    @PostMapping
    public ResponseEntity<AjusteDetalle> createAjusteDetalle(@RequestBody AjusteDetalle ajusteDetalle) {
        return ResponseEntity.ok(this.ajusteDetalleService.createAjusteDetalle(ajusteDetalle));
    }
    // Read
    @GetMapping(value="{ajusteId}")
    public ResponseEntity<List<ObjectNode>> getAllAjustesDetalleByAjusteId(@PathVariable("ajusteId") int ajusteId) {
        return ResponseEntity.ok(this.ajusteDetalleService.getAllAjustesDetalleByAjusteId(ajusteId));
    }
    // Update
    @PutMapping
    public ResponseEntity<AjusteDetalle> updateAjusteDetalle(@RequestBody AjusteDetalle ajusteDetalle) {
        return ResponseEntity.ok(this.ajusteDetalleService.updateAjusteDetalle(ajusteDetalle));
    }
    // Delete
    @DeleteMapping(value="{ajusteId}/{ajusteDetalleId}")
    public ResponseEntity<Void> deleteAjusteDetalle(@PathVariable("ajusteId") int ajusteId, @PathVariable("ajusteDetalleId")int ajusteDetalleId) {
        this.ajusteDetalleService.deleteAjusteDetalle(ajusteDetalleId);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{ajusteDetalleId}")
    public ResponseEntity<AjusteDetalle> getAjusteDetalleById(@PathVariable("ajusteDetalleId")int ajusteDetalleId) {
        return ResponseEntity.ok(this.ajusteDetalleService.getAjusteDetalleById(ajusteDetalleId));
    }

    @GetMapping(value="{ajusteId}/{productoNombre}")
    public ResponseEntity<List<ObjectNode>> getAjusteDetalleByNombreAndAjusteId(@PathVariable("ajusteId") int ajusteId, @PathVariable("productoNombre") String productoNombre) {
        return ResponseEntity.ok(this.ajusteDetalleService.getAjusteDetalleByNombreAndAjusteId(ajusteId, productoNombre));
    }
}