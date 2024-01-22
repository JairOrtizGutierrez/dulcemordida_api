package com.dulcemordidaService.producto.controller;

import com.dulcemordidaService.producto.entity.Medida;
import com.dulcemordidaService.producto.service.MedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medidas")
public class MedidaController {
    @Autowired
    MedidaService medidaService;
    // Create
    @PostMapping
    public ResponseEntity<Medida> createMedida(@RequestBody Medida medida) {
        return ResponseEntity.ok(this.medidaService.createMedida(medida));
    }
    // Read
    @GetMapping
    public ResponseEntity<List<Medida>> getAllMedidas() {
        return ResponseEntity.ok(this.medidaService.getAllMedidas());
    }
    // Update
    @PutMapping
    public ResponseEntity<Medida> updateMedida(@RequestBody Medida medida) {
        return ResponseEntity.ok(this.medidaService.updateMedida(medida));
    }
    // Delete
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteMedida(@PathVariable("id")int id) {
        this.medidaService.deleteMedida(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{id}")
    public ResponseEntity<Medida> getMedidaById(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.medidaService.getMedidaById(id));
    }

    @GetMapping(value="{nombre}")
    public ResponseEntity<List<Medida>> getMedidaByNombre(@PathVariable("nombre")String nombre) {
        return ResponseEntity.ok(this.medidaService.getMedidaByNombre(nombre));
    }

    @GetMapping(value="productId/{id}")
    public ResponseEntity<Medida> getMedidaByProductId(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.medidaService.getMedidaByProductId(id));
    }
}