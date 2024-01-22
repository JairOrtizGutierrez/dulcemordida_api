package com.dulcemordidaService.producto.controller;

import com.dulcemordidaService.producto.entity.Marca;
import com.dulcemordidaService.producto.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("marcas")
public class MarcaController {
    @Autowired
    MarcaService marcaService;
    // Create
    @PostMapping
    public ResponseEntity<Marca> createMarca(@RequestBody Marca marca) {
        return ResponseEntity.ok(this.marcaService.createMarca(marca));
    }
    // Read
    @GetMapping
    public ResponseEntity<List<Marca>> getAllMarcas() {
        return ResponseEntity.ok(this.marcaService.getAllMarcas());
    }
    // Update
    @PutMapping
    public ResponseEntity<Marca> updateMarca(@RequestBody Marca marca) {
        return ResponseEntity.ok(this.marcaService.updateMarca(marca));
    }
    // Delete
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteMarca(@PathVariable("id")int id) {
        this.marcaService.deleteMarca(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{id}")
    public ResponseEntity<Marca> getMarcaById(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.marcaService.getMarcaById(id));
    }

    @GetMapping(value="{nombre}")
    public ResponseEntity<List<Marca>> getMarcaByNombre(@PathVariable("nombre")String nombre) {
        return ResponseEntity.ok(this.marcaService.getMarcaByNombre(nombre));
    }
}