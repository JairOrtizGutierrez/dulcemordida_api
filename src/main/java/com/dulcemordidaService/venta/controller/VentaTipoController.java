package com.dulcemordidaService.venta.controller;

import com.dulcemordidaService.venta.entity.VentaTipo;
import com.dulcemordidaService.venta.service.VentaTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ventaTipos")
public class VentaTipoController {
    @Autowired
    VentaTipoService ventaTipoService;
    // Create
    @PostMapping
    public ResponseEntity<VentaTipo> createVentaTipo(@RequestBody VentaTipo ventaTipo) {
        return ResponseEntity.ok(this.ventaTipoService.createVentaTipo(ventaTipo));
    }
    // Read
    @GetMapping
    public ResponseEntity<List<VentaTipo>> getAllVentaTipos() {
        return ResponseEntity.ok(this.ventaTipoService.getAllVentaTipos());
    }
    // Update
    @PutMapping
    public ResponseEntity<VentaTipo> updateVentaTipo(@RequestBody VentaTipo ventaTipo) {
        return ResponseEntity.ok(this.ventaTipoService.updateVentaTipo(ventaTipo));
    }
    // Delete
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteVentaTipo(@PathVariable("id")int id) {
        this.ventaTipoService.deleteVentaTipo(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{id}")
    public ResponseEntity<VentaTipo> getVentaTipoById(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.ventaTipoService.getVentaTipoById(id));
    }

    @GetMapping(value="{nombre}")
    public ResponseEntity<List<VentaTipo>> getVentaTipoByNombre(@PathVariable("nombre")String nombre) {
        return ResponseEntity.ok(this.ventaTipoService.getVentaTipoByNombre(nombre));
    }
}