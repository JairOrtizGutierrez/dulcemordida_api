package com.dulcemordidaService.producto.controller;

import com.dulcemordidaService.producto.entity.Categoria;
import com.dulcemordidaService.producto.entity.SubCategoria;
import com.dulcemordidaService.producto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;
    // Create
    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(this.categoriaService.createCategoria(categoria));
    }
    // Read
    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        return ResponseEntity.ok(this.categoriaService.getAllCategorias());
    }
    // Update
    @PutMapping
    public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(this.categoriaService.updateCategoria(categoria));
    }
    // Delete
    @DeleteMapping(value="{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable("id")int id) {
        this.categoriaService.deleteCategoria(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value="id/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.categoriaService.getCategoriaById(id));
    }

    @GetMapping(value="{nombre}")
    public ResponseEntity<List<Categoria>> getCategoriaByNombre(@PathVariable("nombre")String nombre) {
        return ResponseEntity.ok(this.categoriaService.getCategoriaByNombre(nombre));
    }

    @GetMapping(value="{id}/subcategorias")
    public ResponseEntity<List<SubCategoria>> getSubCategoriaByCategoryId(@PathVariable("id")int id) {
        return ResponseEntity.ok(this.categoriaService.getSubCategoriaByCategoryId(id));
    }
}