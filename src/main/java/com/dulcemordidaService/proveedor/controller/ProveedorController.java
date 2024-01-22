package com.dulcemordidaService.proveedor.controller;

import com.dulcemordidaService.proveedor.entity.Proveedor;
import com.dulcemordidaService.proveedor.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proveedores")
public class ProveedorController {
    @Autowired
    ProveedorService proveedorService;
    // Create
    @PostMapping
    public ResponseEntity<Proveedor> createProveedor(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(this.proveedorService.createProveedor(proveedor));
    }
    // Read
    @GetMapping
    public ResponseEntity<List<Proveedor>> getAllProveedores() {
        return ResponseEntity.ok(this.proveedorService.getAllProveedores());
    }
    // Update
    @PutMapping
    public ResponseEntity<Proveedor> updateProveedor(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(this.proveedorService.updateProveedor(proveedor));
    }
    // Delete
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable("id")int id) {
        this.proveedorService.deleteProveedor(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.proveedorService.getProveedorById(id));
    }

    @GetMapping(value="{nombre}")
    public ResponseEntity<List<Proveedor>> getProveedorByNombre(@PathVariable("nombre")String nombre) {
        return ResponseEntity.ok(this.proveedorService.getProveedorByNombre(nombre));
    }
}