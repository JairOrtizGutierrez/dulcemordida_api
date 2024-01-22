package com.dulcemordidaService.producto.controller;

import com.dulcemordidaService.producto.entity.SubCategoria;
import com.dulcemordidaService.producto.service.SubCategoriaService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subCategorias")
public class SubCategoriaController {
    @Autowired
    SubCategoriaService subCategoriaService;
    // Create
    @PostMapping
    public ResponseEntity<SubCategoria> createSubCategoria(@RequestBody SubCategoria subCategoria) {
        return ResponseEntity.ok(this.subCategoriaService.createSubCategoria(subCategoria));
    }
    // Read
    @GetMapping
    public ResponseEntity<List<SubCategoria>> getAllSubCategorias() {
        return ResponseEntity.ok(this.subCategoriaService.getAllSubCategorias());
    }
    // Update
    @PutMapping
    public ResponseEntity<SubCategoria> updateSubCategoria(@RequestBody SubCategoria subCategoria) {
        return ResponseEntity.ok(this.subCategoriaService.updateSubCategoria(subCategoria));
    }
    // Delete
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteSubCategoria(@PathVariable("id")int id) {
        this.subCategoriaService.deleteSubCategoria(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{id}")
    public ResponseEntity<SubCategoria> getSubCategoriaById(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.subCategoriaService.getSubCategoriaById(id));
    }

    @GetMapping(value="{nombre}")
    public ResponseEntity<List<SubCategoria>> getSubCategoriaByNombre(@PathVariable("nombre")String nombre) {
        return ResponseEntity.ok(this.subCategoriaService.getSubCategoriaByNombre(nombre));
    }
}