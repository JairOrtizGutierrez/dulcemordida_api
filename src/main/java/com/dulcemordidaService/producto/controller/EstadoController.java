package com.dulcemordidaService.producto.controller;

import com.dulcemordidaService.producto.entity.Estado;
import com.dulcemordidaService.producto.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estados")
public class EstadoController {
    @Autowired
    EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Estado>> getAllEstados() {
        return ResponseEntity.ok(this.estadoService.getAllEstados());
    }
}