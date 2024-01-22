package com.dulcemordidaService.producto.controller;

import com.dulcemordidaService.pago.entity.Pago;
import com.dulcemordidaService.pago.entity.PagoFormWrapper;
import com.dulcemordidaService.producto.entity.Producto;
import com.dulcemordidaService.producto.entity.ProductoFormWrapper;
import com.dulcemordidaService.producto.service.ProductoService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;
    // Create
    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(this.productoService.createProducto(producto));
    }
    // Read
    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        return ResponseEntity.ok(this.productoService.getAllProductos());
    }
    // Update
    @PutMapping
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(this.productoService.updateProducto(producto));
    }
    // Delete
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable("id")int id) {
        this.productoService.deleteProducto(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.productoService.getProductoById(id));
    }

    @GetMapping(value="{nombre}")
    public ResponseEntity<List<Producto>> getProductoByNombre(@PathVariable("nombre")String nombre) {
        return ResponseEntity.ok(this.productoService.getProductoByNombre(nombre));
    }

    @PostMapping("/fileSystem")
    public ResponseEntity<Producto> createProducto(@ModelAttribute ProductoFormWrapper producto) {
        Optional<Producto> optionalProducto = this.productoService.createProducto(producto);
        return (optionalProducto.isPresent()) ? ResponseEntity.ok(optionalProducto.get()) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/fileSystem")
    public ResponseEntity<Producto> updateProducto(@ModelAttribute ProductoFormWrapper producto) {
        Optional<Producto> optionalProducto = this.productoService.updateProducto(producto);
        return (optionalProducto.isPresent()) ? ResponseEntity.ok(optionalProducto.get()) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}