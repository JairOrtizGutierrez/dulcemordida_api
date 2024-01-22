package com.dulcemordidaService.ajuste.controller;

import com.dulcemordidaService.ajuste.service.AjusteService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("ajustes")
public class AjusteController {
    @Autowired
    AjusteService ajusteService;

    @GetMapping
    public ResponseEntity<List<ObjectNode>> getAllAjustes() {
        return ResponseEntity.ok(this.ajusteService.getAllAjustes());
    }

    @GetMapping(value="{fechaInicial}/{fechaFinal}")
    public ResponseEntity<List<ObjectNode>> getAjusteByRangoFechas(@PathVariable("fechaInicial") LocalDate fechaInicial, @PathVariable("fechaFinal") LocalDate fechaFinal) {
        return ResponseEntity.ok(this.ajusteService.getAjusteByRangoFechas(fechaInicial, fechaFinal));
    }
}